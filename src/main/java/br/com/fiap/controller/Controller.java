package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.model.Statistics;
import br.com.fiap.model.Transaction;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("")
@Api(value = "Controller", tags = { "Controller" })
public class Controller {
	
	private List<Double> listAmount = new ArrayList<>(); 
	private long current = System.currentTimeMillis() / 1000L;

	@PostMapping("/transaction")
	public ResponseEntity<Transaction> transaction(@RequestBody Transaction transaction) {
		long difference = current - transaction.getTimestamp();
		if(difference < 60) {
			listAmount.add(transaction.getAmount());
			return new ResponseEntity<>(null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/statistics")
	public ResponseEntity<Statistics> statistics() {
		Statistics statistics = new Statistics();
		statistics.setSum(listAmount.stream().mapToDouble(d -> d).sum());
		statistics.setMin(listAmount.stream().min(Double::compare).get());
		statistics.setMax(listAmount.stream().max(Double::compare).get());
		statistics.setAvg(listAmount.stream().mapToDouble(Double::doubleValue).sum() / listAmount.size());
		statistics.setCount((int) listAmount.stream().count());
		return new ResponseEntity<Statistics>(statistics, HttpStatus.OK);
	}
}
