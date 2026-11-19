package Actividad_3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Producto> productos = new HashSet<>();
        productos.add(new Producto("P1", "Teclado"));
        productos.add(new Producto("P2", "Mouse"));
        productos.add(new Producto("P1", "Teclado duplicado"));

        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}