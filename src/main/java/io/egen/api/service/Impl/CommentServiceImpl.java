package io.egen.api.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Comment;
import io.egen.api.entity.Rating;
import io.egen.api.repository.CommentRepository;
import io.egen.api.service.CommentService;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository repository;
	@Override
	public List<Comment> getmoviecomments(String id) {
		List<Comment> cmt=repository.findByMve_Id(id);
		if(cmt==null){
			return null;
		}
		else{
			return cmt;
		}
		
	}

	@Override
	public Comment insertcomment(Comment cmt) {
		
			return repository.save(cmt);
		
		
		
	}

}
