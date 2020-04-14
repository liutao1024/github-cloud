package cn.spring.mvn.note.web.entity.dao;

import java.util.List;
import java.util.Map;

import cn.spring.mvn.note.web.entity.Note;

@SuppressWarnings("rawtypes")
public interface NoteDao {
	public int deleteNotes(String[] ids);

	public void dynamicUpdate(Note note);

	public List<Note> hightSearch(Map params);

	// public void replayNote(Map params);
	public List<Map> findDelete(String userId);

	// public void updateStatus(String noteId);
	// public void update(Note note);
	public Note findById(String noteId);

	public void save(Note note);

	public List<Map> findByBookId(String bookId);
}
