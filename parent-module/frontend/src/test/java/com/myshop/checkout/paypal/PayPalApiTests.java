package com.myshop.checkout.paypal;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PayPalApiTests {
	private static final String BASE_URL = "https://api.sandbox.paypal.com";
	private static final String GET_ORDER_API = "/v2/checkout/orders/";
	private static final String CLIENT_ID = "AeoUX-iff-vAlcgSdUQHu8ZETUdFP1Ar0CLufdjHydNmk0U_imZ5oH_nL3191qsMbpU3enAXZddBAcKv";
//			"PAYPAL_CLIENT_ID";
	private static final String CLIENT_SECRET = "EGK0Gm0r-LYShDVMwSKULnv3MLUNkpPwVLBMmP-kO3xFySdAsnuGnkAff4tZ58zL8duqkTRJAxwoi34r";
//			"PAYPAL_CLIENT_SECRET";
	
	@Test
	public void testGetOrderDetails() {
		String orderId = "6ED49440LR4242222";
		String requestURL = BASE_URL + GET_ORDER_API + orderId;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Accept-Language", "en_US");
		headers.setBasicAuth(CLIENT_ID, CLIENT_SECRET);
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<PayPalOrderResponse> response = restTemplate.exchange(
				requestURL, HttpMethod.GET, request, PayPalOrderResponse.class);
		PayPalOrderResponse orderResponse = response.getBody();

		System.out.println("Order ID: " + orderResponse.getId());
		System.out.println("Validated: " + orderResponse.validate(orderId));
		
	}
}
