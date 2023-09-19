package com.example.blogcrud.service;

import com.example.blogcrud.model.Blog;
import com.example.blogcrud.pageable.MyBatisPageable;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.payload.request.EditBlogRequestDTO;
import com.example.blogcrud.payload.response.PageResponseDTO;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    Blog save(CreateBlogRequestDTO createBlogRequestDTO);
    Blog update(EditBlogRequestDTO editBlogRequestDTO);
    Blog delete(Long id);
    PageResponseDTO findByPage(MyBatisPageable pageable);
}
