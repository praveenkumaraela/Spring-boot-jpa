package com.example.mycontrollers;

import com.example.demo.basicconfiguration.BasicConfiguration;
import com.example.demo.model.Healthz;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class BasicController {
	
	@GetMapping("/healthz")
	public ResponseEntity health() {
		return ResponseEntity.status(HttpStatus.OK).body(new Healthz("Ok", "Success"));
	}

	@GetMapping("/welcome")
	public ResponseEntity welcome() {
		return ResponseEntity.status(HttpStatus.OK).body(new Healthz("Ok", "/n Successfully connected on " +
				"Server  @ timestamp " + new Date()));
	}

}

