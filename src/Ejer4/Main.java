package Ejer4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaCircularIndio rueda1 = new ListaCircularIndio();
        ListaCircularIndio rueda2 = new ListaCircularIndio();
        do {
            System.out.println("1. Ingresar indios a la primera rueda");
            System.out.println("2. Ingresar indios a la segunda rueda");
            System.out.println("3. Comparar si las dos ruedas son iguales en cantidad de personas");
            System.out.println("4. Determinar la edad promedio de las dos rondas");
            System.out.println("5. Unir las dos ruedas en la tercera rueda");
            System.out.println("6. Mostrar las tres listas");
            System.out.println("7. Salir");
            System.out.println("Digite la opción:");
            opc = Integer.parseInt(Teclado.readLine());

            switch (opc) {
                case 1:
                    System.out.println("Ingrese nombre del indio:");
                    String nombre1 = Teclado.readLine();
                    System.out.println("Ingrese edad del indio:");
                    int edad1 = Integer.parseInt(Teclado.readLine());
                    rueda1.insertarIndio(nombre1, edad1);
                    break;
                case 2:
                    System.out.println("Ingrese nombre del indio:");
                    String nombre2 = Teclado.readLine();
                    System.out.println("Ingrese edad del indio:");
                    int edad2 = Integer.parseInt(Teclado.readLine());
                    rueda2.insertarIndio(nombre2, edad2);
                    break;
                case 3:
                    if (rueda1.cantidadIndios() == rueda2.cantidadIndios()) {
                        System.out.println("Las dos ruedas tienen la misma cantidad de personas.");
                    } else {
                        System.out.println("Las dos ruedas tienen diferente cantidad de personas.");
                    }
                    break;
                case 4:
                    double promedioEdades = (rueda1.calcularEdadPromedio() + rueda2.calcularEdadPromedio()) / 2;
                    System.out.println("La edad promedio de las dos rondas es: " + promedioEdades);
                    break;
                case 5:
                    ListaCircularIndio rueda3 = new ListaCircularIndio();
                    rueda3.unirListas(rueda1);
                    rueda3.unirListas(rueda2);
                    break;

            }
        } while (opc != 6);
    }

}