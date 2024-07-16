# Conversor de Monedas | Alura Challenge

Este es un proyecto en Java para un Conversor de Monedas, mi propuesta para el reto de programación de Oracle Next Education (ONE) y Alura. Esta aplicación permite a los usuarios transformar distintas divisas utilizando las tasas de cambio en tiempo real utilizando la API de ExchangeRate.

## Descripción

El programa emplea la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio en tiempo real, permitiendo a los usuarios convertir entre diversas monedas. Además, se utiliza la biblioteca [Gson](https://github.com/google/gson) para gestionar datos JSON dentro del programa.

## Funcionalidades

- **Convertir monedas:** Convierte una cantidad de una moneda a otra usando tasas de cambio actuales.

![imagen](https://github.com/user-attachments/assets/5f91ae2e-64a0-4a67-b41b-3d97f81cfbbf)

- **Manejo de errores:** Validación de entradas para asegurar que las opciones de moneda sean válidas y los montos sean números válidos.

![imagen](https://github.com/user-attachments/assets/5b73d68c-348c-4dc6-bb80-508fb3ad022d)

## Tecnologías utilizadas

- **Lenguaje:** Java
- **API de tasas de cambio:** [ExchangeRate-API](https://www.exchangerate-api.com/)
- **Manejo de JSON:** [Gson](https://github.com/google/gson) (Versión 2.8.8)

## Estructura del proyecto

El proyecto tiene los siguientes archivos principales:

- **`CurrencyConverter.java`**: La clase principal del programa que maneja la conversión de monedas y la interacción con el usuario.
- **`ConversionExchangerate.java`**: Representa un registro de una conversión de moneda, incluyendo detalles como la cantidad, monedas involucradas y la tasa de conversión.

