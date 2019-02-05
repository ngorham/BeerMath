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
    private final double LITER_IN_MILLILITER = 1000.0;

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
    //Convert barrel to ounce
    public double barrelToOunce(double val){
        return (val * BARREL_IN_OZ);
    }
    //Convert barrel to pint
    public double barrelToPint(double val){
        return (ounceToPint(barrelToOunce(val)));
    }
    //Convert barrel to gallon
    public double barrelToGallon(double val){
        return (val * BARREL_IN_GALLON);
    }
    //Convert barrel to barrel
    public double barrelToBarrel(double val){ return val; }
    //Convert barrel to milliliter
    public double barrelToMilliliter(double val){
        return (ounceToMilliliter(barrelToOunce(val)));
    }
    //Convert barrel to liter
    public double barrelToLiter(double val){
        return (ounceToLiter(barrelToOunce(val)));
    }

    //Milliliter conversion functions
    //Convert milliliter to ounce
    public double milliliterToOunce(double val){
        return (val * MILLILITER_IN_OZ);
    }
    //Convert milliliter to pint
    public double milliliterToPint(double val){
        return (ounceToPint(milliliterToOunce(val)));
    }
    //Convert milliliter to gallon
    public double milliliterToGallon(double val){
        return (ounceToGallon(milliliterToOunce(val)));
    }
    //Convert milliliter to barrel
    public double milliliterToBarrel(double val){
        return (ounceToBarrel(milliliterToOunce(val)));
    }
    //Convert milliliter to milliliter
    public double milliliterToMilliliter(double val){
        return val;
    }
    //Convert milliliter to liter
    public double milliliterToLiter(double val){
        return (val / LITER_IN_MILLILITER);
    }

    //Liter conversion functions
    //Convert liter to ounce
    public double literToOunce(double val){
        return (val * LITER_IN_OZ);
    }
    //Convert liter to pint
    public double literToPint(double val){
        return (ounceToPint(literToOunce(val)));
    }
    //Convert liter to gallon
    public double literToGallon(double val){
        return (ounceToGallon(literToOunce(val)));
    }
    //Convert liter to barrel
    public double literToBarrel(double val){
        return (ounceToBarrel(literToOunce(val)));
    }
    //Convert liter to milliliter
    public double literToMilliliter(double val){
        return (val * LITER_IN_MILLILITER);
    }
    //Convert liter to liter
    public double literToLiter(double val){
        return val;
    }
}
