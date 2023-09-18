package com.example.blogcrud.service.impl;

import com.example.blogcrud.converter.BlogConverter;
import com.example.blogcrud.model.Blog;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogConverter blogConverter;
    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(Long id) {
        return null;
    }

    @Override
    public Blog save(CreateBlogRequestDTO createBlogRequestDTO) {
        Blog blog = blogConverter.convertRequestDTOToEntity(createBlogRequestDTO);
        return null;
    }

    @Override
    public Blog update(Blog blog) {
        return null;
    }

    @Override
    public Blog delete(Long id) {
        return null;
    }
}
