package Actividad_4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Curso> cursos = new HashMap<>();
        cursos.put("C1", new Curso("Programacion III", "Profesor A"));
        cursos.put("C2", new Curso("Estructuras de Datos", "Profesor B"));
        cursos.put("C3", new Curso("Base de Datos", "Profesor C"));

        Curso recuperado = cursos.get("C2");
        System.out.println("Recuperado: " + recuperado);

        for (Map.Entry<String, Curso> e : cursos.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}