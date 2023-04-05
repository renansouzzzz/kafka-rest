package com.br.restkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.restkafka.domain.Order;
import com.br.restkafka.service.EventRegisterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final EventRegisterService registerService = new EventRegisterService();
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Order order){
		
		registerService.addEvent("SaveOrder", order);
		return ResponseEntity.ok("Pedido salvo!");
	}
}
