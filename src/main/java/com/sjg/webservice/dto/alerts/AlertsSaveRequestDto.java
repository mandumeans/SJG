package com.sjg.webservice.dto.alerts;

import com.sjg.webservice.domain.alerts.Alerts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlertsSaveRequestDto {
	private Long postId;
	private String alertAuthor;
	private String isRead;
	
	public Alerts toEntity() {
		return Alerts.builder()
				.postId(postId)
				.alertAuthor(alertAuthor)
				.isRead(isRead)
				.build();
	}
}