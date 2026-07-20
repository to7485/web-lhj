package com.korea.todo.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

	@Id
	@UuidGenerator //UUid값을 자동으로 생성한다.
	private String id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	private String password;
	
	private String role;
	
}










