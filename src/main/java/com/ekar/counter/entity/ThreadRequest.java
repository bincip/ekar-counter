package com.ekar.counter.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ThreadRequest {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int producerCount;
	
	private int consumerCount;
	
	private LocalDateTime requestedAt;
	
	public ThreadRequest() {
		super();
	}
	
	
	public ThreadRequest( int producerCount, int consumerCount, LocalDateTime requestedAt) {
		this.producerCount = producerCount;
		this.consumerCount = consumerCount;
		this.requestedAt = requestedAt;
	}
	
	public ThreadRequest(Long id, int producerCount, int consumerCount, LocalDateTime requestedAt) {
		this.id = id;
		this.producerCount = producerCount;
		this.consumerCount = consumerCount;
		this.requestedAt = requestedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProducerCount() {
		return producerCount;
	}

	public void setProducerCount(int producerCount) {
		this.producerCount = producerCount;
	}

	public int getConsumerCount() {
		return consumerCount;
	}

	public void setConsumerCount(int consumerCount) {
		this.consumerCount = consumerCount;
	}

	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(LocalDateTime requestedAt) {
		this.requestedAt = requestedAt;
	}
	
	

}
