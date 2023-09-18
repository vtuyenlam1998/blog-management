package com.example.blogcrud.converter;

import com.example.blogcrud.model.Blog;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogConverter {
    public Blog convertRequestDTOToEntity(CreateBlogRequestDTO requestDTO) {
        return Blog.builder()
                .description(requestDTO.getDescription())
                .name(requestDTO.getName())
                .build();
    }
}
