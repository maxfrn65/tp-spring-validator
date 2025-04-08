package org.example.tpspringvalidator.Entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    @NotBlank(message = "A post must have a title")
    private String title;

    @OneToMany(mappedBy = "post",  fetch = FetchType.EAGER,  cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments;
}
