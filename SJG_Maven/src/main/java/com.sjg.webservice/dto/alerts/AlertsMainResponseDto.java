package com.sjg.webservice.dto.alerts;

import com.sjg.webservice.domain.alerts.Alerts;

import lombok.Getter;

@Getter
public class AlertsMainResponseDto {
    private Long id;
    private String isRead;
    private String alertAuthor;
	private Long postId;

    public AlertsMainResponseDto(Alerts entity) {
        id = entity.getId();
        isRead = entity.getIsRead();
        postId = entity.getPostId();
        alertAuthor = entity.getAlertAuthor();
    }
}