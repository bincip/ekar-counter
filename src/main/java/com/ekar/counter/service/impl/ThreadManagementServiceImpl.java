package com.ekar.counter.service.impl;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.counter.entity.ThreadRequest;
import com.ekar.counter.modal.Consumer;
import com.ekar.counter.modal.Counter;
import com.ekar.counter.modal.Producer;
import com.ekar.counter.modal.ThreadRequestDto;
import com.ekar.counter.service.ThreadCounterStatusService;
import com.ekar.counter.service.ThreadManagementService;
import com.ekar.counter.service.ThreadRequestService;

@Service
public class ThreadManagementServiceImpl implements ThreadManagementService {

	@Autowired
	ThreadRequestService threadRequestService;
	
	@Autowired
	ThreadCounterStatusService threadCounterStatusService;

	@Override
	public boolean processThreadRequest(ThreadRequestDto threadRequestDto) {
		int producerCount = threadRequestDto.getProducerCount();
		int consumerCount = threadRequestDto.getConsumerCount();

		ThreadRequest threadRequest = new ThreadRequest(producerCount, consumerCount, LocalDateTime.now());

		threadRequestService.saveThreadRequest(threadRequest);

		processProducerThreadRequest(threadRequestDto.getProducerCount());
		processConsumerThreadRequest(threadRequestDto.getConsumerCount());
		return true;
	}

	public void processConsumerThreadRequest(int threadCount) {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < threadCount; i++) {
			executorService.execute(new Consumer(threadCounterStatusService));
		}
		executorService.shutdown();
	}

	public void processProducerThreadRequest(int threadCount) {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < threadCount; i++) {
			executorService.execute(new Producer(threadCounterStatusService));
		}
		executorService.shutdown();
	}

	@Override
	public void resetThreadCounter(int count) {
		Counter.count.set(count);
	}

}
