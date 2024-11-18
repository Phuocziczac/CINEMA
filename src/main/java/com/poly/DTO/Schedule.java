package com.poly.DTO;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule implements Serializable {
	int ID;
	Date screen_Date;
	int Movie_ID;
	int showtimes_ID;
}
