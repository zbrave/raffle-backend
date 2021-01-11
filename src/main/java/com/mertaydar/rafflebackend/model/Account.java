package com.mertaydar.rafflebackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
	
	@Id
	@NonNull
	private String nickname;
	
	@NonNull
	private String[] links;
}
