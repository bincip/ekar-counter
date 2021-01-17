package com.ekar.counter.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ekar.counter.modal.Response;
import com.ekar.counter.modal.ThreadRequestDto;
import com.ekar.counter.service.ThreadManagementService;

@RestController
@RequestMapping(value = "/thread")
public class ThreadManagementController {

	@Autowired
	ThreadManagementService threadManagementService;

	@RequestMapping(value = "/process-request", method = RequestMethod.POST)
	public ResponseEntity processThreadRequest(@RequestBody ThreadRequestDto threadRequestDto) throws URISyntaxException {
		threadManagementService.processThreadRequest(threadRequestDto);
		return ResponseEntity.created(new URI("/process-request")).body(new Response("Successfully Processed the Request", "SUCCESS"));

	}

	@RequestMapping(value = "/set-counter/{count}", method = RequestMethod.POST)
	public ResponseEntity resetThreadCounter(@PathVariable(value = "count") int count) {

		threadManagementService.resetThreadCounter(count);

		return ResponseEntity.ok().body(new Response("Successfully updated the counter", "SUCCESS"));

	}

}
