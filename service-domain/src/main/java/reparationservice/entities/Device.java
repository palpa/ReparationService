package reparationservice.entities;

import org.joda.time.DateTime;

import reparationservice.dtos.ReparationDTO;

public abstract class Device {
	public static Device NULL = new NullDevice();
	public abstract long getSerialNumber();
	public abstract Reparation getReparation(DateTime creationDate);
	public abstract void addReparation(ReparationDTO reparationDTO);
	
	private static class NullDevice extends Device {
		@Override
		public long getSerialNumber() {
			return -1;
		}
		
		@Override
		public Reparation getReparation(DateTime creationDate) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addReparation(ReparationDTO reparationDTO) {
			// TODO Auto-generated method stub
			
		}
	}
}
