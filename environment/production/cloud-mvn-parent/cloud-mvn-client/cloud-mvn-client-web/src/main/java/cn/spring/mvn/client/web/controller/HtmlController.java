package cn.spring.mvn.client.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("HtmlController")
@RequestMapping(value="/home/path")
public class HtmlController {
	private static final Logger logger = LoggerFactory.getLogger(HtmlController.class);
	@RequestMapping("/login_html")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/mydatatable");
		logger.info("====%s===%s==", "","");
		return modelAndView;
	}
}
