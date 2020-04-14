package cn.spring.mvn.mybatis.test;

import cn.spring.mvn.note.web.entity.dao.NoteDao;

public class TestDeleteNotes extends TestBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NoteDao noteDao = getApplicationContext().getBean("noteDao", NoteDao.class);
		String[] ids = { "fsaf-as-df-asdf-as-df-dsa",
				"ss19055-30e8-4cdc-bfac-97c6bad9518f" };
		int rows = noteDao.deleteNotes(ids);
		System.out.println("删除的记录数:" + rows);
	}

}
