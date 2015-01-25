package org.reparationservice.datanucleus.entities.worker;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;

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
