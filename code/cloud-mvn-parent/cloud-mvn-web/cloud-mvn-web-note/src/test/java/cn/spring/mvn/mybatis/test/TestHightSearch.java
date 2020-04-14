package cn.spring.mvn.mybatis.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.mvn.note.web.entity.Note;
import cn.spring.mvn.note.web.entity.NoteResult;
import cn.spring.mvn.note.web.entity.service.NoteService;

@SuppressWarnings({"rawtypes","unchecked","resource"})
public class TestHightSearch {

	public static void main(String[] args) {
//		String conf = "applicationContext.xml";
		String conf1 = "spring.xml";
		String conf2 = "spring-mybatis.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf1,conf2);
		NoteService service = ac.getBean("noteServiceImpl", NoteService.class);
		NoteResult result = service.hightSearch(null, "0", "2015-10-01", "2015-11-15");
		List<Note> list = (List) result.getData();
		for (Note n : list) {
			System.out.println(n.getCn_note_title());
		}
		System.out.println("搜索结果数量:" + list.size());
	}

}
