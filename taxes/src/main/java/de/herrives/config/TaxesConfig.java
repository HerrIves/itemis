package de.herrives.config;


public class TaxesConfig {
    private static final double BASIC_TAX = 0.10;
    private static final double IMPORT_TAX = 0.05;

    public static double getBasicTax() {        return BASIC_TAX;    }
    public static double getImportTax() {        return IMPORT_TAX;    }

}
