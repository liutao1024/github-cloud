package cn.spring.mvn.note.web.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.mvn.note.web.entity.NoteResult;
import cn.spring.mvn.note.web.entity.service.UserService;

@Controller
@RequestMapping("/user")
@SuppressWarnings("unused")
public class RegistController {
	@Resource
	private UserService userService;

	@RequestMapping("/checkUserName")
	@ResponseBody
	public NoteResult checkUserName(HttpServletRequest request){
		String name = request.getParameter("username");
		NoteResult result = userService.checkName(name);
		return result;
	}
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public NoteResult execute(HttpServletRequest request) throws Exception {
		String name = request.getParameter("cnUserName");
		String password = request.getParameter("cnUserPassword");
		String nickname = request.getParameter("nickName");
		NoteResult result = userService.regist("10001", "123456", "mufeng");
		return result;
	}
	

}
