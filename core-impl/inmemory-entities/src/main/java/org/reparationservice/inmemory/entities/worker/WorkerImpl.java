package org.reparationservice.inmemory.entities.worker;

import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;

public class WorkerImpl extends Worker {
	private String userName;

	public WorkerImpl(WorkerDTO workerDTO) {
		this.userName = workerDTO.getUserName();
	}

	@Override
	public String getUserName() {
		return userName;
	}
}
