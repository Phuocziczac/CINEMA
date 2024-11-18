package com.poly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MovieCategory")
public class MovieCategory {

    @EmbeddedId
    private MovieCategoryId movieCategoryId; // Sử dụng khóa composite

    @ManyToOne
    @MapsId("movieId") // Liên kết với trường movieId trong MovieCategoryId
    @JoinColumn(name = "MovieID")
    private Movie movie;

    @ManyToOne
    @MapsId("categoryId") // Liên kết với trường categoryId trong MovieCategoryId
    @JoinColumn(name = "CategoryID")
    private Category category;
}
