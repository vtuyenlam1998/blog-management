package com.example.blogcrud.mapper;

import com.example.blogcrud.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BlogMapper {
    Blog getBlogById(Long id);
    List<Blog> getAllBlogs();
    void insertBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(Long id);
}
