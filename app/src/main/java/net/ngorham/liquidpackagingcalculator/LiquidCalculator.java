package net.ngorham.liquidpackagingcalculator;

/**
 * Liquid Packaging Calculator
 * LiquidCalculator.java
 * POJO
 * Purpose: Converts one unit of measurement to another unit of measurement
 *
 * @author Neil Gorham
 * @version 1.0 01/14/2019
 *
 */

public class LiquidCalculator {
    //Constants
    private final double PINT_IN_OZ = 16.0;

    //Default Constructor
    public LiquidCalculator(){}

    //Ounce conversion functions
    //Convert ounce to ounce
    public double ounceToOunce(double val){
        return val;
    }

    //Convert ounce to pint
    public double ounceToPint(double val){
        return (val / PINT_IN_OZ);
    }
    //Pint conversion functions
    //Gallon conversion functions
    //Barrel conversion functions
    //Milliliter conversion functions
    //Liter conversion functions
}
