package com.example.blogcrud.service.impl;

import com.example.blogcrud.converter.BlogConverter;
import com.example.blogcrud.mapper.BlogMapper;
import com.example.blogcrud.model.Blog;
import com.example.blogcrud.pageable.MyBatisPageable;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.payload.request.EditBlogRequestDTO;
import com.example.blogcrud.payload.response.PageResponseDTO;
import com.example.blogcrud.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public PageResponseDTO findByPage(MyBatisPageable pageable) {
        int offset = pageable.getPage() * pageable.getSize();
        RowBounds rowBounds = new RowBounds(offset,pageable.getSize());
        List<Blog> blogList = blogMapper.getBlogsByPage(rowBounds);
        long totalRecordCount = blogMapper.getTotalRecordCount();
        long totalPage = (totalRecordCount + pageable.getSize() - 1) / pageable.getSize();
        PageResponseDTO responseDTO = new PageResponseDTO();
        responseDTO.setBlogList(blogList);
        responseDTO.setPageNumber(pageable.getPage());
        responseDTO.setTotalPages(totalPage);
        responseDTO.setHasNext(pageable.getPage()< totalPage - 1);
        responseDTO.setHasPrevious(pageable.getPage()>0);
        return responseDTO;
    }
}
