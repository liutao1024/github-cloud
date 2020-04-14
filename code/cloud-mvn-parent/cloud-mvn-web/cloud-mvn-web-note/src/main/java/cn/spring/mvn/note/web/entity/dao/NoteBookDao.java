package cn.spring.mvn.note.web.entity.dao;

import java.util.List;

import cn.spring.mvn.note.web.entity.NoteBook;

public interface NoteBookDao {
	public void save(NoteBook book);
	public List<NoteBook> findByUser(String userId);
}
