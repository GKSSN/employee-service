package com.bcg.employee.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.bcg.employee.exception.ContractTransactionNotFoundException;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
			throw new ContractTransactionNotFoundException();
		}
	}

}
