package com.pluralsight;

import java.math.BigDecimal;

//! Extend establishes the inheritance relationship
public class House extends Asset {

    //! Backing variables unique to House class
    private String address;
    //* 1 - excellent, 2 - good, 3 - fair, 4 - poor
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        //! Super calls the parent constructor, and must be the first statement in the constructor
        super(description, dateAcquired, originalCost);
        this.address = address;
        if (condition >= 1 && condition <= 4) {
            this.condition = condition;
        } else {
            throw new IllegalArgumentException("Invalid house condition");
        }
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        if (condition >= 1 && condition <= 4) {
            this.condition = condition;
        } else {
            throw new IllegalArgumentException("Invalid house condition");
        }
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSquareFoot = BigDecimal.ZERO;
        switch (getCondition()) {
            case 1 -> pricePerSquareFoot = BigDecimal.valueOf(180);
            case 2 -> pricePerSquareFoot = BigDecimal.valueOf(130);
            case 3 -> pricePerSquareFoot = BigDecimal.valueOf(90);
            case 4 -> pricePerSquareFoot = BigDecimal.valueOf(80);
        }
        BigDecimal houseValue = pricePerSquareFoot
                .multiply(BigDecimal.valueOf(getSquareFoot()))
                .add(new BigDecimal("0.25")
                        .multiply(BigDecimal.valueOf(getLotSize())));
        return houseValue;
    }

}
