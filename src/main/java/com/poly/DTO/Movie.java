package com.poly.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	int ID;
	String name;
	int movie_duration;
	String content;
	Date release_date;
	String link_Trailer;
	 String performer;
	 String director;
	Boolean Status;
	Date created_at;
	Date update_at;
	
	String images;
	

}
