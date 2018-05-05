package in.co.parking.lot;

import in.co.parking.constants.VehicleType;
import in.co.parking.vehicle.Vehicle;

public class ParkingLot {

  private Vehicle vehicle;
  private VehicleType vehicleType;
  private int level;
  private int spotNumber;


  public ParkingLot(VehicleType vehicleType, int level, int spotNumber) {
    this.vehicleType = vehicleType;
    this.level = level;
    this.spotNumber = spotNumber;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public void setSpotNumber(int spotNumber) {
    this.spotNumber = spotNumber;
  }

  @Override
  public String toString() {
    return "ParkingLot{" + "vehicle=" + vehicle + ", vehicleType=" + vehicleType + ", level="
        + level + ", spotNumber=" + spotNumber + '}';
  }
}
