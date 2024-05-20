package Ejer1;

import java.io.*;

class Nodo {
    String nombre;
    Nodo sig;

    Nodo() {} // constructor sin parámetros
}

class Carrusel {
    Nodo cab;
    int numCaballos;

    Carrusel(int numCaballos) {
        this.numCaballos = numCaballos;
        cab = null;
        iniciarCarrusel();
    }

    public void iniciarCarrusel() {
        for (int i = 0; i < numCaballos; i++) {
            insertarNodoInicio("vacio"); // Inicialmente todos los puestos están vacíos
        }
    }

    public void insertarNodoInicio(String nombre) {
        Nodo nuevo = new Nodo();
        nuevo.nombre = nombre;

        if (cab == null) {
            cab = nuevo;
            nuevo.sig = cab;
        } else {
            nuevo.sig = cab.sig;
            cab.sig = nuevo;
        }
    }

    public void montarCaballo(String nombre) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int puesto;
        System.out.println("Digite el número del puesto donde quiere montar (1-" + numCaballos + "): ");
        puesto = Integer.parseInt(teclado.readLine());
        if (puesto < 1 || puesto > numCaballos) {
            System.out.println("Número de puesto inválido.");
            return;
        }

        Nodo temp = cab;
        for (int i = 1; i < puesto; i++) {
            temp = temp.sig;
        }

        if (!temp.nombre.equals("vacio")) {
            System.out.println("El puesto ya está ocupado.");
        } else {
            temp.nombre = nombre;
        }
    }

    public void imprimirCarrusel() {
        Nodo temp = cab;
        for (int i = 1; i <= numCaballos; i++) {
            System.out.println("Puesto " + i + ": " + temp.nombre);
            temp = temp.sig;
        }
    }
}

class CarruselCaballitos {
    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        Carrusel carrusel = new Carrusel(12); // Creamos un carrusel con 12 caballos

        do {
            System.out.println("1. Montar caballo");
            System.out.println("2. Mostrar carrusel");
            System.out.println("3. Salir");
            System.out.println("Digite la opción: ");
            opc = Integer.parseInt(teclado.readLine());

            switch (opc) {
                case 1:
                    System.out.println("Digite el nombre del niño: ");
                    String nombre = teclado.readLine();
                    carrusel.montarCaballo(nombre);
                    break;
                case 2:
                    carrusel.imprimirCarrusel();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opc != 3);
    }
}