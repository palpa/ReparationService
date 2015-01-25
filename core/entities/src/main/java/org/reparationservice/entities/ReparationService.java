package org.reparationservice.entities;

import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.entities.worker.WorkerGateway;

public interface ReparationService extends WorkerGateway, DeviceTypeGateway, CustomerGateway {
}
