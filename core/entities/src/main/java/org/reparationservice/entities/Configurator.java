package org.reparationservice.entities;

import org.reparationservice.entities.customer.*;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;

public interface Configurator {
    CustomerGateway getCustomerGateway();

    DeviceTypeGateway getDeviceTypeGateway();

    WorkerGateway getWorkerGateway();

    Customer getNewCustomer(long customerId);

    Device getNewDevice(long deviceSerialNumber);

    DeviceType getNewDeviceType(String deviceTypeDescription);

    Reparation getNewReparation(ReparationDTO reparationDTO);

    Worker getNewWorker(WorkerDTO workerDTO);
}
