package com.verisk.tutorial.serverless.controller;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verisk.tutorial.serverless.model.Message;

@RestController
@RequestMapping("")
public class PingController {

	@GetMapping("/ping")
	public Message ping(HttpServletRequest request) {
		return new Message("Pong");
	}
	
	@GetMapping("/hello")
	public Message hello() {
		return new Message("Hello AWS Workshop");
	}
}
