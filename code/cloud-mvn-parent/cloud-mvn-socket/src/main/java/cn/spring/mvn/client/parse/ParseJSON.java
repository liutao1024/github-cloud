package cn.spring.mvn.client.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.spring.mvn.client.model.ApSysColumn;
import cn.spring.mvn.client.model.repository.ApSysColumnRepository;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author LiuTao @date 2018年10月17日 上午9:51:11
 * @ClassName: ParseJSON 
 * @Description: JSON封装解析类
 */
@Service("ParseJSON")
@SuppressWarnings("unchecked")
public class ParseJSON implements Parse {

	private static Logger logger = LoggerFactory.getLogger(ParseJSON.class);

	private final static String SPLIT = ",";

	@Resource
	private ApSysColumnRepository apSysColumnRepository;

	@Override
	public String encap(String msgCd, Map<String, Object> data) {
		StringBuilder reqStr = new StringBuilder();
		logger.debug("JSON封装报文======data======" + data);
		List<ApSysColumn> columns = apSysColumnRepository.findByMsgCdRoot(msgCd);
		reqStr.append("{");
		for (ApSysColumn column : columns) {
			logger.debug("====cyclingFlag===" + column.getCyclingFlag());
			if ("Y".equals(column.getCyclingFlag())) {
				// 处理循环
				List<Map<String, Object>> list = (List<Map<String, Object>>) data.get(column.getColumnMapping());
				String childStr = encapCyclingColumn(list, column.getColumnCd(), msgCd);
				reqStr.append("\"").append(column.getColumnCd()).append("\"").append(":[").append(childStr).append("]");
			} else if ("O".equals(column.getCyclingFlag())) {
				// 处理子对象
				String childStr = encapChildColumn(data, column.getColumnCd(), msgCd);
				reqStr.append("\"").append(column.getColumnCd()).append("\"").append(":").append(childStr);
			} else {
				String value = ParseZTIPS.getValue(data, column);
				if (StringUtils.isEmpty(value)) {
					// 为空时,返回值是null
					value = "";
				}
				reqStr.append("\"").append(column.getColumnCd()).append("\"").append(":").append("\"").append(value).append("\"");
			}
			if (columns.indexOf(column) != columns.size() - 1) {
				reqStr.append(SPLIT);
			}
		}
		reqStr.append("}");
		return reqStr.toString();
	}

	@Override
	public Map<String, Object> unencap(String msgCd, String msg) {
		Map<String, Object> rspData = new ConcurrentHashMap<String, Object>();
		try {
			Map<String, Object> map = new ObjectMapper().readValue(msg, Map.class);
			logger.debug("=======转换后数据========" + map);
			List<ApSysColumn> columns = apSysColumnRepository.findByMsgCdRoot(msgCd);
			for (ApSysColumn column : columns) {
				String colCd = column.getColumnCd();
				if ("Y".equals(column.getCyclingFlag())) {
					// 处理循环节点
					List<Map<String, Object>> list = (List<Map<String, Object>>) map.get(colCd);
					List<Map<String, Object>> ls = unencapCyclingColumn(list, colCd, msgCd);
					rspData.put(column.getColumnMapping(), ls);
				} else if ("O".equals(column.getCyclingFlag())) {
					// 处理子节点
					String childMsg = JSONObject.toJSONString(map.get(colCd));
					Map<String, Object> m = new ObjectMapper().readValue(childMsg, Map.class);
					Map<String, Object> data = unencapChildColumn((Map<String, Object>) m, colCd, msgCd);
					rspData.putAll(data);
				} else {
					Object val = map.get(colCd);
					if (val == null) {//返回数据中没有该项或该项值为空
						rspData.put(column.getColumnMapping(), "");//column.getDefaultValue()
					} else {
						Object valMap = ParseZTIPS.putValue(val.toString(), column);
						if (valMap == null) {
							rspData.put(column.getColumnMapping(), "");
						} else {
							rspData.put(column.getColumnMapping(), valMap);
						}
					}
				}
			}

		} catch (JsonParseException e) {
			e.printStackTrace();
//			throw new SumpException("1203", "JSON格式解析错误");
		} catch (JsonMappingException e) {
			e.printStackTrace();
//			throw new SumpException("1204", "JSON数据映射错误");
		} catch (IOException e) {
			e.printStackTrace();
//			throw new SumpException("1205", "JSON数据读取错误");
		}
		return rspData;
	}

	/**
	 * 处理封装循环节点
	 * @param childData
	 * @param columnCd
	 * @param msgCd
	 * @return
	 */
	private String encapCyclingColumn(List<Map<String, Object>> childData, String columnCd, String msgCd) {
		StringBuilder reqBuff = new StringBuilder();
		List<ApSysColumn> columns = apSysColumnRepository.findChildByMsgCdColumnCd(columnCd, msgCd);
		for (int i = 0; i < childData.size(); i++) {
			Map<String, Object> req = childData.get(i);
			reqBuff.append("{");
			for (int j = 0; j < columns.size(); j++) {
				ApSysColumn column = columns.get(j);
				// 循环处理column 格式 obj:val
				if ("Y".equals(column.getCyclingFlag())) {
					// 对象可循环 column:[{obj:val},{obj:val}]
					List<Map<String, Object>> list = (List<Map<String, Object>>) req.get(column.getColumnMapping());
					String childStr = encapCyclingColumn(list, column.getColumnCd(), msgCd);
					reqBuff.append("\"").append(column.getColumnCd()).append("\"").append(":[").append(childStr).append("]");
				} else if ("O".equals(column.getCyclingFlag())) {
					// 处理子对象
					String childStr = encapChildColumn(req, column.getColumnCd(), msgCd);
					reqBuff.append("\"").append(column.getColumnCd()).append("\"").append(":").append(childStr);
				} else {
					String value = ParseZTIPS.getValue(req, column);
					if (StringUtils.isEmpty(value)) {
						value = "";
					}
					reqBuff.append("\"").append(column.getColumnCd()).append("\"").append(":").append("\"").append(value).append("\"");
				}
				if (j < columns.size() - 1) {
					// 最后一个column 不加逗号
					reqBuff.append(SPLIT);
				}
			}
			reqBuff.append("}");
			if (i < childData.size() - 1) {
				// 最后一个column 不加逗号
				reqBuff.append(SPLIT);
			}
		}
		return reqBuff.toString();
	}

	/**
	 * 处理封装循环节点
	 * 
	 * @param childData
	 * @param columnCd
	 * @param msgCd
	 * @return
	 */
	private String encapChildColumn(Map<String, Object> childData, String columnCd, String msgCd) {
		StringBuilder reqBuff = new StringBuilder();
		List<ApSysColumn> columns = apSysColumnRepository.findChildByMsgCdColumnCd(columnCd, msgCd);
		reqBuff.append("{");
		for (int i = 0; i < columns.size(); i++) {
			ApSysColumn column = columns.get(i);
			// 循环处理column 格式 obj:val
			if ("Y".equals(column.getCyclingFlag())) {
				// 对象可循环 obj:[{obj:val},{obj:val}]
				List<Map<String, Object>> list = (List<Map<String, Object>>) childData.get(column.getColumnMapping());
				String childStr = encapCyclingColumn(list, column.getColumnCd(), msgCd);
				reqBuff.append("\"").append(column.getColumnCd()).append("\"").append(":[").append(childStr).append("]");
			} else if ("O".equals(column.getCyclingFlag())) {
				// 处理子对象
				String childStr = encapChildColumn(childData, column.getColumnCd(), msgCd);
				reqBuff.append("\"").append(column.getColumnCd()).append("\"").append(":").append(childStr);
			} else {
				String value = ParseZTIPS.getValue(childData, column);
				if (StringUtils.isEmpty(value)) {
					value = "";
				}
				reqBuff.append("\"").append(column.getColumnCd()).append("\"").append(":").append("\"").append(value).append("\"");
			}
			if (i < columns.size() - 1) {
				// 最后一个column 不加逗号
				reqBuff.append(SPLIT);
			}
		}
		reqBuff.append("}");
		return reqBuff.toString();
	}

	/**
	 * 处理解析循环节点
	 * @param childData
	 * @param columnCd
	 * @param msgCd
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private List<Map<String, Object>> unencapCyclingColumn(List<Map<String, Object>> childData, String columnCd, String msgCd)
			throws JsonParseException, JsonMappingException, IOException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<ApSysColumn> columns = apSysColumnRepository.findChildByMsgCdColumnCd(columnCd, msgCd);
        if(childData == null){
        	return list;
        }
		for (Map<String, Object> map : childData) {
			Map<String, Object> rspData = new ConcurrentHashMap<String, Object>();
			for (ApSysColumn column : columns) {
				String colCd = column.getColumnCd();
				if ("Y".equals(column.getCyclingFlag())) {
					// 处理循环点
					List<Map<String, Object>> ls = (List<Map<String, Object>>) map.get(colCd);
					List<Map<String, Object>> lls = unencapCyclingColumn(ls, colCd, msgCd);
					rspData.put(column.getColumnMapping(), lls);
				} else if ("O".equals(column.getCyclingFlag())) {
					// 处理子节点
					// String childMsg = mp.get(colCd).toString();
					// Map<String, Object> childMap = new ObjectMapper().readValue(childMsg, Map.class);
					if(map.get(colCd) == null){
						continue;
					}
					Map<String, Object> mp = unencapChildColumn((Map<String, Object>) map.get(colCd), colCd, msgCd);
					rspData.putAll(mp);
				} else {
					Object val = map.get(colCd);
					if (val == null) {
						rspData.put(column.getColumnMapping(), "");
					} else {
						Object valMap = ParseZTIPS.putValue(val.toString(), column);
						if (valMap == null) {
							rspData.put(column.getColumnMapping(), "");
						} else {
							rspData.put(column.getColumnMapping(), valMap);
						}
					}
				}
			}
			list.add(rspData);
		}
		return list;
	}

	/**
	 * 处理解析子节点节点
	 * @param childData
	 * @param columnCd
	 * @param msgCd
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	private Map<String, Object> unencapChildColumn(Map<String, Object> childData, String columnCd, String msgCd)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> data = new ConcurrentHashMap<String, Object>();
		List<ApSysColumn> columns = apSysColumnRepository.findChildByMsgCdColumnCd(columnCd, msgCd);
		logger.debug("=======处理数据========" + childData);
		for (ApSysColumn column : columns) {
			String colCd = column.getColumnCd();
			logger.debug("=======处理字段========" + colCd);
			if ("Y".equals(column.getCyclingFlag())) {				
				// 处理循环节点
				List<Map<String, Object>> list = (List<Map<String, Object>>) childData.get(colCd);
				List<Map<String, Object>> ls = unencapCyclingColumn(list, colCd, msgCd);
				data.put(column.getColumnMapping(), ls);
			} else if ("O".equals(column.getCyclingFlag())) {
				// 处理子节点
				// String childMsg = childData.get(colCd).toString();
				logger.debug("=======处理子节点========" + childData.get(colCd));
				// Map<String, Object> mp = new
				// ObjectMapper().readValue(childMsg, Map.class);
				if(childData.get(colCd) == null){
					continue;
				}
				Map<String, Object> m = unencapChildColumn((Map<String, Object>) childData.get(colCd), colCd, msgCd);
				data.putAll(m);
			} else {
				Object val = childData.get(colCd);
				if (val == null) {
					data.put(column.getColumnMapping(), "");
				} else {
					Object valMap = ParseZTIPS.putValue(val.toString(), column);
					if (valMap == null) {
						data.put(column.getColumnMapping(), "");
					} else {
						data.put(column.getColumnMapping(), valMap);
					}
				}
			}
		}
		return data;
	}
}