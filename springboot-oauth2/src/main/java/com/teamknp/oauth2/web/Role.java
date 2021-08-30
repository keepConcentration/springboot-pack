package com.teamknp.oauth2.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

	GUEST("ROLE_GUEST", "guest"),
	USER("RILE_USER", "user");
	
	private final String key;
	private final String title;
}
