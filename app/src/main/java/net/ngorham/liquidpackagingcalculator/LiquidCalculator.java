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
    private final double CAN_8_OZ = 8.0;
    private final double CAN_11_5_0Z = 11.5;
    private final double CAN_12_0Z = 12.0; //can and bottle
    private final double PINT_IN_OZ = 16.0; //can
    private final double BOTTLE_22_0Z = 22.0;
    private final double CROWLER_32_OZ = 32.0;
    private final double GROWLER_64_OZ = 64.0;
    private final double BOTTLE_375_ML_IN_OZ = 12.6803;
    private final double BOTTLE_500_ML_IN_OZ = 16.907;
    private final double BOTTLE_750_ML_IN_OZ = 25.3605;
    private final double BOTTLE_375_ML = 375.0;
    private final double BOTTLE_500_ML = 500.0;
    private final double BOTTLE_750_ML = 750.0;
    private final double GALLON_IN_OZ = 128.0;
    private final double BARREL_IN_OZ = 4032.0;
    private final double MILLILITER_IN_OZ = 0.033814;
    private final double LITER_IN_OZ = 33.814;
    private final double KEG_MINI_IN_GALLON = 1.32;
    private final double KEG_EIGHTH_IN_GALLON = 3.875;
    private final double KEG_CORNY_IN_GALLON = 5.0;
    private final double KEG_SIXTEL_IN_GALLON = 5.16;
    private final double KEG_QUARTER_IN_GALLON = 7.75;
    private final double KEG_HALF_IN_GALLON = 15.5;
    private final double BARREL_IN_GALLON = 31.0;
    private final double KEG_20_IN_LITER = 20.0;
    private final double KEG_30_IN_LITER = 30.0;
    private final double KEG_50_IN_LITER = 50.0;
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
    //Convert ounce to 8oz can
    public double ounceToEightOunce(double val){
        return (val / CAN_8_OZ);
    }
    //Convert ounce to 11.5oz can
    public  double ounceToElevenOunce(double val){
        return (val / CAN_11_5_0Z);
    }
    //Convert ounce to 12oz can
    public double ounceToTwelveOunce(double val){
        return (val / CAN_12_0Z);
    }
    //Convert ounce to 22oz bottle
    public double ounceToTwentyTwoOunce(double val){
        return (val / BOTTLE_22_0Z);
    }
    //Convert ounce to 32oz crowler
    public double ounceToCrowler(double val){
        return (val / CROWLER_32_OZ);
    }
    //Convert ounce to 64oz growler
    public double ounceToGrowler(double val){
        return (val / GROWLER_64_OZ);
    }
    //Convert ounce to 375mL bottle
    public double ounceToThreeSevenFiveML(double val){
        return (val / BOTTLE_375_ML_IN_OZ);
    }
    //Convert ounce to 500mL bottle
    public double ounceToFiveHundredML(double val){
        return (val / BOTTLE_500_ML_IN_OZ);
    }
    //Convert ounce to 750mL bottle
    public double ounceToSevenFiftyML(double val){
        return (val / BOTTLE_750_ML_IN_OZ);
    }
    //Convert ounce to mini keg
    public double ounceToMiniKeg(double val){
        return (ounceToGallon(val) / KEG_MINI_IN_GALLON);
    }
    //Convert ounce to eighth keg
    public double ounceToEighthKeg(double val){
        return (ounceToGallon(val) / KEG_EIGHTH_IN_GALLON);
    }
    //Convert ounce to corny keg
    public double ounceToCornyKeg(double val){
        return (ounceToGallon(val / KEG_CORNY_IN_GALLON));
    }
    //Convert ounce to sixtel keg
    public double ounceToSixtelKeg(double val){
        return (ounceToGallon(val) / KEG_SIXTEL_IN_GALLON);
    }
    //Convert ounce to quarter keg
    public double ounceToQuarterKeg(double val){
        return (ounceToGallon(val) / KEG_QUARTER_IN_GALLON);
    }
    //Convert ounce to half keg
    public double ounceToHalfKeg(double val){
        return (ounceToGallon(val) / KEG_HALF_IN_GALLON);
    }
    //Convert ounce to 20L keg
    public double ounceToTwentyLiterKeg(double val){
        return (ounceToLiter(val) / KEG_20_IN_LITER);
    }
    //Convert ounce to 30L keg
    public double ounceToThirtyLiterKeg(double val){
        return (ounceToLiter(val) / KEG_30_IN_LITER);
    }
    //Convert ounce to 50L keg
    public double ounceToFiftyLiterKeg(double val){
        return (ounceToLiter(val) / KEG_50_IN_LITER);
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
    //Convert pint to 8oz can
    public double pintToEightOunce(double val){
        return (ounceToEightOunce(pintToOunce(val)));
    }
    //Convert pint to 11.5oz can
    public double pintToElevenOunce(double val){
        return (ounceToElevenOunce(pintToOunce(val)));
    }
    //Convert pint to 12oz can
    public  double pintToTwelveOunce(double val){
        return (ounceToTwelveOunce(pintToOunce(val)));
    }
    //Convert pint to 22oz bottle
    public double pintToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(pintToOunce(val)));
    }
    //Convert pint to 32oz crowler
    public double pintToCrowler(double val){
        return (ounceToCrowler(pintToOunce(val)));
    }
    //Convert pint to 64oz growler
    public double pintToGrowler(double val){
        return (ounceToGrowler(pintToOunce(val)));
    }
    //Convert pint to 375mL bottle
    public double pintToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(pintToOunce(val)));
    }
    //Convert pint to 500mL bottle
    public double pintToFiveHundredML(double val){
        return (ounceToFiveHundredML(pintToOunce(val)));
    }
    //Convert pint to 750mL bottle
    public double pintToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(pintToOunce(val)));
    }
    //Convert pint to mini keg
    public double pintToMiniKeg(double val){
        return (gallonToMiniKeg(pintToGallon(val)));
    }
    //Convert pint to eighth keg
    public double pintToEighthKeg(double val){
        return (gallonToEighthKeg(pintToGallon(val)));
    }
    //Convert pint to corny keg
    public double pintToCornyKeg(double val){
        return (gallonToCornyKeg(pintToGallon(val)));
    }
    //Convert pint to sixtel keg
    public double pintToSixtelKeg(double val){
        return (gallonToSixtelKeg(pintToGallon(val)));
    }
    //Convert pint to quarter keg
    public double pintToQuarterKeg(double val){
        return (gallonToQuarterKeg(pintToGallon(val)));
    }
    //Convert pint to half keg
    public double pintToHalfKeg(double val){
        return (gallonToHalfKeg(pintToGallon(val)));
    }
    //Convert pint to 20L keg
    public double pintToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(pintToLiter(val)));
    }
    //Convert pint to 30L keg
    public double pintToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(pintToLiter(val)));
    }
    //Convert pint to 50L keg
    public double pintToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(pintToLiter(val)));
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
    //Convert gallon to 8oz can
    public double gallonToEightOunce(double val){
        return (ounceToEightOunce(gallonToOunce(val)));
    }
    //Convert gallon to 11.5oz can
    public double gallonToElevenOunce(double val){
        return (ounceToElevenOunce(gallonToOunce(val)));
    }
    //Convert gallon to 12oz can
    public double gallonToTwelveOunce(double val){
        return (ounceToTwelveOunce(gallonToOunce(val)));
    }
    //Convert gallon to 22oz bottle
    public double gallonToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(gallonToOunce(val)));
    }
    //Convert gallon to 32oz crowler
    public double gallonToCrowler(double val){
        return (ounceToCrowler(gallonToOunce(val)));
    }
    //Convert gallon to 64oz growler
    public double gallonToGrowler(double val){
        return (ounceToGrowler(gallonToOunce(val)));
    }
    //Convert gallon to 375mL bottle
    public double gallonToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(gallonToOunce(val)));
    }
    //Convert gallon to 500mL bottle
    public double gallonToFiveHundredML(double val){
        return (ounceToFiveHundredML(gallonToOunce(val)));
    }
    //Convert gallon to 750mL bottle
    public double gallonToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(gallonToOunce(val)));
    }
    //Convert gallon to mini keg
    public double gallonToMiniKeg(double val){
        return (val / KEG_MINI_IN_GALLON);
    }
    //Convert gallon to eighth keg
    public double gallonToEighthKeg(double val){
        return (val / KEG_EIGHTH_IN_GALLON);
    }
    //Convert gallon to corny keg
    public double gallonToCornyKeg(double val){
        return (val / KEG_CORNY_IN_GALLON);
    }
    //Convert gallon to sixtel keg
    public double gallonToSixtelKeg(double val){
        return (val / KEG_SIXTEL_IN_GALLON);
    }
    //Convert gallon to quarter keg
    public double gallonToQuarterKeg(double val){
        return (val / KEG_QUARTER_IN_GALLON);
    }
    //Convert gallon to half keg
    public double gallonToHalfKeg(double val){
        return (val / KEG_HALF_IN_GALLON);
    }
    //Convert gallon to 20L keg
    public double gallonToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(gallonToLiter(val)));
    }
    //Convert gallon to 30L keg
    public double gallonToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(gallonToLiter(val)));
    }
    //Convert gallon to 50L keg
    public double gallonToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(gallonToLiter(val)));
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
    //Convert barrel to 8oz can
    public double barrelToEightOunce(double val){
        return (ounceToEightOunce(barrelToOunce(val)));
    }
    //Convert barrel to 11.5oz can
    public double barrelToElevenOunce(double val){
        return (ounceToElevenOunce(barrelToOunce(val)));
    }
    //Convert barrel to 12oz can
    public double barrelToTwelveOunce(double val){
        return (ounceToTwelveOunce(barrelToOunce(val)));
    }
    //Convert barrel to 22oz bottle
    public double barrelToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(barrelToOunce(val)));
    }
    //Convert barrel to 32oz crowler
    public double barrelToCrowler(double val){
        return (ounceToCrowler(barrelToOunce(val)));
    }
    //Convert barrel to 64oz growler
    public double barrelToGrowler(double val){
        return (ounceToGrowler(barrelToOunce(val)));
    }
    //Convert barrel to 375mL bottle
    public double barrelToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(barrelToOunce(val)));
    }
    //Convert barrel to 500mL bottle
    public double barrelToFiveHundredML(double val){
        return (ounceToFiveHundredML(barrelToOunce(val)));
    }
    //Convert barrel to 750mL bottle
    public double barrelToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(barrelToOunce(val)));
    }
    //Convert barrel to mini keg
    public double barrelToMiniKeg(double val){
        return (gallonToMiniKeg(barrelToGallon(val)));
    }
    //Convert barrel to eighth keg
    public double barrelToEighthKeg(double val){
        return (gallonToEighthKeg(barrelToGallon(val)));
    }
    //Convert barrel to corny keg
    public double barrelToCornyKeg(double val){
        return (gallonToCornyKeg(barrelToGallon(val)));
    }
    //Convert barrel to sixtel keg
    public double barrelToSixtelKeg(double val){
        return (gallonToSixtelKeg(barrelToGallon(val)));
    }
    //Convert barrel to quarter keg
    public double barrelToQuarterKeg(double val){
        return (gallonToQuarterKeg(barrelToGallon(val)));
    }
    //Convert barrel to half keg
    public double barrelToHalfKeg(double val){
        return (gallonToHalfKeg(barrelToGallon(val)));
    }
    //Convert barrel to 20L keg
    public double barrelToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(barrelToLiter(val)));
    }
    //Convert barrel to 30L keg
    public double barrelToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(barrelToLiter(val)));
    }
    //Convert barrel to 50L keg
    public double barrelToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(barrelToLiter(val)));
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
    //Convert milliliter to 8oz can
    public double milliliterToEightOunce(double val){
        return (ounceToEightOunce(milliliterToOunce(val)));
    }
    //Convert milliliter to 11.5oz can
    public double milliliterToElevenOunce(double val){
        return (ounceToElevenOunce(milliliterToOunce(val)));
    }
    //Convert milliliter to 12oz can
    public double milliliterToTwelveOunce(double val){
        return (ounceToTwelveOunce(milliliterToOunce(val)));
    }
    //Convert milliliter to 22oz bottle
    public double milliliterToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(milliliterToOunce(val)));
    }
    //Convert milliliter to 32oz crowler
    public double milliliterToCrowler(double val){
        return (ounceToCrowler(milliliterToOunce(val)));
    }
    //Convert milliliter to 64oz growler
    public double milliliterToGrowler(double val){
        return (ounceToGrowler(milliliterToOunce(val)));
    }
    //Convert milliliter to 375mL bottle
    public double milliliterToThreeSevenFiveML(double val){
        return (val / BOTTLE_375_ML);
    }
    //Convert milliliter to 500mL bottle
    public double milliliterToFiveHundredML(double val){
        return (val / BOTTLE_500_ML);
    }
    //Convert milliliter to 750mL bottle
    public double milliliterToSevenFiftyML(double val){
        return (val / BOTTLE_750_ML);
    }
    //Convert milliliter to mini keg
    public double milliliterToMiniKeg(double val){
        return (gallonToMiniKeg(milliliterToGallon(val)));
    }
    //Convert milliliter to eighth keg
    public double milliliterToEighthKeg(double val){
        return (gallonToEighthKeg(milliliterToGallon(val)));
    }
    //Convert milliliter to corny keg
    public double milliliterToCornyKeg(double val){
        return (gallonToCornyKeg(milliliterToGallon(val)));
    }
    //Convert milliliter to sixtel keg
    public double milliliterToSixtelKeg(double val){
        return (gallonToSixtelKeg(milliliterToGallon(val)));
    }
    //Convert milliliter to quarter keg
    public double milliliterToQuarterKeg(double val){
        return (gallonToQuarterKeg(milliliterToGallon(val)));
    }
    //Convert milliliter to half keg
    public double milliliterToHalfKeg(double val){
        return (gallonToHalfKeg(milliliterToGallon(val)));
    }
    //Convert milliliter to 20L keg
    public double milliliterToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(milliliterToLiter(val)));
    }
    //Convert milliliter to 30L keg
    public double milliliterToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(milliliterToLiter(val)));
    }
    //Convert milliliter to 50L keg
    public double milliliterToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(milliliterToLiter(val)));
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
    //Convert liter to 8oz can
    public double literToEightOunce(double val){
        return (ounceToEightOunce(literToOunce(val)));
    }
    //Convert liter to 11.5oz can
    public double literToElevenOunce(double val){
        return (ounceToElevenOunce(literToOunce(val)));
    }
    //Convert liter to 12oz can
    public double literToTwelveOunce(double val){
        return (ounceToTwelveOunce(literToOunce(val)));
    }
    //Convert liter to 22oz bottle
    public double literToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(literToOunce(val)));
    }
    //Convert liter to 32oz crowler
    public double literToCrowler(double val){
        return (ounceToCrowler(literToOunce(val)));
    }
    //Convert liter to 64oz growler
    public double literToGrowler(double val){
        return (ounceToGrowler(literToOunce(val)));
    }
    //Convert liter to 375mL bottle
    public double literToThreeSevenFiveML(double val){
        return (milliliterToThreeSevenFiveML(literToMilliliter(val)));
    }
    //Convert liter to 500mL bottle
    public double literToFiveHundredML(double val){
        return (milliliterToFiveHundredML(literToMilliliter(val)));
    }
    //Convert liter to 750mL bottle
    public double literToSevenFiftyML(double val){
        return (milliliterToSevenFiftyML(literToMilliliter(val)));
    }
    //Convert liter to mini keg
    public double literToMiniKeg(double val){
        return (gallonToMiniKeg(literToGallon(val)));
    }
    //Convert liter to eighth keg
    public double literToEighthKeg(double val){
        return (gallonToEighthKeg(literToGallon(val)));
    }
    //Convert liter to corny keg
    public double literToCornyKeg(double val){
        return (gallonToCornyKeg(literToGallon(val)));
    }
    //Convert liter to sixtel keg
    public double literToSixtelKeg(double val){
        return (gallonToSixtelKeg(literToGallon(val)));
    }
    //Convert liter to quarter keg
    public double literToQuarterKeg(double val){
        return (gallonToQuarterKeg(literToGallon(val)));
    }
    //Convert liter to half keg
    public double literToHalfKeg(double val){
        return (gallonToHalfKeg(literToGallon(val)));
    }
    //Convert liter to 20L keg
    public double literToTwentyLiterKeg(double val){
        return (val / KEG_20_IN_LITER);
    }
    //Convert liter to 30L keg
    public  double literToThirtyLiterKeg(double val){
        return (val / KEG_30_IN_LITER);
    }
    //Convert liter to 50L keg
    public double literToFiftyLiterKeg(double val){
        return (val / KEG_50_IN_LITER);
    }

    //8oz can conversion functions
    //Convert 8oz can to ounce
    public double eightOunceToOunce(double val){
        return (val * CAN_8_OZ);
    }
    //Convert 8oz can to pint
    public double eightOunceToPint(double val){
        return (ounceToPint(eightOunceToOunce(val)));
    }
    //Convert 8oz can to gallon
    public double eightOunceToGallon(double val){
        return (ounceToGallon(eightOunceToOunce(val)));
    }
    //Convert 8oz can to barrel
    public double eightOunceToBarrel(double val){
        return (ounceToBarrel(eightOunceToOunce(val)));
    }
    //Convert 8oz can to milliliter
    public double eightOunceToMilliliter(double val){
        return (ounceToMilliliter(eightOunceToOunce(val)));
    }
    //Convert 8oz can to liter
    public double eightOunceToLiter(double val){
        return (ounceToLiter(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 8oz can
    public double eightOunceToEightOunce(double val){
        return val;
    }
    //Convert 8oz can to 11.5oz can
    public double eightOunceToElevenOunce(double val){
        return (ounceToElevenOunce(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 12oz can
    public double eightOunceToTwelveOunce(double val){
        return (ounceToTwelveOunce(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 22oz bottle
    public double eightOunceToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 32oz crowler
    public double eightOunceToCrowler(double val){
        return (ounceToCrowler(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 64oz growler
    public double eightOunceToGrowler(double val){
        return (ounceToGrowler(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 375mL bottle
    public double eightOunceToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 500mL bottle
    public double eightOunceToFiveHundredML(double val){
        return (ounceToFiveHundredML(eightOunceToOunce(val)));
    }
    //Convert 8oz can to 750mL bottle
    public double eightOunceToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(eightOunceToOunce(val)));
    }
    //Convert 8oz can to mini keg
    public double eightOunceToMiniKeg(double val){
        return (gallonToMiniKeg(eightOunceToGallon(val)));
    }
    //Convert 8oz can to eighth keg
    public double eightOunceToEighthKeg(double val){
        return (gallonToEighthKeg(eightOunceToGallon(val)));
    }
    //Convert 8oz can to corny keg
    public double eightOunceToCornyKeg(double val){
        return (gallonToCornyKeg(eightOunceToGallon(val)));
    }
    //Convert 8oz can to sixtel keg
    public double eightOunceToSixtelKeg(double val){
        return (gallonToSixtelKeg(eightOunceToGallon(val)));
    }
    //Convert 8oz can to quarter keg
    public double eightOunceToQuarterKeg(double val){
        return (gallonToQuarterKeg(eightOunceToGallon(val)));
    }
    //Convert 8oz can to half keg
    public double eightOunceToHalfKeg(double val){
        return (gallonToHalfKeg(eightOunceToGallon(val)));
    }
    //Convert 8oz can to 20L keg
    public double eightOunceToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(eightOunceToLiter(val)));
    }
    //Convert 8oz can to 30L keg
    public double eightOunceToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(eightOunceToLiter(val)));
    }
    //Convert 8oz can to 50L keg
    public double eightOunceToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(eightOunceToLiter(val)));
    }

    //11.5oz can conversion functions
    //Convert 11.5oz can to ounce
    public double elevenOunceToOunce(double val){
        return (val * CAN_11_5_0Z);
    }
    //Convert 11.5oz can to pint
    public double elevenOunceToPint(double val){
        return (ounceToPint(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to gallon
    public double elevenOunceToGallon(double val){
        return (ounceToGallon(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to barrel
    public double elevenOunceToBarrel(double val){
        return (ounceToBarrel(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to milliliter
    public double elevenOunceToMilliliter(double val){
        return (ounceToMilliliter(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to liter
    public double elevenOunceToLiter(double val){
        return (ounceToLiter(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 8oz can
    public double elevenOunceToEightOunce(double val){
        return (ounceToEightOunce(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 11.5oz can
    public double elevenOunceToElevenOunce(double val){
        return val;
    }
    //Convert 11.5oz can to 12oz can
    public double elevenOunceToTwelveOunce(double val){
        return (ounceToTwelveOunce(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 22oz bottle
    public double elevenOunceToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 32oz crowler
    public double elevenOunceToCrowler(double val){
        return (ounceToCrowler(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 64oz growler
    public double elevenOunceToGrowler(double val){
        return (ounceToGrowler(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 375mL bottle
    public double elevenOunceToThreeSevenFiveML(double val){
        return(ounceToThreeSevenFiveML(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 500mL bottle
    public double elevenOunceToFiveHundredML(double val){
        return (ounceToFiveHundredML(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to 750mL bottle
    public double elevenOunceToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(elevenOunceToOunce(val)));
    }
    //Convert 11.5oz can to mini keg
    public double elevenOunceToMiniKeg(double val){
        return (gallonToMiniKeg(elevenOunceToGallon(val)));
    }
    //Convert 11.5oz can to eighth keg
    public double elevenOunceToEighthKeg(double val){
        return (gallonToEighthKeg(elevenOunceToGallon(val)));
    }
    //Convert 11.5oz can to corny keg
    public double elevenOunceToCornyKeg(double val){
        return (gallonToCornyKeg(elevenOunceToGallon(val)));
    }
    //Convert 11.5oz can to sixtel keg
    public double elevenOunceToSixtelKeg(double val){
        return (gallonToSixtelKeg(elevenOunceToGallon(val)));
    }
    //Convert 11.5oz can to quarter keg
    public double elevenOunceToQuarterKeg(double val){
        return (gallonToQuarterKeg(elevenOunceToGallon(val)));
    }
    //Convert 11.5oz can to half keg
    public double elevenOunceToHalfKeg(double val){
        return (gallonToHalfKeg(elevenOunceToGallon(val)));
    }
    //Convert 11.5oz can to 20L keg
    public double elevenOunceToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(elevenOunceToLiter(val)));
    }
    //Convert 11.5oz can to 30L keg
    public double elevenOunceToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(elevenOunceToLiter(val)));
    }
    //Convert 11.5oz can to 50L keg
    public double elevenOunceToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(elevenOunceToLiter(val)));
    }

    //12oz can/bottle conversion functions
    //Convert 12oz can to ounce
    public double twelveOunceToOunce(double val){
        return (val * CAN_12_0Z);
    }
    //Convert 12oz can to pint
    public double twelveOunceToPint(double val){
        return (ounceToPint(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to gallon
    public double twelveOunceToGallon(double val){
        return (ounceToGallon(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to barrel
    public double twelveOunceToBarrel(double val){
        return (ounceToBarrel(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to milliliter
    public double twelveOunceToMilliliter(double val){
        return (ounceToMilliliter(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to liter
    public double twelveOunceToLiter(double val){
        return (ounceToLiter(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 8oz can
    public double twelveOunceToEightOunce(double val){
        return(ounceToEightOunce(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 11.5oz can
    public double twelveOunceToElevenOunce(double val){
        return (ounceToEightOunce(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 12oz can
    public double twelveOunceToTwelveOunce(double val){
        return val;
    }
    //Convert 12oz can to 22oz bottle
    public double twelveOunceToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 32oz crowler
    public double twelveOunceToCrowler(double val){
        return (ounceToCrowler(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 64oz growler
    public double twelveOunceToGrowler(double val){
        return (ounceToGrowler(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 375mL bottle
    public double twelveOunceToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 500mL bottle
    public double twelveOunceToFiveHundredML(double val){
        return (ounceToFiveHundredML(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to 750mL bottle
    public double twelveOunceToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(twelveOunceToOunce(val)));
    }
    //Convert 12oz can to mini keg
    public double twelveOunceToMiniKeg(double val){
        return (gallonToMiniKeg(twelveOunceToGallon(val)));
    }
    //Convert 12oz can to eighth keg
    public double twelveOunceToEighthKeg(double val){
        return (gallonToEighthKeg(twelveOunceToGallon(val)));
    }
    //Convert 12oz can to corny keg
    public double twelveOunceToCornyKeg(double val){
        return (gallonToCornyKeg(twelveOunceToGallon(val)));
    }
    //Convert 12oz can to sixtel keg
    public double twelveOunceToSixtelKeg(double val){
        return (gallonToSixtelKeg(twelveOunceToGallon(val)));
    }
    //Convert 12oz can to quarter keg
    public double twelveOunceToQuarterKeg(double val){
        return (gallonToQuarterKeg(twelveOunceToGallon(val)));
    }
    //Convert 12oz can to half keg
    public double twelveOunceToHalfKeg(double val){
        return (gallonToHalfKeg(twelveOunceToGallon(val)));
    }
    //Convert 12oz can to 20L keg
    public double twelveOunceToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(twelveOunceToLiter(val)));
    }
    //Convert 12oz can to 30L keg
    public double twelveOunceToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(twelveOunceToLiter(val)));
    }
    //Convert 12oz can to 50L keg
    public double twelveOunceToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(twelveOunceToLiter(val)));
    }

    //22oz bottle conversion functions
    //Convert 22oz bottle to ounce
    public double twentyTwoOunceToOunce(double val){
        return (val * BOTTLE_22_0Z);
    }
    //Convert 22oz bottle to pint
    public double twentyTwoOunceToPint(double val){
        return (ounceToPint(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to gallon
    public double twentyTwoOunceToGallon(double val){
        return (ounceToGallon(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to barrel
    public double twentyTwoOunceToBarrel(double val){
        return (ounceToBarrel(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to milliliter
    public double twentyTwoOunceToMilliliter(double val){
        return (ounceToMilliliter(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to liter
    public double twentyTwoOunceToLiter(double val){
        return (ounceToLiter(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 8oz can
    public double twentyTwoOunceToEightOunce(double val){
        return (ounceToEightOunce(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 11.5oz can
    public double twentyTwoOunceToElevenOunce(double val){
        return (ounceToElevenOunce(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 12oz can
    public double twentyTwoOunceToTwelveOunce(double val){
        return (ounceToTwelveOunce(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 22oz bottle
    public double twentyTwoOunceToTwentyTwoOunce(double val){
        return val;
    }
    //Convert 22oz bottle to 32oz crowler
    public double twentyTwoOunceToCrowler(double val){
        return (ounceToCrowler(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 64oz growler
    public double twentyTwoOunceToGrowler(double val){
        return (ounceToGrowler(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 375mL bottle
    public double twentyTwoOunceToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 500mL bottle
    public double twentyTwoOunceToFiveHundredML(double val){
        return (ounceToFiveHundredML(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to 750mL bottle
    public double twentyTwoOunceToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(twentyTwoOunceToOunce(val)));
    }
    //Convert 22oz bottle to mini keg
    public double twentyTwoOunceToMiniKeg(double val){
        return (gallonToMiniKeg(twentyTwoOunceToGallon(val)));
    }
    //Convert 22oz bottle to eighth keg
    public double twentyTwoOunceToEighthKeg(double val){
        return (gallonToEighthKeg(twentyTwoOunceToGallon(val)));
    }
    //Convert 22oz bottle to corny keg
    public double twentyTwoOunceToCornyKeg(double val){
        return (gallonToCornyKeg(twentyTwoOunceToGallon(val)));
    }
    //Convert 22oz bottle to sixtel keg
    public double twentyTwoOunceToSixtelKeg(double val){
        return (gallonToSixtelKeg(twentyTwoOunceToGallon(val)));
    }
    //Convert 22oz bottle to quarter keg
    public double twentyTwoOunceToQuarterKeg(double val){
        return (gallonToQuarterKeg(twentyTwoOunceToGallon(val)));
    }
    //Convert 22oz bottle to half keg
    public double twentyTwoOunceToHalfKeg(double val){
        return (gallonToHalfKeg(twentyTwoOunceToGallon(val)));
    }
    //Convert 22oz bottle to 20L keg
    public double twentyTwoOunceToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(twentyTwoOunceToLiter(val)));
    }
    //Convert 22oz bottle to 30L keg
    public double twentyTwoOunceToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(twentyTwoOunceToLiter(val)));
    }
    //Convert 22oz bottle to 50L keg
    public double twentyTwoOunceToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(twentyTwoOunceToLiter(val)));
    }

    //32oz Crowler conversion functions
    //Convert 32oz crowler to ounce
    public double crowlerToOunce(double val){
        return (val * CROWLER_32_OZ);
    }
    //convert 32oz crowler to pint
    public double crowlerToPint(double val){
        return (ounceToPint(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to gallon
    public double crowlerToGallon(double val){
        return (ounceToGallon(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to barrel
    public double crowlerToBarrel(double val){
        return (ounceToBarrel(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to milliliter
    public  double crowlerToMilliliter(double val){
        return (ounceToMilliliter(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to liter
    public  double crowlerToLiter(double val){
        return (ounceToLiter(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 8oz can
    public double crowlerToEightOunce(double val){
        return (ounceToEightOunce(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 11.5oz can
    public double crowlerToElevenOunce(double val){
        return (ounceToElevenOunce(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 12oz can
    public double crowlerToTwelveOunce(double val){
        return (ounceToTwelveOunce(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 22oz bottle
    public double crowlerToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 32oz crowler
    public double crowlerToCrowler(double val){
        return val;
    }
    //Convert 32oz crowler to 64oz growler
    public double crowlerToGrowler(double val){
        return (ounceToGrowler(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 375mL bottle
    public double crowlerToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 500mL bottle
    public double crowlerToFiveHundredML(double val){
        return (ounceToFiveHundredML(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to 750mL bottle
    public double crowlerToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(crowlerToOunce(val)));
    }
    //Convert 32oz crowler to mini keg
    public double crowlerToMiniKeg(double val){
        return (gallonToMiniKeg(crowlerToGallon(val)));
    }
    //Convert 32oz crowler to eighth keg
    public double crowlerToEighthKeg(double val){
        return (gallonToEighthKeg(crowlerToGallon(val)));
    }
    //Convert 32oz crowler to corny keg
    public double crowlerToCornyKeg(double val){
        return (gallonToCornyKeg(crowlerToGallon(val)));
    }
    //Convert 32oz crowler to sixtel keg
    public double crowlerToSixtelKeg(double val){
        return (gallonToSixtelKeg(crowlerToGallon(val)));
    }
    //Convert 32oz crowler to quarter keg
    public double crowlerToQuarterKeg(double val){
        return (gallonToQuarterKeg(crowlerToGallon(val)));
    }
    //Convert 32oz crowler to half keg
    public double crowlerToHalfKeg(double val){
        return (gallonToHalfKeg(crowlerToGallon(val)));
    }
    //Convert 32oz crowler to 20L keg
    public double crowlerToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(crowlerToLiter(val)));
    }
    //Convert 32oz crowler to 30L keg
    public  double crowlerToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(crowlerToLiter(val)));
    }
    //Convert 32oz crowler to 50L keg
    public double crowlerToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(crowlerToLiter(val)));
    }

    //64oz Growler conversion functions
    //Convert 64oz growler to ounce
    public double growlerToOunce(double val){
        return (val * GROWLER_64_OZ);
    }
    //Convert 64oz growler to pint
    public double growlerToPint(double val){
        return (ounceToPint(growlerToOunce(val)));
    }
    //Convert 64oz growler to gallon
    public double growlerToGallon(double val){
        return (ounceToGallon(growlerToOunce(val)));
    }
    //Convert 64oz growler to barrel
    public double growlerToBarrel(double val){
        return (ounceToBarrel(growlerToOunce(val)));
    }
    //Convert 64oz growler to milliliter
    public double growlerToMilliliter(double val){
        return (ounceToMilliliter(growlerToOunce(val)));
    }
    //Convert 64oz growler to liter
    public double growlerToLiter(double val){
        return (ounceToLiter(growlerToOunce(val)));
    }
    //Convert 64oz growler to 8oz can
    public double growlerToEightOunce(double val){
        return (ounceToEightOunce(growlerToOunce(val)));
    }
    //Convert 64oz growler to 11.5oz can
    public double growlerToElevenOunce(double val){
        return (ounceToElevenOunce(growlerToOunce(val)));
    }
    //Convert 64oz growler to 12oz can
    public double growlerToTwelveOunce(double val){
        return (ounceToTwelveOunce(growlerToOunce(val)));
    }
    //Convert 64oz growler to 22oz bottle
    public double growlerToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(growlerToOunce(val)));
    }
    //Convert 64oz growler to 32oz crowler
    public double growlerToCrowler(double val){
        return (ounceToCrowler(growlerToOunce(val)));
    }
    //Convert 64oz growler to 64oz growler
    public double growlerToGrowler(double val){
        return val;
    }
    //Convert 64oz growler to 375mL bottle
    public double growlerToThreeSevenFiveML(double val){
        return (ounceToThreeSevenFiveML(growlerToOunce(val)));
    }
    //Convert 64oz growler to 500mL bottle
    public double growlerToFiveHundredML(double val){
        return (ounceToFiveHundredML(growlerToOunce(val)));
    }
    //Convert 64oz growler to 750mL bottle
    public double growlerToSevenFiftyML(double val){
        return (ounceToSevenFiftyML(growlerToOunce(val)));
    }
    //Convert 64oz growler to mini keg
    public double growlerToMiniKeg(double val){
        return (gallonToMiniKeg(growlerToGallon(val)));
    }
    //Convert 64oz growler to eighth keg
    public double growlerToEighthKeg(double val){
        return (gallonToEighthKeg(growlerToGallon(val)));
    }
    //convert 64oz growler to corny keg
    public double growlerToCornyKeg(double val){
        return (gallonToCornyKeg(growlerToGallon(val)));
    }
    //Convert 64oz growler to sixtel keg
    public double growlerToSixtelKeg(double val){
        return (gallonToSixtelKeg(growlerToGallon(val)));
    }
    //Convert 64oz growler to quarter keg
    public double growlerToQuarterKeg(double val){
        return (gallonToQuarterKeg(growlerToGallon(val)));
    }
    //Convert 64oz growler to half keg
    public double growlerToHalfKeg(double val){
        return (gallonToHalfKeg(growlerToGallon(val)));
    }
    //Convert 64oz growler to 20L keg
    public double growlerToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(growlerToLiter(val)));
    }
    //Convert 64oz growler to 30L keg
    public double growlerToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(growlerToLiter(val)));
    }
    //Convert 64oz growler to 50L keg
    public double growlerToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(growlerToLiter(val)));
    }

    //375mL bottle conversion functions
    //Convert 375mL bottle to ounce
    public double threeSevenFiveMLToOunce(double val){
        return (val * BOTTLE_375_ML_IN_OZ);
    }
    //Convert 375mL bottle to pint
    public double threeSevenFiveMLToPint(double val){
        return (ounceToPint(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to gallon
    public double threeSevenFiveMLToGallon(double val){
        return (ounceToGallon(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to barrel
    public double threeSevenFiveMLToBarrel(double val){
        return (ounceToBarrel(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to milliliter
    public double threeSevenFiveMLToMilliliter(double val){
        return (val * BOTTLE_375_ML);
    }
    //Convert 375mL bottle to liter
    public double threeSevenFiveMLToLiter(double val){
        return (milliliterToLiter(threeSevenFiveMLToMilliliter(val)));
    }
    //Convert 375mL bottle to 8oz can
    public double threeSevenFiveMLToEightOunce(double val){
        return (ounceToEightOunce(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to 11.5oz can
    public double threeSevenFiveMLToElevenOunce(double val){
        return (ounceToElevenOunce(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to 12oz can
    public double threeSevenFiveMLToTwelveOunce(double val){
        return (ounceToTwelveOunce(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to 22oz bottle
    public double threeSevenFiveMLToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to 32oz crowler
    public double threeSevenFiveMLToCrowler(double val){
        return (ounceToCrowler(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to 64oz growler
    public double threeSevenFiveMLToGrowler(double val){
        return (ounceToGrowler(threeSevenFiveMLToOunce(val)));
    }
    //Convert 375mL bottle to 375mL bottle
    public double threeSevenFiveMLToThreeSevenFiveML(double val){
        return val;
    }
    //Convert 375mL bottle to 500mL bottle
    public double threeSevenFiveMLToFiveHundredML(double val){
        return (milliliterToFiveHundredML(threeSevenFiveMLToMilliliter(val)));
    }
    //Convert 375mL bottle to 750mL bottle
    public double threeSevenFiveMLToSevenFiftyML(double val){
        return (milliliterToSevenFiftyML(threeSevenFiveMLToMilliliter(val)));
    }
    //Convert 375mL bottle to mini keg
    public double threeSevenFiveMLToMiniKeg(double val){
        return (gallonToMiniKeg(threeSevenFiveMLToGallon(val)));
    }
    //Convert 375mL bottle to eighth keg
    public double threeSevenFiveMLToEighthKeg(double val){
        return (gallonToEighthKeg(threeSevenFiveMLToGallon(val)));
    }
    //Convert 375mL bottle to corny keg
    public double threeSevenFiveMLToCornyKeg(double val){
        return (gallonToCornyKeg(threeSevenFiveMLToGallon(val)));
    }
    //Convert 375mL bottle to sixtel keg
    public double threeSevenFiveMLToSixtelKeg(double val){
        return (gallonToSixtelKeg(threeSevenFiveMLToGallon(val)));
    }
    //Convert 375mL bottle to quarter keg
    public double threeSevenFiveMLToQuarterKeg(double val){
        return (gallonToQuarterKeg(threeSevenFiveMLToGallon(val)));
    }
    //Convert 375mL bottle to half keg
    public double threeSevenFiveMLToHalfKeg(double val){
        return (gallonToHalfKeg(threeSevenFiveMLToGallon(val)));
    }
    //Convert 375mL bottle to 20L keg
    public double threeSevenFiveMLToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(threeSevenFiveMLToLiter(val)));
    }
    //Convert 375mL bottle to 30L keg
    public double threeSevenFiveMLToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(threeSevenFiveMLToLiter(val)));
    }
    //Convert 375mL bottle to 50L keg
    public double threeSevenFiveMLToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(threeSevenFiveMLToLiter(val)));
    }

    //500mL bottle conversion functions
    //Convert 500mL bottle to ounce
    public double fiveHundredMLToOunce(double val){
        return (val * BOTTLE_500_ML_IN_OZ);
    }
    //Convert 500mL bottle to pint
    public double fiveHundredMLToPint(double val){
        return (ounceToPint(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to gallon
    public double fiveHundredMLToGallon(double val){
        return (ounceToGallon(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to barrel
    public double fiveHundredMLToBarrel(double val){
        return (ounceToBarrel(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to milliliter
    public double fiveHundredMLToMilliliter(double val){
        return (val * BOTTLE_500_ML);
    }
    //Convert 500mL bottle to liter
    public double fiveHundredMLToLiter(double val){
        return (milliliterToLiter(fiveHundredMLToMilliliter(val)));
    }
    //Convert 500mL bottle to 8oz can
    public double fiveHundredMLToEightOunce(double val){
        return (ounceToEightOunce(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to 11.5oz can
    public double fiveHundredMLToElevenOunce(double val){
        return (ounceToElevenOunce(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to 12oz can
    public double fiveHundredMLToTwelveOunce(double val){
        return (ounceToTwelveOunce(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to 22oz bottle
    public double fiveHundredMLToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to 32oz crowler
    public double fiveHundredMLToCrowler(double val){
        return (ounceToCrowler(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to 64oz growler
    public double fiveHundredMLToGrowler(double val){
        return (ounceToGrowler(fiveHundredMLToOunce(val)));
    }
    //Convert 500mL bottle to 375mL bottle
    public double fiveHundredMLToThreeSevenFiveML(double val){
        return (milliliterToThreeSevenFiveML(fiveHundredMLToMilliliter(val)));
    }
    //Convert 500mL bottle to 500mL bottle
    public double fiveHundredMLToFiveHundredML(double val){
        return val;
    }
    //Convert 500mL bottle to 750mL bottle
    public double fiveHundredMLToSevenFiftyML(double val){
        return (milliliterToFiveHundredML(fiveHundredMLToMilliliter(val)));
    }
    //Convert 500mL bottle to mini keg
    public double fiveHundredMLToMiniKeg(double val){
        return (gallonToMiniKeg(fiveHundredMLToGallon(val)));
    }
    //Convert 500mL bottle to eighth keg
    public double fiveHundredMLToEighthKeg(double val){
        return (gallonToEighthKeg(fiveHundredMLToGallon(val)));
    }
    //Convert 500mL bottle to corny keg
    public double fiveHundredMLToCornyKeg(double val){
        return (gallonToCornyKeg(fiveHundredMLToGallon(val)));
    }
    //Convert 500mL bottle to sixtel keg
    public double fiveHundredMLToSixtelKeg(double val){
        return (gallonToSixtelKeg(fiveHundredMLToGallon(val)));
    }
    //Convert 500mL bottle to quarter keg
    public double fiveHundredMLToQuarterKeg(double val){
        return (gallonToQuarterKeg(fiveHundredMLToGallon(val)));
    }
    //Convert 500mL bottle to half keg
    public double fiveHundredMLToHalfKeg(double val){
        return (gallonToHalfKeg(fiveHundredMLToGallon(val)));
    }
    //Convert 500mL bottle to 20L keg
    public double fiveHundredMLToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(fiveHundredMLToLiter(val)));
    }
    //Convert 500mL bottle to 30L keg
    public double fiveHundredMLToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(fiveHundredMLToLiter(val)));
    }
    //Convert 500mL bottle to 50L keg
    public double fiveHundredMLToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(fiveHundredMLToLiter(val)));
    }

    //750mL bottle conversion functions
    //Convert 750mL bottle to ounce
    public double sevenFiftyMLToOunce(double val){
        return (val * BOTTLE_750_ML_IN_OZ);
    }
    //Convert 750mL bottle to pint
    public double sevenFiftyMLToPint(double val){
        return (ounceToPint(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to gallon
    public double sevenFiftyMLToGallon(double val){
        return (ounceToGallon(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to barrel
    public double sevenFiftyMLToBarrel(double val){
        return (ounceToBarrel(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to milliliter
    public double sevenFiftyMLToMilliliter(double val){
        return (val * BOTTLE_750_ML);
    }
    //Convert 750mL bottle to liter
    public double sevenFiftyMLToLiter(double val){
        return (milliliterToLiter(sevenFiftyMLToMilliliter(val)));
    }
    //Convert 750mL bottle to 8oz can
    public double sevenFiftyMLToEightOunce(double val){
        return (ounceToEightOunce(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to 11.5oz can
    public double sevenFiftyMLToElevenOunce(double val){
        return (ounceToElevenOunce(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to 12oz can
    public double sevenFiftyMLToTwelveOunce(double val){
        return (ounceToTwelveOunce(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to 22oz bottle
    public double sevenFiftyMLToTwentyTwoOunce(double val){
        return (ounceToTwentyTwoOunce(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to 32oz crowler
    public double sevenFiftyMLToCrowler(double val){
        return (ounceToCrowler(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to 64oz growler
    public double sevenFiftyMLToGrowler(double val){
        return (ounceToGrowler(sevenFiftyMLToOunce(val)));
    }
    //Convert 750mL bottle to 375mL bottle
    public double sevenFiftyMLToThreeSevenFiveML(double val){
        return (milliliterToThreeSevenFiveML(sevenFiftyMLToMilliliter(val)));
    }
    //Convert 750mL bottle to 500mL bottle
    public double sevenFiftyMLToFiveHundredML(double val){
        return (milliliterToFiveHundredML(sevenFiftyMLToMilliliter(val)));
    }
    //Convert 750mL bottle to 750mL bottle
    public double sevenFiftyMLToSevenFiftyML(double val){
        return val;
    }
    //Convert 750mL bottle to mini keg
    public double sevenFiftyMLToMiniKeg(double val){
        return (gallonToMiniKeg(sevenFiftyMLToGallon(val)));
    }
    //Convert 750mL bottle to eighth keg
    public double sevenFiftyMLToEighthKeg(double val){
        return (gallonToEighthKeg(sevenFiftyMLToGallon(val)));
    }
    //Convert 750mL bottle to corny keg
    public double sevenFiftyMLToCornyKeg(double val){
        return (gallonToCornyKeg(sevenFiftyMLToGallon(val)));
    }
    //Convert 750mL bottle to sixtel keg
    public double sevenFiftyMLToSixtelKeg(double val){
        return (gallonToSixtelKeg(sevenFiftyMLToGallon(val)));
    }
    //Convert 750mL bottle to quarter keg
    public double sevenFiftyMLToQuarterKeg(double val){
        return (gallonToQuarterKeg(sevenFiftyMLToGallon(val)));
    }
    //Convert 750mL bottle to half keg
    public double sevenFiftyMLToHalfKeg(double val){
        return (gallonToHalfKeg(sevenFiftyMLToGallon(val)));
    }
    //Convert 750mL bottle to 20L keg
    public double sevenFiftyMLToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(sevenFiftyMLToLiter(val)));
    }
    //Convert 750mL bottle to 30L keg
    public double sevenFiftyMLToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(sevenFiftyMLToLiter(val)));
    }
    //Convert 750ml bottle to 50L keg
    public double sevenFiftyMLToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(sevenFiftyMLToLiter(val)));
    }

    //Mini keg conversion functions
    //Convert mini keg to ounce
    public double miniKegToOunce(double val){
        return (gallonToOunce(miniKegToGallon(val)));
    }
    //Convert mini keg to pint
    public double miniKegToPint(double val){
        return (gallonToPint(miniKegToGallon(val)));
    }
    //Convert mini keg to gallon
    public double miniKegToGallon(double val){
        return (val * KEG_MINI_IN_GALLON);
    }
    //Convert mini keg to barrel
    public double miniKegToBarrel(double val){
        return (gallonToBarrel(miniKegToGallon(val)));
    }
    //Convert mini keg to milliliter
    public double miniKegToMilliliter(double val){
        return (gallonToMilliliter(miniKegToGallon(val)));
    }
    //Convert mini keg to liter
    public double miniKegToLiter(double val){
        return (gallonToLiter(miniKegToGallon(val)));
    }
    //Convert mini keg to 8oz can
    public double miniKegToEightOunce(double val){
        return (gallonToEightOunce(miniKegToGallon(val)));
    }
    //Convert mini keg to 11.5oz can
    public double miniKegToElevenOunce(double val){
        return (gallonToElevenOunce(miniKegToGallon(val)));
    }
    //Convert mini keg to 12oz can
    public double miniKegToTwelveOunce(double val){
        return (gallonToTwelveOunce(miniKegToGallon(val)));
    }
    //Convert mini keg to 22oz bottle
    public double miniKegToTwentyTwoOunce(double val){
        return (gallonToTwentyTwoOunce(miniKegToGallon(val)));
    }
    //Convert mini keg to 32oz crowler
    public double miniKegToCrowler(double val){
        return (gallonToCrowler(miniKegToGallon(val)));
    }
    //Convert mini keg to 64oz growler
    public double miniKegToGrowler(double val){
        return (gallonToGrowler(miniKegToGallon(val)));
    }
    //Convert mini keg to 375mL bottle
    public double miniKegToThreeSevenFiveML(double val){
        return (gallonToThreeSevenFiveML(miniKegToGallon(val)));
    }
    //Convert mini keg to 500mL bottle
    public double miniKegToFiveHundredML(double val){
        return (gallonToFiveHundredML(miniKegToGallon(val)));
    }
    //Convert mini keg to 750mL bottle
    public double miniKegToSevenFiftyML(double val){
        return (gallonToSevenFiftyML(miniKegToGallon(val)));
    }
    //Convert mini keg to mini keg
    public double miniKegToMiniKeg(double val){
        return val;
    }
    //Convert mini keg to eighth keg
    public double miniKegToEighthKeg(double val){
        return (gallonToEighthKeg(miniKegToGallon(val)));
    }
    //Convert mini keg to corny keg
    public double miniKegToCornyKeg(double val){
        return (gallonToCornyKeg(miniKegToGallon(val)));
    }
    //Convert mini keg to sixtel keg
    public double miniKegToSixtelKeg(double val){
        return (gallonToSixtelKeg(miniKegToGallon(val)));
    }
    //Convert mini keg to quarter keg
    public double miniKegToQuarterKeg(double val){
        return (gallonToQuarterKeg(miniKegToGallon(val)));
    }
    //Convert mini keg to half keg
    public double miniKegToHalfKeg(double val){
        return (gallonToHalfKeg(miniKegToGallon(val)));
    }
    //Convert mini keg to 20L keg
    public double miniKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(miniKegToLiter(val)));
    }
    //Convert mini keg to 30L keg
    public double miniKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(miniKegToLiter(val)));
    }
    //Convert mini keg to 50L keg
    public double miniKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(miniKegToLiter(val)));
    }

    //Eighth keg conversion functions
    //Convert eighth keg to ounce
    public double eighthKegToOunce(double val){
        return (gallonToOunce(eighthKegToGallon(val)));
    }
    //Convert eighth keg to pint
    public double eighthKegToPint(double val){
        return (gallonToPint(eighthKegToGallon(val)));
    }
    //Convert eighth keg to gallon
    public double eighthKegToGallon(double val){
        return (val * KEG_EIGHTH_IN_GALLON);
    }
    //Convert eighth keg to barrel
    public double eighthKegToBarrel(double val){
        return (gallonToBarrel(eighthKegToGallon(val)));
    }
    //Convert eighth keg to milliliter
    public double eighthKegToMilliliter(double val){
        return (gallonToMilliliter(eighthKegToGallon(val)));
    }
    //Convert eighth keg to liter
    public double eighthKegToLiter(double val){
        return (gallonToLiter(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 8oz can
    public double eighthKegToEightOunce(double val){
        return (gallonToEightOunce(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 11.5oz can
    public double eighthKegToElevenOunce(double val){
        return (gallonToElevenOunce(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 12oz can
    public double eighthKegToTwelveOunce(double val){
        return (gallonToTwelveOunce(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 22oz bottle
    public double eighthKegToTwentyTwoOunce(double val){
        return (gallonToTwentyTwoOunce(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 32oz crowler
    public double eighthKegToCrowler(double val){
        return (gallonToCrowler(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 64oz growler
    public double eighthKegToGrowler(double val){
        return (gallonToGrowler(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 375mL bottle
    public double eighthKegToThreeSevenFiveML(double val){
        return (gallonToThreeSevenFiveML(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 500mL bottle
    public double eighthKegToFiveHundredML(double val){
        return (gallonToFiveHundredML(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 750mL bottle
    public double eighthKegToSevenFiftyML(double val){
        return (gallonToSevenFiftyML(eighthKegToGallon(val)));
    }
    //Convert eighth keg to mini keg
    public double eighthKegToMiniKeg(double val){
        return (gallonToMiniKeg(eighthKegToGallon(val)));
    }
    //Convert eighth keg to eighth keg
    public double eighthKegToEighthKeg(double val){
        return val;
    }
    //Convert eighth keg to corny keg
    public double eighthKegToCornyKeg(double val){
        return (gallonToCornyKeg(eighthKegToGallon(val)));
    }
    //Convert eighth keg to sixtel keg
    public double eighthKegToSixtelKeg(double val){
        return (gallonToSixtelKeg(eighthKegToGallon(val)));
    }
    //Convert eighth keg to quarter keg
    public double eighthKegToQuarterKeg(double val){
        return (gallonToQuarterKeg(eighthKegToGallon(val)));
    }
    //Convert eighth keg to half keg
    public double eighthKegToHalfKeg(double val){
        return (gallonToHalfKeg(eighthKegToGallon(val)));
    }
    //Convert eighth keg to 20L keg
    public double eighthKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(eighthKegToLiter(val)));
    }
    //Convert eighth keg to 30L keg
    public double eighthKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(eighthKegToLiter(val)));
    }
    //Convert eighth keg to 50L keg
    public double eighthKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(eighthKegToLiter(val)));
    }

    //Corny keg conversion functions
    //Convert corny keg to ounce
    public double cornyKegToOunce(double val){
        return (gallonToOunce(cornyKegToGallon(val)));
    }
    //Convert corny keg to pint
    public double cornyKegToPint(double val){
        return (gallonToPint(cornyKegToGallon(val)));
    }
    //Convert corny keg to gallon
    public double cornyKegToGallon(double val){
        return (val * KEG_CORNY_IN_GALLON);
    }
    //Convert corny keg to barrel
    public double cornyKegToBarrel(double val){
        return (gallonToBarrel(cornyKegToGallon(val)));
    }
    //Convert corny keg to milliliter
    public double cornyKegToMilliliter(double val){
        return (gallonToMilliliter(cornyKegToGallon(val)));
    }
    //Convert corny keg to liter
    public double cornyKegToLiter(double val){
        return (gallonToLiter(cornyKegToGallon(val)));
    }
    //Convert corny keg to 8oz can
    public double cornyKegToEightOunce(double val){
        return (gallonToEightOunce(cornyKegToGallon(val)));
    }
    //Convert corny keg to 11.5oz can
    public double cornyKegToElevenOunce(double val){
        return (gallonToElevenOunce(cornyKegToGallon(val)));
    }
    //Convert corny keg to 12oz can
    public double cornyKegToTwelveOunce(double val){
        return (gallonToTwelveOunce(cornyKegToGallon(val)));
    }
    //Convert corny keg to 22oz bottle
    public double cornyKegToTwentyTwoOunce(double val){
        return (gallonToTwentyTwoOunce(cornyKegToGallon(val)));
    }
    //Convert corny keg to 32oz crowler
    public double cornyKegToCrowler(double val){
        return (gallonToCrowler(cornyKegToGallon(val)));
    }
    //Convert corny keg to 64oz growler
    public double cornyKegToGrowler(double val){
        return (gallonToGrowler(cornyKegToGallon(val)));
    }
    //Convert corny keg to 375mL bottle
    public double cornyKegToThreeSevenFiveML(double val){
        return (gallonToThreeSevenFiveML(cornyKegToGallon(val)));
    }
    //Convert corny keg to 500mL bottle
    public double cornyKegToFiveHundredML(double val){
        return (gallonToFiveHundredML(cornyKegToGallon(val)));
    }
    //Convert corny keg to 750mL bottle
    public double cornyKegToSevenFiftyML(double val){
        return (gallonToSevenFiftyML(cornyKegToGallon(val)));
    }
    //Convert corny keg to mini keg
    public double cornyKegToMiniKeg(double val){
        return (gallonToMiniKeg(cornyKegToGallon(val)));
    }
    //Convert corny keg to eighth keg
    public double cornyKegToEighthKeg(double val){
        return (gallonToEighthKeg(cornyKegToGallon(val)));
    }
    //Convert corny keg to corny keg
    public double cornyKegToCornyKeg(double val){
        return val;
    }
    //Convert corny keg to sixtel keg
    public double cornyKegToSixtelKeg(double val){
        return (gallonToSixtelKeg(cornyKegToGallon(val)));
    }
    //Convert corny keg to quarter keg
    public double cornyKegToQuarterKeg(double val){
        return (gallonToQuarterKeg(cornyKegToGallon(val)));
    }
    //Convert corny keg to half keg
    public double cornyKegToHalfKeg(double val){
        return (gallonToHalfKeg(cornyKegToGallon(val)));
    }
    //Convert corny keg to 20L keg
    public double cornyKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(cornyKegToLiter(val)));
    }
    //Convert corny keg to 30L keg
    public double cornyKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(cornyKegToLiter(val)));
    }
    //Convert corny keg to 50L keg
    public double cornyKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(cornyKegToLiter(val)));
    }

    //Sixtel keg conversion functions
    //Convert sixtel keg to ounce
    public double sixtelKegToOunce(double val){
        return (gallonToOunce(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to pint
    public double sixtelKegToPint(double val){
        return (gallonToPint(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to gallon
    public double sixtelKegToGallon(double val){
        return (val * KEG_SIXTEL_IN_GALLON);
    }
    //Convert sixtel keg to barrel
    public double sixtelKegToBarrel(double val){
        return (gallonToBarrel(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to milliliter
    public double sixtelKegToMilliliter(double val){
        return (gallonToMilliliter(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to liter
    public double sixtelKegToLiter(double val){
        return (gallonToLiter(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 8oz can
    public double sixtelKegToEightOunce(double val){
        return (gallonToEightOunce(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 11.5oz can
    public double sixtelKegToElevenOunce(double val){
        return (gallonToElevenOunce(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 12oz can
    public double sixtelKegToTwelveOunce(double val){
        return (gallonToTwelveOunce(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 22oz bottle
    public double sixtelKegToTwentyTwoOunce(double val){
        return (gallonToTwentyTwoOunce(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 32oz crowler
    public double sixtelKegToCrowler(double val){
        return (gallonToCrowler(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 64oz growler
    public double sixtelKegToGrowler(double val){
        return (gallonToGrowler(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 375mL bottle
    public double sixtelKegToThreeSevenFiveML(double val){
        return (gallonToThreeSevenFiveML(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 500mL bottle
    public double sixtelKegToFiveHundredML(double val){
        return (gallonToFiveHundredML(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 750mL bottle
    public double sixtelKegToSevenFiftyML(double val){
        return (gallonToSevenFiftyML(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to mini keg
    public double sixtelKegToMiniKeg(double val){
        return (gallonToMiniKeg(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to eighth keg
    public double sixtelKegToEighthKeg(double val){
        return (gallonToEighthKeg(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to corny keg
    public double sixtelKegToCornyKeg(double val){
        return (gallonToCornyKeg(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to sixtel keg
    public double sixtelKegToSixtelKeg(double val){
        return val;
    }
    //Convert sixtel keg to quarter keg
    public double sixtelKegToQuarterKeg(double val){
        return (gallonToQuarterKeg(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to half keg
    public double sixtelKegToHalfKeg(double val){
        return (gallonToHalfKeg(sixtelKegToGallon(val)));
    }
    //Convert sixtel keg to 20L keg
    public double sixtelKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(sixtelKegToLiter(val)));
    }
    //Convert sixtel keg to 30L keg
    public double sixtelKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(sixtelKegToLiter(val)));
    }
    //Convert sixtel keg to 50L keg
    public double sixtelKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(sixtelKegToLiter(val)));
    }

    //Quarter keg conversion functions
    //Convert quarter keg to ounce
    public double quarterKegToOunce(double val){
        return (gallonToOunce(quarterKegToGallon(val)));
    }
    //Convert quarter keg to pint
    public double quarterKegToPint(double val){
        return (gallonToPint(quarterKegToGallon(val)));
    }
    //Convert quarter keg to gallon
    public double quarterKegToGallon(double val){
        return (val * KEG_QUARTER_IN_GALLON);
    }
    //Convert quarter keg to barrel
    public double quarterKegToBarrel(double val){
        return (gallonToBarrel(quarterKegToGallon(val)));
    }
    //Convert quarter keg to milliliter
    public double quarterKegToMilliliter(double val){
        return (gallonToMilliliter(quarterKegToGallon(val)));
    }
    //Convert quarter keg to liter
    public double quarterKegToLiter(double val){
        return (gallonToLiter(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 8oz can
    public double quarterKegToEightOunce(double val){
        return (gallonToEightOunce(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 11.5oz can
    public double quarterKegToElevenOunce(double val){
        return (gallonToElevenOunce(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 12oz can
    public double quarterKegToTwelveOunce(double val){
        return (gallonToTwelveOunce(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 22oz bottle
    public double quarterKegToTwentyTwoOunce(double val){
        return (gallonToTwentyTwoOunce(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 32oz crowler
    public double quarterKegToCrowler(double val){
        return (gallonToCrowler(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 64oz growler
    public double quarterKegToGrowler(double val){
        return (gallonToGrowler(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 375mL bottle
    public double quarterKegToThreeSevenFiveML(double val){
        return (gallonToThreeSevenFiveML(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 500mL bottle
    public double quarterKegToFiveHundredML(double val){
        return (gallonToFiveHundredML(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 750mL bottle
    public double quarterKegToSevenFiftyML(double val){
        return (gallonToSevenFiftyML(quarterKegToGallon(val)));
    }
    //Convert quarter keg to mini keg
    public double quarterKegToMiniKeg(double val){
        return (gallonToMiniKeg(quarterKegToGallon(val)));
    }
    //Convert quarter keg to eighth keg
    public double quarterKegToEighthKeg(double val){
        return (gallonToEighthKeg(quarterKegToGallon(val)));
    }
    //Convert quarter keg to corny keg
    public  double quarterKegToCornyKeg(double val){
        return (gallonToCornyKeg(quarterKegToGallon(val)));
    }
    //Convert quarter keg to sixtel keg
    public double quarterKegToSixtelKeg(double val){
        return (gallonToSixtelKeg(quarterKegToGallon(val)));
    }
    //Convert quarter keg to quarter keg
    public double quarterKegToQuarterKeg(double val){
        return val;
    }
    //Convert quarter keg to half keg
    public double quarterKegToHalfKeg(double val){
        return (gallonToQuarterKeg(quarterKegToGallon(val)));
    }
    //Convert quarter keg to 20L keg
    public double quarterKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(quarterKegToLiter(val)));
    }
    //Convert quarter keg to 30L keg
    public double quarterKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(quarterKegToLiter(val)));
    }
    //Convert quarter keg ro 50L keg
    public double quarterKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(quarterKegToLiter(val)));
    }

    //Half keg conversion functions
    //Convert half keg to ounce
    public double halfKegToOunce(double val){
        return (gallonToOunce(halfKegToGallon(val)));
    }
    //Convert half keg to pint
    public double halfKegToPint(double val){
        return (gallonToPint(halfKegToGallon(val)));
    }
    //Convert half keg to gallon
    public double halfKegToGallon(double val){
        return (val * KEG_HALF_IN_GALLON);
    }
    //Convert half keg to barrel
    public double halfKegToBarrel(double val){
        return (gallonToBarrel(halfKegToGallon(val)));
    }
    //Convert half keg to milliliter
    public double halfKegToMilliliter(double val){
        return (gallonToMilliliter(halfKegToGallon(val)));
    }
    //Convert half keg to liter
    public double halfKegToLiter(double val){
        return (gallonToLiter(halfKegToGallon(val)));
    }
    //Convert half keg to 8oz can
    public double halfKegToEightOunce(double val){
        return (gallonToEightOunce(halfKegToGallon(val)));
    }
    //Convert half keg to 11.5oz can
    public double halfKegToElevenOunce(double val){
        return (gallonToElevenOunce(halfKegToGallon(val)));
    }
    //Convert half keg to 12oz can
    public double halfKegToTwelveOunce(double val){
        return (gallonToTwelveOunce(halfKegToGallon(val)));
    }
    //Convert half keg to 22oz bottle
    public double halfKegToTwentyTwoOunce(double val){
        return (gallonToTwentyTwoOunce(halfKegToGallon(val)));
    }
    //Convert half keg to 32oz crowler
    public double halfKegToCrowler(double val){
        return (gallonToCrowler(halfKegToGallon(val)));
    }
    //Convert half keg to 64oz growler
    public double halfKegToGrowler(double val){
        return (gallonToGrowler(halfKegToGallon(val)));
    }
    //Convert half keg to 375mL bottle
    public double halfKegToThreeSevenFiveML(double val){
        return (gallonToThreeSevenFiveML(halfKegToGallon(val)));
    }
    //Convert half keg to 500mL bottle
    public double halfKegToFiveHundredML(double val){
        return (gallonToFiveHundredML(halfKegToGallon(val)));
    }
    //Convert half keg to 750mL bottle
    public double halfKegToSevenFiftyML(double val){
        return (gallonToSevenFiftyML(halfKegToGallon(val)));
    }
    //Convert half keg to mini keg
    public double halfKegToMiniKeg(double val){
        return (gallonToMiniKeg(halfKegToGallon(val)));
    }
    //Convert half keg to eighth keg
    public double halfKegToEighthKeg(double val){
        return (gallonToEighthKeg(halfKegToGallon(val)));
    }
    //Convert half keg to corny keg
    public double halfKegToCornyKeg(double val){
        return (gallonToCornyKeg(halfKegToGallon(val)));
    }
    //Convert half keg to sixtel keg
    public double halfKegToSixtelKeg(double val){
        return (gallonToSixtelKeg(halfKegToGallon(val)));
    }
    //Convert half keg to quarter keg
    public double halfKegToQuarterKeg(double val){
        return (gallonToQuarterKeg(halfKegToGallon(val)));
    }
    //Convert half keg to half keg
    public double halfKegToHalfKeg(double val){
        return val;
    }
    //Convert half keg to 20L keg
    public double halfKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(halfKegToLiter(val)));
    }
    //Convert half keg to 30L keg
    public double halfKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(halfKegToLiter(val)));
    }
    //Convert half keg to 50L keg
    public double halfKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(halfKegToLiter(val)));
    }

    //20L keg conversion functions
    //Convert 20L keg to ounce
    public double twentyLiterKegToOunce(double val){
        return (literToOunce(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to pint
    public double twentyLiterKegToPint(double val){
        return (literToPint(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to gallon
    public double twentyLiterKegToGallon(double val){
        return (literToGallon(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to barrel
    public double twentyLiterKegToBarrel(double val){
        return (literToBarrel(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to milliliter
    public double twentyLiterKegToMilliliter(double val){
        return (literToMilliliter(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to liter
    public double twentyLiterKegToLiter(double val){
        return (val * KEG_20_IN_LITER);
    }
    //Convert 20L keg to 8oz can
    public double twentyLiterKegToEightOunce(double val){
        return (literToEightOunce(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 11.5oz can
    public double twentyLiterKegToElevenOunce(double val){
        return (literToElevenOunce(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 12oz can
    public double twentyLiterKegToTwelveOunce(double val){
        return (literToTwelveOunce(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 22oz bottle
    public double twentyLiterKegToTwentyTwoOunce(double val){
        return (literToTwentyTwoOunce(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 32oz crowler
    public double twentyLiterKegToCrowler(double val){
        return (literToCrowler(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 64oz growler
    public double twentyLiterKegToGrowler(double val){
        return (literToGrowler(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 375mL bottle
    public double twentyLiterKegToThreeSevenFiveML(double val){
        return (literToThreeSevenFiveML(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 500mL bottle
    public double twentyLiterKegToFiveHundredML(double val){
        return (literToFiveHundredML(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 750mL bottle
    public double twentyLiterKegToSevenFiftyML(double val){
        return (literToSevenFiftyML(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to mini keg
    public double twentyLiterKegToMiniKeg(double val){
        return (literToMiniKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to eighth keg
    public double twentyLiterKegToEighthKeg(double val){
        return (literToEighthKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to corny keg
    public double twentyLiterKegToCornyKeg(double val){
        return (literToCornyKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to sixtel keg
    public double twentyLiterKegToSixtelKeg(double val){
        return (literToSixtelKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to quarter keg
    public double twentyLiterKegToQuarterKeg(double val){
        return (literToQuarterKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to half keg
    public double twentyLiterKegToHalfKeg(double val){
        return (literToHalfKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 20L keg
    public double twentyLiterKegToTwentyLiterKeg(double val){
        return val;
    }
    //Convert 20L keg to 30L keg
    public double twentyLiterKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(twentyLiterKegToLiter(val)));
    }
    //Convert 20L keg to 50L keg
    public double twentyLiterKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(twentyLiterKegToLiter(val)));
    }

    //30L keg conversion functions
    //Convert 30L keg to ounce
    public double thirtyLiterKegToOunce(double val){
        return (literToOunce(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to pint
    public double thirtyLiterKegToPint(double val){
        return (literToPint(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to gallon
    public double thirtyLiterKegToGallon(double val){
        return (literToGallon(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to barrel
    public double thirtyLiterKegToBarrel(double val){
        return (literToBarrel(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to milliliter
    public double thirtyLiterKegToMilliliter(double val){
        return (literToMilliliter(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to liter
    public double thirtyLiterKegToLiter(double val){
        return (val * KEG_30_IN_LITER);
    }
    //Convert 30L keg to 8oz can
    public double thirtyLiterKegToEightOunce(double val){
        return (literToEightOunce(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 11.5oz can
    public double thirtyLiterKegToElevenOunce(double val){
        return (literToElevenOunce(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 12oz can
    public double thirtyLiterKegToTwelveOunce(double val){
        return (literToTwelveOunce(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 22oz bottle
    public double thirtyLiterKegToTwentyTwoOunce(double val){
        return (literToTwentyTwoOunce(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 32oz crowler
    public double thirtyLiterKegToCrowler(double val){
        return (literToCrowler(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 64oz growler
    public double thirtyLiterKegToGrowler(double val){
        return (literToGrowler(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 375mL bottle
    public double thirtyLiterKegToThreeSevenFiveML(double val){
        return (literToThreeSevenFiveML(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 500mL bottle
    public double thirtyLiterKegToFiveHundredML(double val){
        return (literToFiveHundredML(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 750mL bottle
    public double thirtyLiterKegToSevenFiftyML(double val){
        return (literToSevenFiftyML(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to mini keg
    public double thirtyLiterKegToMiniKeg(double val){
        return (literToMiniKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to eighth keg
    public double thirtyLiterKegToEighthKeg(double val){
        return (literToEighthKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to corny keg
    public double thirtyLiterKegToCornyKeg(double val){
        return (literToCornyKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to sixtel keg
    public double thirtyLiterKegToSixtelKeg(double val){
        return (literToSixtelKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to quarter keg
    public double thirtyLiterKegToQuarterKeg(double val){
        return (literToQuarterKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to half keg
    public double thirtyLiterKegToHalfKeg(double val){
        return (literToHalfKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 20L keg
    public double thirtyLiterKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(thirtyLiterKegToLiter(val)));
    }
    //Convert 30L keg to 30L keg
    public double thirtyLiterKegToThirtyLiterKeg(double val){
        return val;
    }
    //Convert 30L keg to 50L keg
    public double thirtyLiterKegToFiftyLiterKeg(double val){
        return (literToFiftyLiterKeg(thirtyLiterKegToLiter(val)));
    }

    //50L keg conversion functions
    //Convert 50L keg to ounce
    public double fiftyLiterKegToOunce(double val){
        return (literToOunce(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to pint
    public double fiftyLiterKegToPint(double val){
        return (literToPint(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to gallon
    public double fiftyLiterKegToGallon(double val){
        return (literToGallon(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to barrel
    public double fiftyLiterKegToBarrel(double val){
        return (literToBarrel(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to milliliter
    public double fiftyLiterKegToMilliliter(double val){
        return (literToMilliliter(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to liter
    public double fiftyLiterKegToLiter(double val){
        return (val * KEG_50_IN_LITER);
    }
    //Convert 50L keg to 8oz can
    public double fiftyLiterKegToEightOunce(double val){
        return (literToEightOunce(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 11.5oz can
    public double fiftyLiterKegToElevenOunce(double val){
        return (literToElevenOunce(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 12oz can
    public double fiftyLiterKegToTwelveOunce(double val){
        return (literToTwelveOunce(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 22oz bottle
    public double fiftyLiterKegToTwentyTwoOunce(double val){
        return (literToTwentyTwoOunce(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 32oz crowler
    public double fiftyLiterKegToCrowler(double val){
        return (literToCrowler(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 64oz growler
    public double fiftyLiterKegToGrowler(double val){
        return (literToGrowler(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 375mL bottle
    public double fiftyLiterKegToThreeSevenFiveML(double val){
        return (literToThreeSevenFiveML(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 500mL bottle
    public double fiftyLiterKegToFiveHundredML(double val){
        return (literToFiveHundredML(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 750mL bottle
    public double fiftyLiterKegToSevenFiftyML(double val){
        return (literToSevenFiftyML(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to mini keg
    public double fiftyLiterKegToMiniKeg(double val){
        return (literToMiniKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to eighth keg
    public double fiftyLiterKegToEighthKeg(double val){
        return (literToEighthKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to corny keg
    public double fiftyLiterKegToCornyKeg(double val){
        return (literToCornyKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to sixtel keg
    public double fiftyLiterKegToSixtelKeg(double val){
        return (literToSixtelKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to quarter keg
    public double fiftyLiterKegToQuarterKeg(double val){
        return (literToQuarterKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to half keg
    public double fiftyLiterKegToHalfKeg(double val){
        return (literToHalfKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 20L keg
    public double fiftyLiterKegToTwentyLiterKeg(double val){
        return (literToTwentyLiterKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 30L keg
    public double fiftyLiterKegToThirtyLiterKeg(double val){
        return (literToThirtyLiterKeg(fiftyLiterKegToLiter(val)));
    }
    //Convert 50L keg to 50L keg
    public double fiftyLiterKegToFiftyLiterKeg(double val){
        return val;
    }
}
