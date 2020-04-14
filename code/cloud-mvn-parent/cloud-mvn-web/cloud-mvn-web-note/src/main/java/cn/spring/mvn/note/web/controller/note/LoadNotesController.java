package cn.spring.mvn.note.web.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.mvn.note.web.entity.NoteResult;
import cn.spring.mvn.note.web.entity.service.NoteService;

@Controller
@RequestMapping("/note")
public class LoadNotesController {
	@Resource
	private NoteService noteService;

	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult execute(String bookId) {
		NoteResult result = noteService.loadNotes(bookId);
		return result;
	}

}
