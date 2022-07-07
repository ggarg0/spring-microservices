package com.example.tollrateui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private ReactiveCircuitBreakerFactory circuitBreakerFactory;

	@RequestMapping("/rate")
	public String getRateFromProperty(Model m) {
	
		Mono<TollRateFromProperty> rate = webClientBuilder.build().get()
				.uri("http://toll-gateway/property/rate").retrieve()
				.bodyToMono(TollRateFromProperty.class);
		
		m.addAttribute("rate", rate.block());
		return "rateview";
	}
	
	@RequestMapping("/dashboard")
	public String GetTollRate(@RequestParam(defaultValue = "1000") Integer stationId, Model m) {
		
		// WebClient client = WebClient.create();
		ReactiveCircuitBreaker rcb = circuitBreakerFactory.create("tollrate-cb");

		Mono<TollRate> rate = rcb.run(webClientBuilder.build().get()
				// .uri("http://tollrate-service/tollrates/" +
				// stationId).retrieve().bodyToMono(TollRate.class),
				.uri("http://toll-gateway/v1/tollrate/" + stationId).retrieve().bodyToMono(TollRate.class),
				throwable -> getDefaultRate());
	
		logger.info("stationId: " + rate);
		System.out.println("stationId: " + rate);
		m.addAttribute("rate", rate.block());
		return "dashboard";
	}

	@RequestMapping("/dashboardslow")
	public String GetTollRateSlow(@RequestParam(defaultValue = "1000") Integer stationId, Model m) {

		// WebClient client = WebClient.create();
		ReactiveCircuitBreaker rcb = circuitBreakerFactory.create("tollrate-cb");

		Mono<TollRate> rate = rcb.run(webClientBuilder.build().get()
				.uri("http://tollrate-service/tollrateslow/" + stationId).retrieve().bodyToMono(TollRate.class),
				throwable -> getDefaultRate());

		logger.info("stationId slow: " + rate);
		System.out.println("stationId slow: " + stationId);
		m.addAttribute("rate", rate.block());
		return "dashboard";
	}

	private Mono<TollRate> getDefaultRate() {
		System.out.println("Fallback method called");
		return Mono.just(new TollRate(0, 2.00f, ""));
	}
}
