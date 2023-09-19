package com.example.blogcrud.mapper;

import com.example.blogcrud.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlogMapper {
    Blog getBlogById(Long id);
    List<Blog> getAllBlogs();
    List<Blog> getBlogsByPage(RowBounds rowBounds);
    void insertBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(Long id);
    long getTotalRecordCount();
}
