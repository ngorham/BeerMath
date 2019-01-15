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
    //Private Constants
    private final double PINT_IN_OZ = 16.0;
    private final double GALLON_IN_OZ = 128.0;
    private final double BARREL_IN_OZ = 4032.0;
    private final double MILLILITER_IN_OZ = 0.033814;
    private final double LITER_IN_OZ = 33.814;
    private final double BARREL_IN_GALLON = 31.5;

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
    //Convert ounce to gallon
    public double ounceToGallon(double val){
        return (val / GALLON_IN_OZ);
    }
    //Convert ounce to barrel
    public double ounceToBarrel(double val){
        return (val / BARREL_IN_OZ);
    }
    //Convert ounce to milliliter
    public double ounceToMilliliter(double val){
        return (val / MILLILITER_IN_OZ);
    }
    //Convert ounce to liter
    public double ounceToLiter(double val){
        return (val / LITER_IN_OZ);
    }

    //Pint conversion functions
    //Convert pint to ounce
    public double pintToOunce(double val){
        return (val * PINT_IN_OZ);
    }
    //Convert pint to pint
    public double pintToPint(double val){
        return val;
    }
    //Convert pint to gallon
    public double pintToGallon(double val){
        return (ounceToGallon(pintToOunce(val)));
    }
    //Convert pint to barrel
    public double pintToBarrel(double val){
        return (ounceToBarrel(pintToOunce(val)));
    }
    //Convert pint to milliliter
    public double pintToMilliliter(double val){
        return (ounceToMilliliter(pintToOunce(val)));
    }
    //Convert pint to liter
    public double pintToLiter(double val){
        return (ounceToLiter(pintToOunce(val)));
    }

    //Gallon conversion functions
    //Convert gallon to ounce
    public double gallonToOunce(double val){
        return (val * GALLON_IN_OZ);
    }
    //Convert gallon to pint
    public double gallonToPint(double val){
        return (ounceToPint(gallonToOunce(val)));
    }
    //Convert gallon to gallon
    public double gallonToGallon(double val){
        return val;
    }
    //Convert gallon to barrel
    public double gallonToBarrel(double val){
        return (val / BARREL_IN_GALLON);
    }
    //Convert gallon to milliliter
    public double gallonToMilliliter(double val){
        return (ounceToMilliliter(gallonToOunce(val)));
    }
    //Convert gallon to liter
    public double gallonToLiter(double val){
        return (ounceToLiter(gallonToOunce(val)));
    }

    //Barrel conversion functions
    //Milliliter conversion functions
    //Liter conversion functions
}
