package com.korea.movie_reservation.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MovieVO {

	private Integer movieId; 

	private String movieTitle; 

	private String movieGenre; 

	private Integer runningTime; 

	private Integer ticketPrice; 

	private LocalDateTime releaseDate;
}

