package com.example.fastpassui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Controller
public class FastPassController {

	private static final Logger logger = LoggerFactory.getLogger(FastPassController.class);
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping(path = "/customerdetails")
	//@CircuitBreaker(name = "fastpasscircuitbreaker", fallbackMethod = "getFastPassCustomerDetailsFallback")
	//@Retry(name = "fastpassretry", fallbackMethod = "getFastPassCustomerDetailsFallback")
	@RateLimiter(name = "fastpasslimiter", fallbackMethod = "getFastPassCustomerDetailsFallback")
	public String getFastPassCustomerDetails(@RequestParam(defaultValue = "800") String fastpassid, Model m) {

		// WebClient client = WebClient.create();
		System.out.println("fastpassid: " + fastpassid);
		FastPassCustomer customer = webClientBuilder.build().get()
				.uri("http://fastpass-service/fastpass?fastpassid=" + fastpassid).retrieve()
				.bodyToMono(FastPassCustomer.class).block();

	
		m.addAttribute("customer", customer);
		return "console";

	}

	private String getFastPassCustomerDetailsFallback(@RequestParam String fastpassid, Model m, Throwable t) {
		FastPassCustomer customer = new FastPassCustomer("0000", "Default", "00000000000", 0f);
		System.out.println("fastpassid from fallback: " + fastpassid);
		m.addAttribute("customer", customer);
		return "console";
	}

}
