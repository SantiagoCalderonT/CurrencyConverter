package com.xpsw.currencyconv;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.xpsw.currencyconv.models.ConversionExchangerate;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter
{
    public static void main(String[] args)
    {
        float amount = 0;
        int option = 0;
        String json;
        ConversionExchangerate conversion;
        do
        {
            option = menu();
            switch (option)
            {
                case 1:
                    System.out.print("\nIngresa la cantidad en dólares (USD): ");
                    try
                    {
                        amount = new Scanner(System.in).nextFloat();
                    }
                    catch (InputMismatchException e)
                    {
                        System.err.println("El valor debe ser numérico. Intente nuevamente.");
                    }

                    json = sendRequest(generateUrl("USD","MXN",amount));
                    conversion = new Gson().fromJson(json, ConversionExchangerate.class);
                    conversion.printResult();
                    new Scanner(System.in).nextLine();
                    break;
                case 2:
                    System.out.print("\nIngresa la cantidad en euros (EUR): ");
                    try
                    {
                        amount = new Scanner(System.in).nextFloat();
                    }
                    catch (InputMismatchException e)
                    {
                        System.err.println("El valor debe ser numérico. Intente nuevamente.");
                    }

                    json = sendRequest(generateUrl("EUR","MXN",amount));
                    conversion = new Gson().fromJson(json, ConversionExchangerate.class);
                    conversion.printResult();
                    new Scanner(System.in).nextLine();
                    break;
                case 3:
                    System.out.print("\nIngresa la cantidad en pesos (MXN): ");
                    try
                    {
                        amount = new Scanner(System.in).nextFloat();
                    }
                    catch (InputMismatchException e)
                    {
                        System.err.println("El valor debe ser numérico. Intente nuevamente.");
                    }

                    json = sendRequest(generateUrl("MXN","USD",amount));
                    conversion = new Gson().fromJson(json, ConversionExchangerate.class);
                    conversion.printResult();
                    new Scanner(System.in).nextLine();
                    break;
                case 4:
                    System.out.print("\nIngresa la cantidad en pesos (MXN): ");
                    try
                    {
                        amount = new Scanner(System.in).nextFloat();
                    }
                    catch (InputMismatchException e)
                    {
                        System.err.println("El valor debe ser numérico. Intente nuevamente.");
                    }

                    json = sendRequest(generateUrl("MXN","EUR",amount));
                    conversion = new Gson().fromJson(json, ConversionExchangerate.class);
                    conversion.printResult();
                    new Scanner(System.in).nextLine();
                    break;
                case 5:
                    System.out.println("Hasta pronto :)");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    break;
            }
        } while (option != 5);
    }

    private static int menu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                **********************************
                BIENVENIDO AL CONVERSOR DE MONEDAS
                **********************************
                                            
                SELECCIONA UNA OPCIÓN...
                1) De dólar (USD) a peso mexicano (MXN)
                2) De euro (EUR) a peso mexicano (MXN)
                3) De peso mexicano (MXN) a dólar (USD)
                4) De peso mexicano (MXN) a euro (EUR)
                5) Salir
                                            
                """ + "OPCIÓN: ");
        try
        {
            int option = scanner.nextInt();
            return option;
        } catch (InputMismatchException e)
        {
            System.out.println("Caracter inválido. Intenta nuevamente.");
            return -1;
        }
    }

    private static String generateUrl(String base,String target, float amount)
    {
        return "https://v6.exchangerate-api.com/v6/b096e9eb12dfff05c9a49684/pair/" + base + "/" + target + "/" + amount;
    }

    private static String sendRequest(String url)
    {
        try
        {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error en la URI, verifique la dirección.");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
