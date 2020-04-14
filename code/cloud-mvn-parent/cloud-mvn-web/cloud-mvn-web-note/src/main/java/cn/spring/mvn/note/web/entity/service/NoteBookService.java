package cn.spring.mvn.note.web.entity.service;

import cn.spring.mvn.note.web.entity.NoteResult;

public interface NoteBookService {
	public NoteResult addBook(String bookName, String userId);

	public NoteResult loadBooks(String userId);
}
