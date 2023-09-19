package com.example.blogcrud.payload.response;

import com.example.blogcrud.model.Blog;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseDTO {
    List<Blog> blogList;
    long pageNumber;
    long totalPages;
    boolean hasNext;
    boolean hasPrevious;
}
