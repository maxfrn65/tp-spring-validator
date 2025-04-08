package org.example.tpspringvalidator.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "body")
    @NotNull
    @NotBlank(message = "A comment must have a body")
    private String body;

    @Column(name = "email")
    @Pattern(regexp = ".*\\.net", message = "Email must end with .net")
    @NotNull
    @NotBlank(message = "A comment must have an email")
    private String email;

    @Column(name = "name")
    @Size(min = 3, message = "Name must be at least 3 characters")
    @NotNull
    @NotBlank(message = "A comment must have a name")
    private String name;

    @ManyToOne
    private Post post;
}
