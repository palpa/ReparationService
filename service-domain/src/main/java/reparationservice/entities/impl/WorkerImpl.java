package reparationservice.entities.impl;

import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Worker;

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
