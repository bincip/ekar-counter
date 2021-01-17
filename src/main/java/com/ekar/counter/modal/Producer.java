package com.ekar.counter.modal;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ekar.counter.entity.ThreadCounterStatus;
import com.ekar.counter.service.ThreadCounterStatusService;

public class Producer implements Runnable {
	
	Logger logger = LoggerFactory.getLogger(Producer.class);

	private ThreadCounterStatusService threadCounterStatusService;

	public Producer(ThreadCounterStatusService threadCounterStatusService) {
		this.threadCounterStatusService = threadCounterStatusService;
	}

	@Override
	public void run() {
		increaseCounter();
	}

	private void increaseCounter() {

		if (Counter.count.get() < 100) {
			int count = Counter.count.addAndGet(1);
			logger.info("Counter Updated By: {} : New Count: {}", Thread.currentThread().getName(), count);
			if (count == 100) {
				threadCounterStatusService.saveThreadCounterStatus(new ThreadCounterStatus(100, LocalDateTime.now()));
			}
		}
	}

}
