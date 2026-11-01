package org.japinator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;

public class Calificacion {
    private double promedio;
    private ArrayList<Double> notasEstudiante = new ArrayList<>();
    private String codigoAlumno;

    public Calificacion(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public void añadirNota(double nota) {
        notasEstudiante.add(nota);
    }

    // Getters y setters
    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public ArrayList<Double> getNotasEstudiante() {
        return notasEstudiante;
    }


    public String mostrarNotas() {
        String formatoNotas = "";
        int indice = 1;
        for (double nota : notasEstudiante) {
            formatoNotas += String.format("Nota %d -> %.2f\n", indice, nota);
            indice++;
        }

        return formatoNotas;
    }

    public double calcularPromedio() {
        if (notasEstudiante.isEmpty()) {
            return 0;
        }
        double suma = 0;

        for (double nota : notasEstudiante) {
            suma += nota;
        }
        promedio = suma / notasEstudiante.size();
        return promedio;
    }

    //recuperar nota segun su posicion
    public double obtenerNota(int indice) {
        if (indice >= 0 && indice < notasEstudiante.size()) {
            return notasEstudiante.get(indice);
        }
        return -1;
    }

    //ordenar las notas de menor a mayor
    public void ordenarNotas() {
        Collections.sort(notasEstudiante);
    }

    // Buscar una calificación por el código de un alumno
    public static Calificacion buscarCalificacion(ArrayList<Calificacion> registroNotas, String codigo) {
        for (Calificacion calificacion : registroNotas) {
            if (calificacion.getCodigoAlumno().equals(codigo)) {
                return calificacion;
            }
        }
        return null;
    }

    // Modificar una nota
    public boolean modificarNota(int indice, double nuevaNota) {
        if (indice >= 0 && indice < notasEstudiante.size()) {
            notasEstudiante.set(indice, nuevaNota);
            return true;
        }
        return false;
    }

    public static void listarAprobados(ArrayList<Calificacion> registroNotas, SortedSet<Alumno> listaAlumnos) {
        System.out.println("\n  lista de aprobados (Exclusivo para alumnos con exactamente 3 notas).");


        if (registroNotas == null || registroNotas.isEmpty()) {
            System.out.println("Aún no hay registros de notas guardados en el sistema");
            return;
        }

        ArrayList<Calificacion> listaAprobados = new ArrayList<>();

        for (Calificacion c : registroNotas) {

            if (c.getNotasEstudiante().size() == 3) {
                double promedio = c.calcularPromedio();


                if (promedio >= 0 && promedio <= 20) {
                    if (promedio >= 10.5) {
                        listaAprobados.add(c);
                    }
                } else {
                    System.out.printf(" El alumno con código %s registra un promedio fuera de rango (%.2f).\n", c.getCodigoAlumno(), promedio);
                }
            }
        }

        if (listaAprobados.isEmpty()) {
            System.out.println("Ningún alumno con exactamente 3 notas alcanzó la nota aprobatoria en esta tanda.");
            return;
        }


        Collections.sort(listaAprobados, (c1, c2) -> Double.compare(c2.calcularPromedio(), c1.calcularPromedio()));

        System.out.println("--- LISTA OFICIAL DE APROBADOS (3 NOTAS - Ordenados por mérito) ---");
        int puesto = 1;
        for (Calificacion c : listaAprobados) {
            Alumno a = Alumno.buscarAlumno(listaAlumnos, c.getCodigoAlumno());
            String nombre = (a != null) ? a.getNombre() : "Alumno Desconocido";

            System.out.printf(" %d. %s (Cód: %s) -> Promedio: %.2f (¡Aprobado!)\n", puesto, nombre, c.getCodigoAlumno(), c.calcularPromedio());
            puesto++;
        }


        System.out.println("Total de alumnos aprobados con 3 notas: " + listaAprobados.size());
    }


    public static void obtenerNotasExtremas(ArrayList<Calificacion> registroNotas, SortedSet<Alumno> listaAlumnos) {


        if (registroNotas == null || registroNotas.isEmpty()) {
            System.out.println("Aún no hay registros de notas en el sistema para calcular los extremos.");
            return;
        }


        ArrayList<Double> notasValidas = new ArrayList<>();
        int alumnosEvaluados = 0;

        for (Calificacion c : registroNotas) {
            if (c.getNotasEstudiante().size() == 3) {
                alumnosEvaluados++;
                for (double nota : c.getNotasEstudiante()) {
                    if (nota >= 0 && nota <= 20) {
                        notasValidas.add(nota);
                    }
                }
            }
        }


        if (alumnosEvaluados == 0 || notasValidas.isEmpty()) {
            System.out.println("No hay alumnos con exactamente 3 notas válidas en el rango 0-20.");
            return;
        }


        double notaAlta = Collections.max(notasValidas);
        double notaBaja = Collections.min(notasValidas);


        System.out.println("         REPORTE DE EXTREMOS Y EMPATES         ");

        System.out.printf(" Alumnos evaluados bajo este criterio: %d\n", alumnosEvaluados);


        System.out.printf("\n Nota más alta registrada: %.2f\n", notaAlta);

        System.out.println("Alumnos que obtuvieron esta nota: ");
        mostrarAlumnosConNota(registroNotas, listaAlumnos, notaAlta);
        System.out.println();


        System.out.printf("Nota más baja registrada: %.2f\n", notaBaja);

        System.out.println("Alumnos que obtuvieron esta nota:");
        mostrarAlumnosConNota(registroNotas, listaAlumnos, notaBaja);

        System.out.println();
        System.out.println("Análisis de extremos completado");
    }


    private static void mostrarAlumnosConNota(ArrayList<Calificacion> registroNotas, SortedSet<Alumno> listaAlumnos, double notaBuscada) {
        for (Calificacion c : registroNotas) {
            if (c.getNotasEstudiante().size() == 3 && c.getNotasEstudiante().contains(notaBuscada)) {
                Alumno a = Alumno.buscarAlumno(listaAlumnos, c.getCodigoAlumno());
                String nombre = (a != null) ? a.getNombre() : "Alumno Desconocido";
                System.out.printf("%s (Cód: %s)\n", nombre, c.getCodigoAlumno());
            }
        }
    }

}

