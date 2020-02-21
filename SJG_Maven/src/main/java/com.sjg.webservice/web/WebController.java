package com.sjg.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjg.webservice.service.AlertsService;
import com.sjg.webservice.service.PostsService;
import com.sjg.webservice.service.ScrapsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	private PostsService postsService;
	private AlertsService alertsService;
	private ScrapsService scrapsService;
	
	@GetMapping("/")
	public String main(@RequestParam(required=false) String author ,Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
		model.addAttribute("alerts", alertsService.findAllDesc(author));
		model.addAttribute("scraps", scrapsService.findAllDesc(author));
		model.addAttribute("author", author);
		return "main";
	}
}