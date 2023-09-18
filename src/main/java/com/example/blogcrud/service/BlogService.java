package com.example.blogcrud.service;

import com.example.blogcrud.model.Blog;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    Blog save(CreateBlogRequestDTO createBlogRequestDTO);
    Blog update(Blog blog);
    Blog delete(Long id);
}
