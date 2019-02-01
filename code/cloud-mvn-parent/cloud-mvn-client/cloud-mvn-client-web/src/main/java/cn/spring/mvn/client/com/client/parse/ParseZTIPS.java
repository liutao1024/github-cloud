package cn.spring.mvn.client.com.client.parse;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.spring.mvn.client.basic.exception.SumpException;
import cn.spring.mvn.client.basic.tools.DateTool;
import cn.spring.mvn.client.basic.utils.CommUtil;
import cn.spring.mvn.client.com.model.ApSysColumn;

/**
 * @author LiuTao @date 2018年10月17日 上午9:38:21
 * @ClassName: ColumnUtil/ParseDealUtil/ParseTool/ParseZTIPS   
 * @Description: 处理字段数据工具   处理字段的小诀窍(Tips)
 */
public class ParseZTIPS {

	private static Logger logger = LoggerFactory.getLogger(ParseZTIPS.class);

	/**
	 * 从Map数据中获取对应数据,并进行类型和格式处理
	 * @param data Map数据
	 * @param column 字段属性
	 * @return 返回数值
	 */
	public static String getValue(Map<String, Object> data, ApSysColumn column) {
		logger.debug("======getValue========" + data);
		String value = "";
		// 取值 
		String key = column.getColumnMapping();
		// 如果没有匹配字段,则获取默认值 
		if (CommUtil.isNull(key)) {
			value = column.getDefaultValue();
		} else {
			logger.debug("======map key========" + key);
			Object obj = data.get(key);
			// 如果有匹配字段,且data中有值,根据配置设置obj的值
			if (CommUtil.isNotNull(obj)) {
				String type = column.getColumnType().toString();
				if ("F".equals(type)) {
					// 浮点型
					BigDecimal bval = (BigDecimal) obj;
					value = bval.toString();
				} else if ("Z".equals(type)) {
					// 整型
					Long lval = Long.valueOf(obj.toString());
					// 转换成要求的进制数 
					// TODO val = NumberUtils.transferIntegerNumber(obj.getValueDigit(), lval);
					value = lval.toString();
				} else if ("D".equals(type)) {
					// 日期
					Date tval = (Date) obj;
					// 转换日期格式 
					if ("1".equals(column.getDatePattern())) {
						// yyyyMMdd
						value = DateTool.Date2String(tval, DateTool.YYYYMMDD);
					} else if ("2".equals(column.getDatePattern())) {
						// yyyy-MM-dd
						value = DateTool.Date2String(tval, DateTool.YYYY_MM_DD);
					} else {
						// 没有配置使用默认的yyyyMMdd
						value = DateTool.Date2String(tval, DateTool.YYYYMMDD);
					}
				} else if ("S".equals(type)) {
					// 字符
					value = obj.toString();
				} else {
					throw new SumpException("1400", "没有匹配的字段类型");
				}
			}else {//若data中没有对应字段的值使用默认值
				value = column.getDefaultValue();
			}
		}
		return value;
	}

	/**
	 * 赋值类型和格式转换
	 * @param colStr
	 * @param obj
	 * @return
	 */
	public static Object putValue(String valStr, ApSysColumn column) {
		// 取值 
		Object obj = "";
		// 如果没有匹配字段,则获取默认值 
		if (CommUtil.isNull(valStr)) {
			obj = column.getDefaultValue();
		} else {
			String type = column.getColumnType().toString();
			if ("F".equals(type)) {
				// 转换成浮点型
				obj = Double.valueOf(valStr);
			} else if ("Z".equals(type)) {
				// 转换成要求的进制数 
				// TODO val = NumberUtils.(obj.getValueDigit(), colStr);
				obj = Long.valueOf(valStr);
			} else if ("D".equals(type)) {
				try {
					// 转换日期格式 
					if ("1".equals(column.getDatePattern())) {
						// yyyyMMdd
						obj = DateUtils.parseDate(valStr, DateTool.YYYYMMDD);
					} else if ("2".equals(column.getDatePattern())) {
						// yyyy-MM-dd
						obj = DateUtils.parseDate(valStr, DateTool.YYYY_MM_DD);
					} else {
						// 没有配置使用默认的yyyyMMdd
						obj = DateUtils.parseDate(valStr, DateTool.YYYYMMDD);
					}
				} catch (ParseException e) {
					throw new SumpException("1201", "日期类型数值获取并转换失败");
				}
			} else if ("S".equals(type)) {
				obj = valStr;
			} else {
				throw new SumpException("1202", "没有匹配的字段类型");
			}
		}
		return obj;
	}
}
