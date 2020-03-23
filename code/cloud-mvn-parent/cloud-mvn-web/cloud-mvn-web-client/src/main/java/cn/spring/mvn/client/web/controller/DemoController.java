package cn.spring.mvn.client.web.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.mvn.client.model.repository.ApSysTransRepository;
import cn.spring.mvn.client.web.model.service.UserService;

@Controller("DemoController")
@RequestMapping("/")
public class DemoController {
	@Autowired
	UserService userServiceImpl;
	@Autowired
	ApSysTransRepository apSysTransRepository;

	/**
	 * 测试session和cookie
	 * 
	 * @throws IOException
	 */
	@RequestMapping("cookie")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setCharacterEncoding("UTF=8");
		response.setContentType("text/html;charset=UTF-8");
		// 使用request对象的getSession()获取session,如果session不存在则创建一个
		HttpSession session = request.getSession();
		session.setAttribute("data", "测试session");
		String sid = session.getId();
		if (session.isNew()) {
			response.getWriter().print("session创建成功,session的id是：" + sid);
		} else {
			response.getWriter().print("服务器已经存在该session了,session的id是：" + sid);
		}
		System.out.println(sid);
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getVersion());
			System.out.println(cookie.getPath());
		}
		Enumeration<String> strS = session.getAttributeNames();
		if (strS.hasMoreElements()) {
			System.out.println(strS.nextElement());
		}
	}

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "index";
	}

	@RequestMapping("/getuser")
	@ResponseBody
	public Map<String, Object> getUser(Integer id, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");
		map.put("data", apSysTransRepository.findOne("qrcuin"));
		return map;
	}

	@RequestMapping("/info")
	public String info() {
		return "info";
	}

	@RequestMapping("/findall")
	@ResponseBody
	public Map<String, Object> getUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");
		map.put("data", userServiceImpl.findAll());
		return map;
	}

	@RequestMapping("/findbyid")
	@ResponseBody
	public Map<String, Object> findById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");
		map.put("data", userServiceImpl.findById(id));
		return map;
	}

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> save(String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");
		map.put("data", userServiceImpl.save(name));
		return map;
	}
}
