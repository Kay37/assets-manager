package com.pluralsight;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        //! Super calls the parent constructor, and must be the first statement in the constructor
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        LocalDate now = LocalDate.now();
        int vehicleAge = now.getYear() - this.year;
        BigDecimal amountDepreciated = BigDecimal.ZERO;
        BigDecimal depreciationRate = BigDecimal.ZERO;
        BigDecimal vehicleValue = BigDecimal.ZERO;
        BigDecimal highMileageMultiplier = BigDecimal.valueOf(1.00);
        switch (vehicleAge) {
            case 0, 1, 2, 3:
                depreciationRate = BigDecimal.valueOf(0.03);
                break;
            case 4, 5, 6:
                depreciationRate = BigDecimal.valueOf(0.06);
                break;
            case 7, 8, 9, 10:
                depreciationRate = BigDecimal.valueOf(0.08);
                break;
            default:
                if (vehicleAge > 10) {
                    vehicleValue = BigDecimal.valueOf(1000.00);
                    return vehicleValue;
                }

        }
        if (getOdometer() > 100000) {
            String reliableModelCheck = getMakeModel().toLowerCase();
            if (reliableModelCheck.contains("toyota")
                    || reliableModelCheck.contains("honda")) {
                highMileageMultiplier = BigDecimal.valueOf(1.00);
            } else {
                highMileageMultiplier = BigDecimal.valueOf(0.75);
            }
        }
        amountDepreciated = depreciationRate
                .multiply(BigDecimal.valueOf(vehicleAge))
                .multiply(getOriginalCost());
        vehicleValue = getOriginalCost().subtract(amountDepreciated).multiply(highMileageMultiplier);
        return vehicleValue;
    }

}
