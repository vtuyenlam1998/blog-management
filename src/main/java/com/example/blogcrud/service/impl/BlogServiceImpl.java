package com.example.blogcrud.service.impl;

import com.example.blogcrud.converter.BlogConverter;
import com.example.blogcrud.mapper.BlogMapper;
import com.example.blogcrud.model.Blog;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.payload.request.EditBlogRequestDTO;
import com.example.blogcrud.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogConverter blogConverter;
    private final BlogMapper blogMapper;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper,BlogConverter blogConverter) {
        this.blogMapper = blogMapper;
        this.blogConverter = blogConverter;
    }
    @Override
    public List<Blog> findAll() {
        return blogMapper.getAllBlogs();
    }

    @Override
    public Blog findById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public Blog save(CreateBlogRequestDTO createBlogRequestDTO) {
        Blog blog = blogConverter.convertCreateRequestDTOToEntity(createBlogRequestDTO);
        blogMapper.insertBlog(blog);
        return blog;
    }

    @Override
    public Blog update(EditBlogRequestDTO editBlogRequestDTO) {
        Blog blog = blogConverter.convertEditRequestDTOToEntity(editBlogRequestDTO);
        blogMapper.updateBlog(blog);
        return blog;
    }

    @Override
    public Blog delete(Long id) {
        Blog blog = blogMapper.getBlogById(id);
        blogMapper.deleteBlog(id);
        return blog;
    }
}
