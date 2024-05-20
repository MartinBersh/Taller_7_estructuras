package Ejer4;

class ListaCircularIndio {
    NodoIndio cab;
    NodoIndio movil;
    int cn;

    ListaCircularIndio() {
        cab = null;
        cn = 0;
    }

    public void insertarIndio(String nombre, int edad) {
        NodoIndio nuevo = new NodoIndio();
        nuevo.nombre = nombre;
        nuevo.edad = edad;

        if (cab == null) {
            cab = nuevo;
            nuevo.sig = nuevo;
        } else {
            nuevo.sig = cab.sig;
            cab.sig = nuevo;
        }
        cn++;
    }

    public int cantidadIndios() {
        return cn;
    }

    public double calcularEdadPromedio() {
        double sumaEdades = 0;
        movil = cab;
        for (int i = 0; i < cn; i++) {
            sumaEdades += movil.edad;
            movil = movil.sig;
        }
        return sumaEdades / cn;
    }

    public void unirListas(ListaCircularIndio lista2) {
        if (cab == null) {
            cab = lista2.cab;
        } else if (lista2.cab != null) {
            NodoIndio finLista1 = cab.sig;
            NodoIndio finLista2 = lista2.cab.sig;

            cab.sig = lista2.cab;
            finLista2.sig = finLista1;

            lista2.cab.sig = cab;
        }
        cn += lista2.cn;
        lista2.cn = 0;
    }


}