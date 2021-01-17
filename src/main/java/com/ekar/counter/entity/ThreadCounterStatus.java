package com.ekar.counter.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ThreadCounterStatus {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int threadCount;
	
	private LocalDateTime updatedAt;
	
	public ThreadCounterStatus() {
		super();
	}

	public ThreadCounterStatus(int threadCount, LocalDateTime updatedAt) {
		this.threadCount = threadCount;
		this.updatedAt = updatedAt;
	}
	
	public ThreadCounterStatus(Long id, int threadCount, LocalDateTime updatedAt) {
		this.id = id;
		this.threadCount = threadCount;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(int threadCount) {
		this.threadCount = threadCount;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
}
