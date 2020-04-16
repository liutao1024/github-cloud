package cn.spring.mvn.note.web.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.spring.mvn.note.web.entity.NoteResult;
import cn.spring.mvn.note.web.entity.service.UserService;

@Controller
//扫描控制组件
@RequestMapping("/user")
public class LoginController {

	@Resource
	// 注入
	private UserService userService;

	@RequestMapping("/login.do")
	@ResponseBody
	// 将返回值NoteResult转成json输出
	public NoteResult execute(String name, String pwd) throws Exception {
		name = "10001";
		pwd = "123456";
		NoteResult result = userService.checkLogin(name, pwd);
		return result;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(){
		return new ModelAndView("edit");
	}
	
	@RequestMapping("/activity")
	public ModelAndView activity(){
		return new ModelAndView("activity");
	}
}