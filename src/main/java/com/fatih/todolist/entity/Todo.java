package com.fatih.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;
    @NotBlank(message = "Title cannot be empty!")
    @Size(max = 100, message = "Title length less than 100 characters")
    @Column(name = "todo_title", nullable = false)
    private String title;
    @Column(name = "todo_description")
    private String description;
    @Column(name = "todo_completed", nullable = false)
    private boolean completed;

}
