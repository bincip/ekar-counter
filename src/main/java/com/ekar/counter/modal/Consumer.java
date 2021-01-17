package com.ekar.counter.modal;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ekar.counter.entity.ThreadCounterStatus;
import com.ekar.counter.service.ThreadCounterStatusService;

@Component
public class Consumer implements Runnable {

	Logger logger = LoggerFactory.getLogger(Consumer.class);

	private ThreadCounterStatusService threadCounterStatusService;

	public Consumer(ThreadCounterStatusService threadCounterStatusService) {
		this.threadCounterStatusService = threadCounterStatusService;
	}


	@Override
	public void run() {
		decreaseCounter();
	}

	private void decreaseCounter() {
		if (Counter.count.get() > 0) {
			int count = Counter.count.decrementAndGet();
			logger.info("Counter Updated By: {} : New Count: {}", Thread.currentThread().getName(), count);
			if (count == 0) {
				threadCounterStatusService.saveThreadCounterStatus(new ThreadCounterStatus(0, LocalDateTime.now()));
			}
		}
	}

}
