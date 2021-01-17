package com.ekar.counter.service;

import com.ekar.counter.modal.ThreadRequestDto;

public interface ThreadManagementService {
	
	public boolean processThreadRequest(ThreadRequestDto threadRequestDto);

	public void resetThreadCounter(int count);

}
