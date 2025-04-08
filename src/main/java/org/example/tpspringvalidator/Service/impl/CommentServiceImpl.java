package org.example.tpspringvalidator.Service.impl;

import org.example.tpspringvalidator.Entity.Comment;
import org.example.tpspringvalidator.Repository.CommentRepository;
import org.example.tpspringvalidator.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment entity) {
        return commentRepository.save(entity);
    }

    @Override
    public Comment findById(Long aLong) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return List.of();
    }

    @Override
    public Comment update(Long aLong, Comment entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
