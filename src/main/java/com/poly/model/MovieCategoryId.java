package com.poly.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // Tự động sinh equals và hashCode
public class MovieCategoryId implements Serializable {
    private static final long serialVersionUID = 1L; // Thêm serialVersionUID

    private Integer movieId; // Kiểu dữ liệu của trường khóa chính trong entity Movie
    private Integer categoryId; // Kiểu dữ liệu của trường khóa chính trong entity Category
}
