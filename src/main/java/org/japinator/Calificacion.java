
package org.japinator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;

public class Calificacion {

    private double promedio;
    private ArrayList<Double> notasEstudiante = new ArrayList<>();
    private String codigoAlumno;

    public Calificacion(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    // Registrar una nueva nota
    public void añadirNota(double nota) {
        notasEstudiante.add(nota);
    }

    // Obtener codigo del alumno
    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    // Obtener lista de notas
    public ArrayList<Double> getNotasEstudiante() {
        return notasEstudiante;
    }

    // Mostrar notas del estudiante
    public String mostrarNotas() {
        String formatoNotas = "";
        int indice = 1;

        for (double nota : notasEstudiante) {
            formatoNotas += String.format("Nota %d -> %.2f%n", indice, nota);
            indice++;
        }
        return formatoNotas;
    }

    // Calcular promedio del alumno
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

    // Recuperar una nota por su posicion
    public double obtenerNota(int indice) {
        if (indice >= 0 && indice < notasEstudiante.size()) {
            return notasEstudiante.get(indice);
        }
        return -1;
    }

    // Ordenar notas de menor a mayor
    public void ordenarNotas() {
        Collections.sort(notasEstudiante);
    }

    // Buscar calificacion por codigo
    public static Calificacion buscarCalificacion(
            ArrayList<Calificacion> registroNotas, String codigo) {

        for (Calificacion c : registroNotas) {
            if (c.getCodigoAlumno().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    // Modificar una nota existente
    public boolean modificarNota(int indice, double nuevaNota) {
        if (indice >= 0 && indice < notasEstudiante.size()) {
            notasEstudiante.set(indice, nuevaNota);
            return true;
        }
        return false;
    }

    // Mostrar alumnos aprobados
    public static void listarAprobados(
            ArrayList<Calificacion> registroNotas,
            SortedSet<Alumno> listaAlumnos) {

        System.out.println("\nLISTA DE APROBADOS (Alumnos con exactamente 3 notas)");

        if (registroNotas == null || registroNotas.isEmpty()
                || listaAlumnos == null || listaAlumnos.isEmpty()) {
            System.out.println("Aun no hay registros suficientes.");
            return;
        }

        ArrayList<Calificacion> listaAprobados = new ArrayList<>();

        for (Calificacion c : registroNotas) {
            Alumno alumno = Alumno.buscarAlumno(
                    listaAlumnos, c.getCodigoAlumno());

            if (alumno == null || !tieneTresNotasValidas(c)) {
                continue;
            }

            double promedio = c.calcularPromedio();

            if (promedio >= 10.5) {
                listaAprobados.add(c);
            }
        }

        if (listaAprobados.isEmpty()) {
            System.out.println("Ningun alumno con 3 notas alcanzo la nota aprobatoria.");
            return;
        }

        // Ordenar aprobados de mayor a menor promedio
        listaAprobados.sort((c1, c2) ->
                Double.compare(c2.calcularPromedio(), c1.calcularPromedio()));

        System.out.println("--- LISTA OFICIAL DE APROBADOS ---");

        int puesto = 1;
        for (Calificacion c : listaAprobados) {
            Alumno a = Alumno.buscarAlumno(
                    listaAlumnos, c.getCodigoAlumno());

            System.out.printf(
                    "%d. %s (Cod: %s) -> Promedio: %.2f (Aprobado)%n",
                    puesto, a.getNombre(),
                    c.getCodigoAlumno(), c.calcularPromedio());

            puesto++;
        }

        System.out.println("Total de alumnos aprobados: "
                + listaAprobados.size());
    }

    // Mostrar nota mas alta y mas baja
    public static void obtenerNotasExtremas(
            ArrayList<Calificacion> registroNotas,
            SortedSet<Alumno> listaAlumnos) {

        if (registroNotas == null || registroNotas.isEmpty()
                || listaAlumnos == null || listaAlumnos.isEmpty()) {
            System.out.println("No hay registros suficientes.");
            return;
        }

        ArrayList<Double> notasValidas = new ArrayList<>();
        int alumnosEvaluados = 0;

        for (Calificacion c : registroNotas) {
            Alumno alumno = Alumno.buscarAlumno(
                    listaAlumnos, c.getCodigoAlumno());

            if (alumno == null || !tieneTresNotasValidas(c)) {
                continue;
            }

            alumnosEvaluados++;
            notasValidas.addAll(c.getNotasEstudiante());
        }

        if (notasValidas.isEmpty()) {
            System.out.println("No hay alumnos con 3 notas validas.");
            return;
        }

        double notaAlta = Collections.max(notasValidas);
        double notaBaja = Collections.min(notasValidas);

        System.out.println("\nREPORTE DE EXTREMOS Y EMPATES");
        System.out.println("Alumnos evaluados: " + alumnosEvaluados);

        System.out.printf("Nota mas alta registrada: %.2f%n", notaAlta);
        System.out.println("Alumnos que obtuvieron esta nota:");
        mostrarAlumnosConNota(registroNotas, listaAlumnos, notaAlta);

        System.out.printf("%nNota mas baja registrada: %.2f%n", notaBaja);
        System.out.println("Alumnos que obtuvieron esta nota:");
        mostrarAlumnosConNota(registroNotas, listaAlumnos, notaBaja);

        System.out.println("Analisis de extremos completado.");
    }

    // Mostrar alumnos con notas extremas
    private static void mostrarAlumnosConNota(
            ArrayList<Calificacion> registroNotas,
            SortedSet<Alumno> listaAlumnos,
            double notaBuscada) {

        for (Calificacion c : registroNotas) {
            if (!tieneTresNotasValidas(c)) {
                continue;
            }

            Alumno a = Alumno.buscarAlumno(
                    listaAlumnos, c.getCodigoAlumno());

            if (a != null && c.getNotasEstudiante().contains(notaBuscada)) {
                System.out.printf("%s (Cod: %s)%n",
                        a.getNombre(), c.getCodigoAlumno());
            }
        }
    }

    // Verificar que existan exactamente 3 notas validas
    private static boolean tieneTresNotasValidas(Calificacion c) {
        if (c == null || c.getNotasEstudiante().size() != 3) {
            return false;
        }

        for (double nota : c.getNotasEstudiante()) {
            if (!Double.isFinite(nota) || nota < 0 || nota > 20) {
                return false;
            }
        }
        return true;
    }

    // APORTE INDIVIDUAL: REPORTE ESTADISTICO DE CALIFICACIONES
    public static void mostrarReporteEstadistico(
            ArrayList<Calificacion> registroNotas,
            SortedSet<Alumno> listaAlumnos) {

        int aprobados = 0;
        int desaprobados = 0;
        double sumaPromedios = 0;
        ArrayList<Double> promedios = new ArrayList<>();

        // Verificar que existan registros
        if (registroNotas == null || registroNotas.isEmpty()
                || listaAlumnos == null || listaAlumnos.isEmpty()) {
            System.out.println("No hay registros suficientes para generar el reporte.");
            return;
        }

        // Recorrer registros de calificaciones
        for (Calificacion c : registroNotas) {

            // Verificar que el alumno exista
            Alumno alumno = Alumno.buscarAlumno(
                    listaAlumnos, c.getCodigoAlumno());

            if (alumno == null) {
                continue;
            }

            // Evaluar solo alumnos con exactamente 3 notas validas
            if (!tieneTresNotasValidas(c)) {
                continue;
            }

            // Calcular promedio individual
            double promedio = c.calcularPromedio();
            promedios.add(promedio);
            sumaPromedios += promedio;

            // Clasificar aprobados y desaprobados
            if (promedio >= 10.5) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }

        // Mostrar resultados estadisticos
        System.out.println("\nREPORTE ESTADISTICO");
        System.out.println("------------------------------");
        System.out.println("Total de alumnos: " + listaAlumnos.size());
        System.out.println("Alumnos evaluados: " + promedios.size());
        System.out.println("Alumnos aprobados: " + aprobados);
        System.out.println("Alumnos desaprobados: " + desaprobados);

        if (!promedios.isEmpty()) {

            // Calcular resultados generales
            double promedioGeneral = sumaPromedios / promedios.size();
            double porcentajeAprobados = aprobados * 100.0 / promedios.size();
            double porcentajeDesaprobados = desaprobados * 100.0 / promedios.size();

            System.out.printf("Promedio general: %.2f%n", promedioGeneral);
            System.out.printf("Promedio mas alto: %.2f%n",
                    Collections.max(promedios));
            System.out.printf("Promedio mas bajo: %.2f%n",
                    Collections.min(promedios));
            System.out.printf("Porcentaje de aprobados: %.2f%%%n",
                    porcentajeAprobados);
            System.out.printf("Porcentaje de desaprobados: %.2f%%%n",
                    porcentajeDesaprobados);

        } else {
            System.out.println("No hay alumnos con 3 notas validas.");
        }

        System.out.println("------------------------------");
    }
}
