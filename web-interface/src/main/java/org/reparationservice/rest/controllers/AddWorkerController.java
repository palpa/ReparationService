package org.reparationservice.rest.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddWorkerController {

	@RequestMapping(value = "/workers", method = RequestMethod.POST)
    HttpEntity<?> addWorker() {
		return new ResponseEntity<>(HttpStatus.OK);
    }
}
