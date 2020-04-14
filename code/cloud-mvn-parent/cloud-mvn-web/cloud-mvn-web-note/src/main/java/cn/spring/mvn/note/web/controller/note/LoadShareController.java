package cn.spring.mvn.note.web.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spring.mvn.note.web.entity.NoteResult;
import cn.spring.mvn.note.web.entity.service.NoteService;

@Controller
@RequestMapping("/note")
public class LoadShareController {
	@Resource
	private NoteService noteService;

	@RequestMapping("/loadShare.do")
	@ResponseBody
	public NoteResult execute(String shareId) {
		NoteResult result = noteService.loadShare(shareId);
		return result;
	}

}
