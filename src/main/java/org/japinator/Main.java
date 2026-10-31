package org.japinator;
import java.util.*;

// Sistema de registro y control de calificaciones de alumnos de una institucion educativa

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condicion = true; // Condicion para el bucle

        /*ArrayList<String> listaAlumnos = new ArrayList<>();
        listaAlumnos.add("Juan Perez");
        listaAlumnos.add("Miriam Flores");
        listaAlumnos.add("Peter Solis");*/

        SortedSet<Alumno> listaAlumnos = new TreeSet<>();

        listaAlumnos.add(new Alumno("A002", "Miriam Flores"));
        listaAlumnos.add(new Alumno("A001", "Juan Perez"));

        // Creamos el bucle principal de funcionamiento
        do{
            System.out.println("""
                BIENVENIDO AL MENU PRINCIPAL
                ---------------------------------------
                1) REGISTRAR ALUMNO
                2) VER LISTA DE ALUMNOS
                3) REGISTRAR/MODIFICAR NOTAS
                4) VER LISTA DE NOTAS
                5) SALIR
                """);
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el codigo del alumno nuevo (Revise la lista de alumnos para evitar errores.)");
                    String codigoAlumnoNuevo = sc.nextLine();

                    System.out.println("Ingrese el nombre completo del alumno nuevo");
                    String nombreAlumnoNuevo = sc.nextLine();

                    Alumno nuevoAlumno = new Alumno(codigoAlumnoNuevo, nombreAlumnoNuevo);
                    listaAlumnos.add(nuevoAlumno);
                    break;
                }
                case 2 -> {
                    for(Alumno a : listaAlumnos){
                        System.out.println(a);
                    }
                    break;
                }
                case 3 -> {
                    condicion = false;
                    break;
                }
                case 4 -> {
                    condicion = false;
                    break;
                }
                case 5 -> {
                    condicion = false;
                    break;
                }
            }
        }while(condicion);
    }
}