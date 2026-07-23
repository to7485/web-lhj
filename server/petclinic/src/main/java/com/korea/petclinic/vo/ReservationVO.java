package com.korea.petclinic.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReservationVO {

	private Long id;
	private String petName;
	private String ownerName;
	private String animalType;
	private String doctorName;
	private LocalDate reservationDate;
	private String status;
	private int price;
}
