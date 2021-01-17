package com.ekar.counter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.counter.entity.ThreadCounterStatus;
import com.ekar.counter.repository.ThreadCounterStatusRepository;
import com.ekar.counter.service.ThreadCounterStatusService;

@Service
public class ThreadCounterStatusServiceImpl implements ThreadCounterStatusService {
	
	@Autowired
	ThreadCounterStatusRepository threadCounterStatusRepository;

	@Override
	public void saveThreadCounterStatus(ThreadCounterStatus threadCounterStatus) {
		threadCounterStatusRepository.save(threadCounterStatus);
	}

}
