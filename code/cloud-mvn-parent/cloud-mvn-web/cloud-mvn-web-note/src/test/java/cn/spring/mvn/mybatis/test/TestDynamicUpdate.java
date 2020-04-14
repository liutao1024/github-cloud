package cn.spring.mvn.mybatis.test;

import cn.spring.mvn.note.web.entity.Note;
import cn.spring.mvn.note.web.entity.dao.NoteDao;

public class TestDynamicUpdate extends TestBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NoteDao noteDao = getApplicationContext().getBean("noteDao", NoteDao.class);
		// 测试动态更新,回收站恢复笔记
		Note note = new Note();
		note.setCn_note_status_id("2");
		// note.setCn_notebook_id("10001");
		note.setCn_note_id("0c8b7f7e-0336-4220-9774-fd97d2cd0c40");
		noteDao.dynamicUpdate(note);

	}

}
