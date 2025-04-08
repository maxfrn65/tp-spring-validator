package org.example.tpspringvalidator.Service.impl;

import org.example.tpspringvalidator.Entity.Post;
import org.example.tpspringvalidator.Repository.PostRepository;
import org.example.tpspringvalidator.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public Post findById(Long aLong) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return List.of();
    }

    @Override
    public Post update(Long aLong, Post entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
