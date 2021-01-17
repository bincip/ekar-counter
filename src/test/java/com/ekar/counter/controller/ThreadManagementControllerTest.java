package com.ekar.counter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ekar.counter.modal.ThreadRequestDto;
import com.ekar.counter.service.ThreadManagementService;

@ExtendWith(MockitoExtension.class)
public class ThreadManagementControllerTest {

	@InjectMocks
	private ThreadManagementController threadManagementController;

	@Mock
	ThreadManagementService threadManagementService;

	@Test
	public void processThreadRequestTest() throws URISyntaxException {

		ThreadRequestDto threadRequestDto = new ThreadRequestDto(10, 0);

		ResponseEntity response = threadManagementController.processThreadRequest(threadRequestDto);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void resetThreadCounterTest() throws URISyntaxException {

		ResponseEntity response = threadManagementController.resetThreadCounter(50);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
