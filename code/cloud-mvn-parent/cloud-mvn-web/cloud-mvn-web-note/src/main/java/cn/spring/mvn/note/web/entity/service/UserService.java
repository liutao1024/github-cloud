package cn.spring.mvn.note.web.entity.service;

import cn.spring.mvn.note.web.entity.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name, String pwd) throws Exception;

	public NoteResult regist(String name, String password, String nickname) throws Exception;
	
	public NoteResult checkName(String name);
}
