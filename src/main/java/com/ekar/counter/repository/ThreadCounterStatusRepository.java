package com.ekar.counter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekar.counter.entity.ThreadCounterStatus;

public interface ThreadCounterStatusRepository extends JpaRepository<ThreadCounterStatus, Long> {
	

}
