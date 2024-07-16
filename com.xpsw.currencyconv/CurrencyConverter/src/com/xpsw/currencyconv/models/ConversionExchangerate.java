package com.xpsw.currencyconv.models;

public record ConversionExchangerate(String base_code, String target_code, float conversion_rate, float conversion_result)
{
    public void printResult()
    {
        System.out.println("La cantidad ingresada equivale a " + conversion_result + target_code);
    }
}