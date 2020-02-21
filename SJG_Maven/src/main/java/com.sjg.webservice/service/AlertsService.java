package com.sjg.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjg.webservice.domain.alerts.AlertsRepository;
import com.sjg.webservice.dto.alerts.AlertsMainResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlertsService {
	private AlertsRepository alertsRepository;
	
	@Transactional(readOnly = true)
	public List<AlertsMainResponseDto> findAllDesc(String author){
		List<AlertsMainResponseDto> alertList = alertsRepository.findAllDesc(author).map(AlertsMainResponseDto::new).collect(Collectors.toList());
		return alertList;
	}
}