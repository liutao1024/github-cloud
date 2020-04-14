package cn.spring.mvn.note.web.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.mvn.note.web.entity.NoteResult;
import cn.spring.mvn.note.web.entity.service.NoteBookService;

@Controller
@RequestMapping("/notebook")
public class LoadBooksController {
	@Resource
	private NoteBookService bookService;

	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId) {
		NoteResult result = bookService.loadBooks(userId);
		return result;
	}

}
