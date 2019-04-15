package com.sjg.webservice.domain.sso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sjg.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class OauthClients extends BaseTimeEntity {
	
	@Id
	private String clientId;
	
	@Column(nullable=false)
	private String resourceIds;
	private String clientSecret;
	private String scope;
	private String authorizedGrantTypes;
	private String web_serverRedirectUri;
	private String authorities;
	private Long accessTokenValidity;
	private Long refreshTokenValidity;
	private String additionalInformation;
	private String autoapprove;
	
	@Builder
	public OauthClients(String clientId, String resourceIds, String clientSecret, String scope,
			String authorizedGrantTypes, String web_serverRedirectUri, String authorities, Long accessTokenValidity,
			Long refreshTokenValidity, String additionalInformation, String autoapprove) {
		this.clientId = clientId;
		this.resourceIds = resourceIds;
		this.clientSecret = clientSecret;
		this.scope = scope;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.web_serverRedirectUri = web_serverRedirectUri;
		this.authorities = authorities;
		this.accessTokenValidity = accessTokenValidity;
		this.refreshTokenValidity = refreshTokenValidity;
		this.additionalInformation = additionalInformation;
		this.autoapprove = autoapprove;
	}
}