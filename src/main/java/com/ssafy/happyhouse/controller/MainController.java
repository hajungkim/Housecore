package com.ssafy.happyhouse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/introduce")
	public String introduce() {
		return "introduce";
	}

	@GetMapping("/neighbor")
	public String neighborInfo() {
		return "neighborInfo";
	}
	
	@GetMapping("/environment")
	public String environmentInfo() {
		return "environmentinfo";
	}
	
	@GetMapping("/interest")
	public String interestArea() {
		return "interestArea";
	}
}
