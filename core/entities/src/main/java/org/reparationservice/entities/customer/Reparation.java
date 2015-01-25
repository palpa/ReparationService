package org.reparationservice.entities.customer;

import org.joda.time.DateTime;

public abstract class Reparation {
	public static final Reparation NULL = new Reparation() {
		@Override
		public String getFailure() {
			return "";
		}

		@Override
		public DateTime getCreationDate() {
			return null;
		}
	};

	public abstract DateTime getCreationDate();

	public abstract String getFailure();
}
