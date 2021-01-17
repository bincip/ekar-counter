package com.ekar.counter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekar.counter.entity.ThreadRequest;

public interface ThreadRequestRepository extends JpaRepository<ThreadRequest, Long> {
	

}
