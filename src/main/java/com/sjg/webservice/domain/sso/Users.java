package com.sjg.webservice.domain.sso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sjg.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Users extends BaseTimeEntity {
	

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String userName;

	@Column(nullable=false)
	private String password;

	@Column(nullable=false)
	private String userType;


	@Builder
	public Users(Long id, String userName, String password, String userType) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
}