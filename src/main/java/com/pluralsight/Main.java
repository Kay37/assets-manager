package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();
        //! House assets:
        House vacationHome = new House("My vacation home with a beach view", "2026",
                BigDecimal.valueOf(1000000.00), "1234 ImRich Street", 1, 10000, 100000);
        House normalHome = new House("My normal pad yo.", "2026", BigDecimal.valueOf(300000),
                "1235 FakeStreet Street", 2, 1600, 2500);

        //! Vehicle assets:
        Vehicle myCar = new Vehicle("2004 Honda Accord LX 4-cyl", "2022",
                BigDecimal.valueOf(0), "Honda Accord", 2004, 186000);
        Vehicle myGirlfriendsCar = new Vehicle("Girlfriend's Car", "2019",
                BigDecimal.valueOf(25000), "Jeep Compass", 2019, 130000);
        assets.add(vacationHome);
        assets.add(normalHome);
        assets.add(myCar);
        assets.add(myGirlfriendsCar);

        for (Asset asset : assets) {
            if (asset instanceof Vehicle) {
                System.out.println("\nVEHICLE INFORMATION: \n" + "Description - " + asset.getDescription() + "\nMake and Model - " + ((Vehicle) asset).getMakeModel()
                        + "\nDate Acquired - "  + asset.getDateAcquired() + "\nOriginal Cost - $" + asset.getOriginalCost().setScale(
                        2, RoundingMode.HALF_UP) + "\nCurrent value - $" + asset.getValue());
            } else {
                System.out.println("\nHOUSE INFORMATION: \n" + "Description - " + asset.getDescription() + "\nDate Acquired - "
                        + asset.getDateAcquired() + "\nOriginal Cost - $" + asset.getOriginalCost().setScale(
                        2, RoundingMode.HALF_UP) + "\nCurrent value - $" + asset.getValue());
            }
        }
    }
}
