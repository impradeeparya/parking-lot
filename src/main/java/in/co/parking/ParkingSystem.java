package in.co.parking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import in.co.parking.constants.VehicleType;
import in.co.parking.lot.ParkingLot;

public class ParkingSystem {

  private Map<Integer, List<ParkingLot>> parkingLots = new HashMap<>();
  private List<ParkingLot> parkedVehicle = new LinkedList<>();
  private int level;
  private int lots;

  public ParkingSystem(int level, int lots) {
    this.level = level;
    this.lots = lots;
  }

  public void printParkingInfo() {

    System.out.println("parking left : " + parkingLots);
    System.out.println("parking taken : " + parkedVehicle);
  }

  public ParkingLot findParkingLot(VehicleType vehicleType) {
    ParkingLot parking = null;


    for (Entry<Integer, List<ParkingLot>> parkingLot : parkingLots.entrySet()) {
      for (ParkingLot lot : parkingLot.getValue()) {
        if (lot.getVehicleType().equals(vehicleType) && lot.getVehicle() == null) {
          parking = lot;
          break;
        }
      }
      if (parking != null) {
        parkingLot.getValue().remove(parking);
        parkedVehicle.add(parking);
        break;
      }
    }
    return parking;
  }

  public ParkingSystem build() {
    IntStream.range(0, level).forEach(level -> {

      List<ParkingLot> parkingLots = new LinkedList<>();
      IntStream.range(0, lots).forEach(spotNumber -> {

        VehicleType vehicleType;
        if (spotNumber < 2) {
          vehicleType = VehicleType.TWO_WHEELER;
        } else if (spotNumber < 4) {
          vehicleType = VehicleType.FOUR_WHEELER_COMPACT;
        } else {
          vehicleType = VehicleType.FOUR_WHEELER_LARGE;
        }

        ParkingLot parkingLot = new ParkingLot(vehicleType, level, spotNumber);
        parkingLots.add(parkingLot);
      });
      this.parkingLots.put(level, parkingLots);
    });
    return this;
  }
}
