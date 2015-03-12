package org.reparationservice.usecases.reparation.add;

public class AddReparationResponderSpy implements AddReparationResponder {
  private int customerNotFoundCalledCount = 0;
  private int deviceNotFoundWasCalledTimes = 0;

  public int customerNotFoundWasCalledTimes() {
    return customerNotFoundCalledCount;
  }

  @Override public void customerNotFound() {
    customerNotFoundCalledCount++;
  }

  @Override public void deviceNotFound() {
    deviceNotFoundWasCalledTimes++;
  }

  public int deviceNotFoundWasCalledTimes() {
    return deviceNotFoundWasCalledTimes;
  }
}
