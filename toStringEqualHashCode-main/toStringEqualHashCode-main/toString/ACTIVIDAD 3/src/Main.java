public class Main {
    public static void main(String[] args) {
        // Crear objetos de tipo Estudiante
        Estudiante e1 = new Estudiante("E101", "Ana Gómez");
        Estudiante e2 = new Estudiante("E102", "Juan Pérez");
        Estudiante e3 = new Estudiante("E103", "María Rodríguez");
        Estudiante e4 = new Estudiante("E104", "Lucas Fernández");

        // Instanciar primer curso y agregar alumnos
        Curso curso1 = new Curso("Estructuras de Datos", "Prof. Carlos Ruiz");
        curso1.agregarEstudiante(e1);
        curso1.agregarEstudiante(e2);
        curso1.agregarEstudiante(e3);

        // Instanciar segundo curso y agregar alumnos
        Curso curso2 = new Curso("Programación III", "Prof. Laura Giménez");
        curso2.agregarEstudiante(e2);
        curso2.agregarEstudiante(e4);

        // Imprimir en consola los cursos (al pasarlos a println se invoca implícitamente toString)
        System.out.println(curso1);
        System.out.println("----------------------------------------");
        System.out.println(curso2);
    }
}