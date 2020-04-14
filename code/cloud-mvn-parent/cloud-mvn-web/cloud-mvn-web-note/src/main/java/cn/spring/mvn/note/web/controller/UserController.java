package cn.spring.mvn.note.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.spring.mvn.note.web.entity.User;
import cn.spring.mvn.note.web.entity.dao.UserDao;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("/view")
    public String view() {
        return "main/login";
    }

    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpSession session) {
//        User user = userDao.findByUsername(model.getUsername());
//        System.out.println(user);
//        if (user == null || !user.getPassword().equals(model.getPassword())) {
//            return new ModelAndView("redirect:/login.jsp");
//        } else {
//            session.setAttribute("user", user);
//            ModelAndView mav = new ModelAndView();
//            mav.setViewName("index");
//            return mav;
//        }
    	return null;
    }
}