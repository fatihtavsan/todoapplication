package com.fatih.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be either ADMIN or USER")
    @Column(name = "role_name", nullable = false)
    private String name;

}
