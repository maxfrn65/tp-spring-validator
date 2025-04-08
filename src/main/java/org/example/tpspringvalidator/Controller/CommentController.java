package org.example.tpspringvalidator.Controller;

import jakarta.validation.Valid;
import org.example.tpspringvalidator.Entity.Comment;
import org.example.tpspringvalidator.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("")
    public ResponseEntity<Object> createComment(@Valid @RequestBody Comment comment) {
        try {
            commentService.save(comment);
            return ResponseEntity.ok(commentService.findById(comment.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
