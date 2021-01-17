package com.ekar.counter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekar.counter.entity.ThreadRequest;
import com.ekar.counter.repository.ThreadRequestRepository;
import com.ekar.counter.service.ThreadRequestService;

@Service
public class ThreadRequestServiceImpl implements ThreadRequestService {

	@Autowired
	ThreadRequestRepository threadRequestRepository;

	@Override
	public void saveThreadRequest(ThreadRequest threadRequest) {
		threadRequestRepository.save(threadRequest);
	}

}
