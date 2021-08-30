package com.teamknp.oauth2.web;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = 6896377316656778988L;
	
	private String name;
	private String email;
	private String picture;
	private Role role;
	
	public User(String name
			, String email
			, String picture) {
		this.name = name;
		this.email = email;
		this.picture = picture;
	}
	
	@Builder
	public User(String name
				, String email
				, String picture
				, Role role) {
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.role = role;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}
