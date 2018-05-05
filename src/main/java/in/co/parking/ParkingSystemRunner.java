package in.co.parking;

import java.util.Scanner;

import in.co.parking.constants.VehicleType;
import in.co.parking.lot.ParkingLot;

public class ParkingSystemRunner {

  public static void main(String[] args) {

    ParkingSystem parkingSystem = new ParkingSystem(2, 5).build();
    Scanner scanner = new Scanner(System.in);

    parkingSystem.printParkingInfo();

    while (true) {
      System.out.println(" 1 : two wheeler, 2 : car, 3 : bus, 0 : quit");
      int type = scanner.nextInt();
      if (type == 0) {
        break;
      }
      VehicleType vehicleType = type == 1 ? VehicleType.TWO_WHEELER
          : (type == 2 ? VehicleType.FOUR_WHEELER_COMPACT : VehicleType.FOUR_WHEELER_LARGE);
      ParkingLot parkingLot = parkingSystem.findParkingLot(vehicleType);

      if (parkingLot == null) {
        System.out.println("parking full for vehicle type : " + vehicleType);
        break;
      }
    }

    parkingSystem.printParkingInfo();

  }
}
