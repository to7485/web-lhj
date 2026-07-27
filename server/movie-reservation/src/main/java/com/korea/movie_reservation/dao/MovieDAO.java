package com.korea.movie_reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.movie_reservation.vo.MovieVO;


@Mapper
public interface MovieDAO {
	
	List<MovieVO> findAll();

	void insert(MovieVO vo);
	
	MovieVO findMovieById(int MovieId);
}
