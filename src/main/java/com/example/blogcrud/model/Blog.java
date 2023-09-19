package com.example.blogcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime timeCreation;
    private Boolean active;
}
