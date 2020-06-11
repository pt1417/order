package com.ibm.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.client.RestTemplate;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	@Bean
	public io.opentracing.Tracer jaegerTracer() {
	SamplerConfiguration samplerConfig = 	SamplerConfiguration.fromEnv().withType(ConstSampler.TYPE).withParam(1);
	ReporterConfiguration reporterConfig = 	ReporterConfiguration.fromEnv().withLogSpans(true);
	return new Configuration("order-service")
		.withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}
	@Bean
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}
}
