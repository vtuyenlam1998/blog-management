package com.example.blogcrud.converter;

import com.example.blogcrud.model.Blog;
import com.example.blogcrud.payload.request.CreateBlogRequestDTO;
import com.example.blogcrud.payload.request.EditBlogRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogConverter {
    public Blog convertCreateRequestDTOToEntity(CreateBlogRequestDTO requestDTO) {
        return Blog.builder()
                .description(requestDTO.getDescription())
                .name(requestDTO.getName())
                .build();
    }
    public Blog convertEditRequestDTOToEntity(EditBlogRequestDTO requestDTO) {
        return Blog.builder()
                .description(requestDTO.getDescription())
                .name(requestDTO.getName())
                .build();
    }
}
