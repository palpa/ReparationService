package reparationservice.entities;



import org.joda.time.DateTime;

public class Reparation {
	private DateTime creationDate;
	private String deviceFaiulure;
	
	public static Reparation newInstance(DateTime creationDate,
			long deviceSerialNumber, String deviceFaiulure) {
		return new Reparation(creationDate, deviceSerialNumber, deviceFaiulure);
	}

	public Reparation(DateTime creationDate, long deviceSerialNumber, String deviceFaiulure) {
		this.creationDate = creationDate;
		this.deviceFaiulure = deviceFaiulure;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public String getDeviceFailure() {
		return deviceFaiulure;
	}
}
