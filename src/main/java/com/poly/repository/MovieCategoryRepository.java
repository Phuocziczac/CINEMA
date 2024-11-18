package com.poly.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.model.MovieCategory;
import com.poly.model.MovieCategoryId;


@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory, MovieCategoryId> {
    // Bạn có thể thêm các phương thức tùy chỉnh tại đây nếu cần
	 List<MovieCategory> findByMovieId(int movieId);
}
