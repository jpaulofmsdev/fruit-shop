package com.github.jpaulofmsdev.fruitshop.exception;

import org.springframework.http.HttpStatus;

public class FruitShopException extends Exception {

	private static final long serialVersionUID = -2848146646920810695L;

	private HttpStatus statusCode;
	
	public FruitShopException(HttpStatus statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}
}
