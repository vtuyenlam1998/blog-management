package com.example.blogcrud.pageable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyBatisPageable {
    private int page;   // Trang hiện tại
    private int size;   // Kích thước trang (số lượng bản ghi trên mỗi trang)
}
