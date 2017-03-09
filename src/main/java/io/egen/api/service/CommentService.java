package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Comment;

public interface CommentService {
	public List<Comment> getmoviecomments(String id);
	public Comment insertcomment(Comment cmt);
}

