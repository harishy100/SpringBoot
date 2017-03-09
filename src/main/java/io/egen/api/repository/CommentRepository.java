package io.egen.api.repository;

import io.egen.api.entity.*;
import java.util.List;

import org.springframework.data.repository.Repository;


public interface CommentRepository extends Repository<Comment, String> {
	public List<Comment> findByMve_Id(String id);
	public Comment save(Comment cmt);
	public Comment findByMveAndUsr(Movie movie, User user);
	
}