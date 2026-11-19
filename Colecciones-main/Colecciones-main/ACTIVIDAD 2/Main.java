package Actividad_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Ana", 8.5));
        alumnos.add(new Alumno("Luis", 7.0));
        alumnos.add(new Alumno("Ana", 8.5));

        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }
}