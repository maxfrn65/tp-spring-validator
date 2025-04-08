package org.example.tpspringvalidator.Controller;

import jakarta.validation.Valid;
import org.example.tpspringvalidator.Entity.Comment;
import org.example.tpspringvalidator.Entity.Post;
import org.example.tpspringvalidator.Service.CommentService;
import org.example.tpspringvalidator.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getPosts() { return postService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> createPost(@Valid @RequestBody Post post) {
        try {
            postService.save(post);
            return ResponseEntity.ok(postService.findById(post.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}
