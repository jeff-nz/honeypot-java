package com.jeffnz.honeypot.controller;


import com.jeffnz.honeypot.service.HoneypotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class HoneypotController {

	@Autowired
	private HoneypotService honeyPotService;

	private final Logger log = LoggerFactory.getLogger(HoneypotController.class);

	@GetMapping(value = "/*")
	public ResponseEntity<StreamingResponseBody> handleRandomGetRequest() {
		log.info("handleRandomGetRequest() called");
		return ResponseEntity.ok(honeyPotService.getInfiniteResponse());
	}
}
