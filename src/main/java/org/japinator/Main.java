
package org.japinator;

import java.util.*;

// Sistema de registro y control de calificaciones
// de alumnos de una institucion educativa

public class Main {

    public static void main(String[] args) {

        // Creamos nuestros registros generales
        SortedSet<Alumno> listaAlumnos = new TreeSet<>();
        ArrayList<Calificacion> registroNotas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean condicion = true;

        // Registramos los alumnos iniciales
        listaAlumnos.add(new Alumno("A002", "Miriam Flores"));
        listaAlumnos.add(new Alumno("A001", "Juan Perez"));
        listaAlumnos.add(new Alumno("A003", "Luci Alcala"));
        listaAlumnos.add(new Alumno("A004", "Roberto Torres"));

        // Registramos las notas del primer alumno
        Calificacion notasAlumno1 = new Calificacion("A001");
        notasAlumno1.añadirNota(12.3);
        notasAlumno1.añadirNota(13.7);
        notasAlumno1.añadirNota(19.2);

        // Registramos las notas del segundo alumno
        Calificacion notasAlumno2 = new Calificacion("A002");
        notasAlumno2.añadirNota(13.4);
        notasAlumno2.añadirNota(11.2);
        notasAlumno2.añadirNota(20.0);

        // Registramos las notas del tercer alumno
        Calificacion notasAlumno3 = new Calificacion("A003");
        notasAlumno3.añadirNota(5.3);
        notasAlumno3.añadirNota(10.0);
        notasAlumno3.añadirNota(2.0);

        // Registramos las notas del cuarto alumno
        Calificacion notasAlumno4 = new Calificacion("A004");
        notasAlumno4.añadirNota(11.2);
        notasAlumno4.añadirNota(13.1);
        notasAlumno4.añadirNota(20.0);

        // Guardamos los registros de notas
        registroNotas.add(notasAlumno1);
        registroNotas.add(notasAlumno2);
        registroNotas.add(notasAlumno3);
        registroNotas.add(notasAlumno4);

        // Creamos el bucle principal del sistema
        do {

            System.out.println("""
                    
                    BIENVENIDO AL MENU PRINCIPAL
                    ---------------------------------------
                    1) REGISTRAR ALUMNO
                    2) VER LISTA DE ALUMNOS
                    3) REGISTRAR NOTAS
                    4) MODIFICAR NOTAS
                    5) VER LISTA DE NOTAS
                    6) ELIMINAR UN ALUMNO
                    7) ALUMNOS APROBADOS
                    8) NOTA MAS ALTA Y MAS BAJA
                    9) SALIR
                    10) REPORTE ESTADISTICO
                    ---------------------------------------
                    Seleccione una opcion:
                    """);

            // Validamos que el usuario ingrese un numero
            if (!sc.hasNextInt()) {
                System.out.println("Ingrese una opcion numerica valida.");
                sc.nextLine();
                continue;
            }

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    // Registrar un alumno nuevo
                    System.out.println("Ingrese el codigo del alumno:");
                    String codigoAlumnoNuevo = sc.nextLine().trim();

                    if (codigoAlumnoNuevo.isEmpty()) {
                        System.out.println("El codigo no puede estar vacio.");
                        break;
                    }

                    // Verificamos si el codigo ya existe
                    Alumno existente = Alumno.buscarAlumno(
                            listaAlumnos, codigoAlumnoNuevo);

                    if (existente != null) {
                        System.out.println("Ya existe un alumno con ese codigo.");
                        break;
                    }

                    System.out.println("Ingrese el nombre completo:");
                    String nombreAlumnoNuevo = sc.nextLine().trim();

                    if (nombreAlumnoNuevo.isEmpty()) {
                        System.out.println("El nombre no puede estar vacio.");
                        break;
                    }

                    Alumno nuevoAlumno = new Alumno(
                            codigoAlumnoNuevo, nombreAlumnoNuevo);

                    listaAlumnos.add(nuevoAlumno);

                    System.out.println("Alumno registrado correctamente.");
                }

                case 2 -> {
                    // Mostrar lista de alumnos
                    System.out.println("""
                            
                            LISTA DE ALUMNOS
                            ------------------------
                            """);

                    if (listaAlumnos.isEmpty()) {
                        System.out.println("No hay alumnos registrados.");
                    } else {
                        for (Alumno a : listaAlumnos) {
                            System.out.println(a);
                        }
                    }

                    System.out.println("------------------------");
                }

                case 3 -> {
                    // Registrar notas de un alumno
                    System.out.println("Ingrese el codigo del alumno:");
                    String codigoAlumnoSeleccionado = sc.nextLine().trim();

                    // Verificamos que el alumno exista
                    Alumno alumno = Alumno.buscarAlumno(
                            listaAlumnos, codigoAlumnoSeleccionado);

                    if (alumno == null) {
                        System.out.println("El alumno no existe.");
                        break;
                    }

                    // Buscamos sus calificaciones
                    Calificacion alumnoEncontrado =
                            Calificacion.buscarCalificacion(
                                    registroNotas, codigoAlumnoSeleccionado);

                    // Si no tiene registro, creamos uno nuevo
                    if (alumnoEncontrado == null) {
                        alumnoEncontrado = new Calificacion(
                                codigoAlumnoSeleccionado);

                        registroNotas.add(alumnoEncontrado);
                    }

                    boolean condicionInterna = true;

                    do {
                        System.out.print("Ingrese la nueva nota (0 a 20): ");

                        if (!sc.hasNextDouble()) {
                            System.out.println("Ingrese una nota numerica.");
                            sc.nextLine();
                            continue;
                        }

                        double notaPorIngresar = sc.nextDouble();
                        sc.nextLine();

                        // Validamos el rango permitido
                        if (!Double.isFinite(notaPorIngresar)
                                || notaPorIngresar < 0
                                || notaPorIngresar > 20) {
                            System.out.println("La nota debe estar entre 0 y 20.");
                            continue;
                        }

                        alumnoEncontrado.añadirNota(notaPorIngresar);

                        System.out.println("Nota registrada correctamente.");

                        System.out.println("Desea ingresar otra nota? (S/N)");
                        String respuesta = sc.nextLine().trim();

                        if (!respuesta.equalsIgnoreCase("S")) {
                            condicionInterna = false;
                        }

                    } while (condicionInterna);
                }

                case 4 -> {
                    // Modificar una nota existente
                    System.out.println("Ingrese el codigo del alumno:");
                    String codigoAlumno = sc.nextLine().trim();

                    Calificacion notasEncontradas =
                            Calificacion.buscarCalificacion(
                                    registroNotas, codigoAlumno);

                    if (notasEncontradas == null
                            || notasEncontradas.getNotasEstudiante().isEmpty()) {
                        System.out.println("El alumno no tiene notas registradas.");
                        break;
                    }

                    // Mostramos las notas actuales
                    System.out.println(notasEncontradas.mostrarNotas());

                    System.out.println("Ingrese el numero de nota a modificar:");

                    if (!sc.hasNextInt()) {
                        System.out.println("Numero de nota invalido.");
                        sc.nextLine();
                        break;
                    }

                    int numeroNota = sc.nextInt();
                    sc.nextLine();

                    if (numeroNota < 1
                            || numeroNota > notasEncontradas.getNotasEstudiante().size()) {
                        System.out.println("No existe esa posicion de nota.");
                        break;
                    }

                    System.out.println("Ingrese la nueva nota:");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Ingrese una nota numerica.");
                        sc.nextLine();
                        break;
                    }

                    double nuevaNota = sc.nextDouble();
                    sc.nextLine();

                    if (!Double.isFinite(nuevaNota)
                            || nuevaNota < 0 || nuevaNota > 20) {
                        System.out.println("La nota debe estar entre 0 y 20.");
                        break;
                    }

                    boolean modificada = notasEncontradas.modificarNota(
                            numeroNota - 1, nuevaNota);

                    if (modificada) {
                        System.out.println("Nota modificada correctamente.");
                    } else {
                        System.out.println("No se encontro la nota seleccionada.");
                    }
                }

                case 5 -> {
                    // Mostrar las notas registradas
                    System.out.println("\nLISTA DE NOTAS");
                    System.out.println("------------------------------");

                    if (registroNotas.isEmpty()) {
                        System.out.println("No hay notas registradas.");
                    } else {
                        for (Calificacion c : registroNotas) {
                            Alumno a = Alumno.buscarAlumno(
                                    listaAlumnos, c.getCodigoAlumno());

                            if (a != null) {
                                System.out.println("Alumno: " + a.getNombre());
                                System.out.println("Codigo: " + c.getCodigoAlumno());
                                System.out.println(c.mostrarNotas());

                                if (!c.getNotasEstudiante().isEmpty()) {
                                    System.out.printf(
                                            "Promedio: %.2f%n",
                                            c.calcularPromedio());
                                }

                                System.out.println("------------------------------");
                            }
                        }
                    }
                }

                case 6 -> {
                    // Eliminar un alumno y sus calificaciones
                    System.out.println("Ingrese el codigo del alumno a eliminar:");
                    String codigoAlumno = sc.nextLine().trim();

                    Alumno alumnoEncontrado = Alumno.buscarAlumno(
                            listaAlumnos, codigoAlumno);

                    if (alumnoEncontrado != null) {

                        Calificacion notasEncontradas =
                                Calificacion.buscarCalificacion(
                                        registroNotas, codigoAlumno);

                        listaAlumnos.remove(alumnoEncontrado);

                        if (notasEncontradas != null) {
                            registroNotas.remove(notasEncontradas);
                        }

                        System.out.println(
                                "Alumno y calificaciones eliminados correctamente.");

                    } else {
                        System.out.println("No se encontro al alumno.");
                    }
                }

                case 7 -> {
                    // Mostrar alumnos aprobados
                    Calificacion.listarAprobados(
                            registroNotas, listaAlumnos);
                }

                case 8 -> {
                    // Mostrar las notas mas altas y mas bajas
                    Calificacion.obtenerNotasExtremas(
                            registroNotas, listaAlumnos);
                }

                case 9 -> {
                    // Salir del sistema
                    System.out.println("Gracias por utilizar el sistema.");
                    condicion = false;
                }

                case 10 -> {
                    // APORTE INDIVIDUAL
                    // Reporte estadistico de calificaciones
                    Calificacion.mostrarReporteEstadistico(
                            registroNotas, listaAlumnos);
                }

                default -> {
                    System.out.println(
                            "Opcion no valida. Seleccione una opcion del 1 al 10.");
                }
            }

        } while (condicion);

        sc.close();
    }
}
