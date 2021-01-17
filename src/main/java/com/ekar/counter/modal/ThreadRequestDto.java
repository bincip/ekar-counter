package com.ekar.counter.modal;

public class ThreadRequestDto {

	private int producerCount;

	private int consumerCount;

	public ThreadRequestDto() {
		super();
	}

	public ThreadRequestDto(int producerCount, int consumerCount) {
		this.producerCount = producerCount;
		this.consumerCount = consumerCount;
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

}
