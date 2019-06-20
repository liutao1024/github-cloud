package cn.spring.mvn.client.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.spring.mvn.client.Client;
import cn.spring.mvn.client.web.model.BSBUser;
import cn.spring.mvn.comm.tools.MD5Tool;

@Controller("LoginController")
@ResponseBody
@RequestMapping("/home/path")
@SessionAttributes("BsbUser")
public class LoginController {
	@Autowired
	private Client client;
	//2重置登录状态
	/**
	 * @author LiuTao @date 2018年5月23日 上午10:12:36 
	 * @Title: reset 
	 * @Description: TODO(Describe) 
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="/reset")
	public Map<String, Object> reset(@RequestBody BSBUser bsbUser) {
		Map<String, Object> reqMap = new HashMap<String, Object>();//
		Map<String, Object> rspMap = new HashMap<String, Object>();//
		String cropno = bsbUser.getCorpno();
		String userid = bsbUser.getUserid();
		String passwd = MD5Tool.md5EncryptString(bsbUser.getPasswd());
		//是否需要校验密码
		boolean ischck = false;
		reqMap.put("cropno", cropno);
		reqMap.put("userid", userid);
		reqMap.put("passwd", passwd);
		reqMap.put("ischck", ischck);
		rspMap = client.callClient("resets", reqMap);
		if (rspMap.get("retCode").toString().equals("0000")) {
			rspMap.put("ret", "success");
			rspMap.put("msg", "状态重置成功");
		} else {
			rspMap.put("msg", rspMap.get("retMsg").toString());	
		}
		return rspMap;//返回
	}
	
	//3.登录
	/**
	 * @author LiuTao @date 2018年5月23日 上午10:12:43 
	 * @Title: loginCheckController 
	 * @Description: TODO(Describe) 
	 * @param sysUser
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginCheck")
	public Map<String, Object> loginCheck(@RequestBody BSBUser bsbUser, Model model){
		Map<String, Object> reqMap = new HashMap<String, Object>();
		Map<String, Object> rspMap = new HashMap<String, Object>();
		String cropno = bsbUser.getCorpno();
		String userid = bsbUser.getUserid();
		String passwd = MD5Tool.md5EncryptString(bsbUser.getPasswd());
		reqMap.put("cropno", cropno);
		reqMap.put("userid", userid);
		reqMap.put("passwd", passwd);
		reqMap.put("pswdfg", true);
		rspMap = client.callClient("userin", reqMap);
		if (rspMap.get("retCode").toString().equals("0000") ) {
			bsbUser.setUserna(rspMap.get("userna").toString());
			bsbUser.setSystdt(rspMap.get("systdt").toString());
			bsbUser.setBrchno(rspMap.get("brchno").toString());
			rspMap.put("ret", "success");
			rspMap.put("msg", "登陆成功");
			model.addAttribute("BsbUser", bsbUser);//写入session
		} else {			
			rspMap.put("msg", rspMap.get("retMsg").toString());
		}
		return rspMap;//返回
	}
}