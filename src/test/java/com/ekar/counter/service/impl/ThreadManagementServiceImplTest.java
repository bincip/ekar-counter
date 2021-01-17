package com.ekar.counter.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ekar.counter.modal.Counter;
import com.ekar.counter.modal.ThreadRequestDto;
import com.ekar.counter.service.ThreadCounterStatusService;
import com.ekar.counter.service.ThreadRequestService;

@ExtendWith(MockitoExtension.class)
public class ThreadManagementServiceImplTest {

	@InjectMocks
	private ThreadManagementServiceImpl threadManagementService;

	@Mock
	ThreadRequestService threadRequestService;

	@Mock
	ThreadCounterStatusService threadCounterStatusService;;

	@Test
	public void processThreadRequestTest() throws URISyntaxException, InterruptedException {
		threadManagementService.resetThreadCounter(50);
		boolean response = threadManagementService.processThreadRequest(new ThreadRequestDto(10, 0));
		assertTrue(response);
		
		threadManagementService.resetThreadCounter(50);
		response = threadManagementService.processThreadRequest(new ThreadRequestDto(100, 0));
		assertTrue(response);
		
		threadManagementService.resetThreadCounter(50);
		response = threadManagementService.processThreadRequest(new ThreadRequestDto(0, 100));
		assertTrue(response);
	}

	@Test
	public void resetThreadCounterTest() throws URISyntaxException {

		threadManagementService.resetThreadCounter(50);
		assertEquals(Counter.count.get(), 50);

	}

}
