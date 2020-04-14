package cn.spring.mvn.note.web.entity.dao;

import java.util.List;
import java.util.Map;

import cn.spring.mvn.note.web.entity.Share;

@SuppressWarnings("rawtypes")
public interface ShareDao {
	public Share findById(String id);

	public List<Map> findLikeTitle(String keyword);

	public Share findByNoteId(String noteId);

	public void save(Share share);
}
