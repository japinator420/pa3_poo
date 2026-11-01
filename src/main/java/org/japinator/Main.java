package org.japinator;
import java.util.*;

// Sistema de registro y control de calificaciones de alumnos de una institucion educativa

public class Main {
    public static void main(String[] args) {
        // Creamos nuestros registros generales
        SortedSet<Alumno> listaAlumnos = new TreeSet<>();
        ArrayList<Calificacion> registroNotas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        boolean condicion = true; // Condicion para el bucle

        listaAlumnos.add(new Alumno("A002", "Miriam Flores"));
        listaAlumnos.add(new Alumno("A001", "Juan Perez"));

        Calificacion notasAlumno1 = new Calificacion("A001");
        notasAlumno1.añadirNota(12.3);
        notasAlumno1.añadirNota(13.7);
        notasAlumno1.añadirNota(19.2);

        Calificacion notasAlumno2 = new Calificacion("A002");
        notasAlumno2.añadirNota(13.4);
        notasAlumno2.añadirNota(11.2);
        notasAlumno2.añadirNota(20.0);

        registroNotas.add(notasAlumno1);
        registroNotas.add(notasAlumno2);

        // Creamos el bucle principal de funcionamiento
        do{
            System.out.println("""
                BIENVENIDO AL MENU PRINCIPAL
                ---------------------------------------
                1) REGISTRAR ALUMNO
                2) VER LISTA DE ALUMNOS
                3) REGISTRAR NOTAS
                4) MODIFICAR NOTAS
                5) VER LISTA DE NOTAS
                6) ELIMINAR UN ALUMNO
                7) SALIR
                """);
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> { // Registramos alumnos
                    System.out.println("Ingrese el codigo del alumno nuevo (Revise la lista de alumnos para evitar errores.)");
                    String codigoAlumnoNuevo = sc.nextLine();

                    System.out.println("Ingrese el nombre completo del alumno nuevo");
                    String nombreAlumnoNuevo = sc.nextLine();

                    Alumno nuevoAlumno = new Alumno(codigoAlumnoNuevo, nombreAlumnoNuevo);
                    listaAlumnos.add(nuevoAlumno);
                    break;
                }
                case 2 -> { // Mostramos lista de alumnos
                    System.out.print("""
                                LISTA DE ALUMNOS
                                ------------------------
                                """);
                    for(Alumno a : listaAlumnos){
                        System.out.println(a);
                    }
                    System.out.println("------------------------");
                    break;
                }
                case 3 -> { // Controlamos notas
                    System.out.println("Ingrese el codigo del Alumno (Revise la lista de alumnos para evitar errores)");
                    String codigoAlumnoSeleccionado = sc.nextLine();
                    boolean condicionInterna = true;

                    Calificacion alumnoEncontrado = null; // Esta variable almacenara nuestro registro de notas por alumno nuevo o existente

                    // Verificamos si ya existe un registro de notas para ese alumno
                    for(Calificacion c : registroNotas) {
                        if(c.getCodigoAlumno().equals(codigoAlumnoSeleccionado)){
                            alumnoEncontrado = c;
                            break;
                        }
                    }

                    if(alumnoEncontrado == null) {
                        alumnoEncontrado = new Calificacion(codigoAlumnoSeleccionado);
                        registroNotas.add(alumnoEncontrado);
                    }

                    // Procedemos a registrar notas
                    char decisionUsuario;
                    do{
                        System.out.print("Ingrese la nueva nota: ");
                        double notaPorIngresar = sc.nextDouble();
                        sc.nextLine();

                        alumnoEncontrado.añadirNota(notaPorIngresar);

                        //Consultamos si desea permanecer
                        System.out.println("Desea ingresar otra nota? (S/N)");
                        decisionUsuario = sc.next().charAt(0);

                        if(decisionUsuario == 'N' || decisionUsuario == 'n'){
                            condicionInterna = false;
                        }

                    }while(condicionInterna);

                    break;
                }
                case 4 -> { // Modificamos una nota existente
                    System.out.println("Ingrese el codigo del alumno:");
                    String codigoAlumno = sc.nextLine();

                    // Buscamos las calificaciones del alumno
                    Calificacion notasEncontradas = Calificacion.buscarCalificacion(
                        registroNotas, codigoAlumno
                    );

                    if (notasEncontradas == null) {
                        System.out.println("El alumno no tiene notas registradas.");
                        break;
                    }

                    // Mostramos las notas actuales
                    System.out.println(notasEncontradas.mostrarNotas());

                    System.out.println("Ingrese el número de la nota a modificar:");
                    int numeroNota = sc.nextInt();

                    System.out.println("Ingrese la nueva nota:");
                    double nuevaNota = sc.nextDouble();
                    sc.nextLine();

                    // Modificamos la nota seleccionada
                    boolean modificada = notasEncontradas.modificarNota(numeroNota - 1, nuevaNota);

                    if (modificada) {
                        System.out.println("Nota modificada correctamente");
                    } else {
                        System.out.println("No se encontró la nota seleccionada");
                    }

                    break;
                }
                case 5 -> {
                    for (Calificacion c : registroNotas){
                        System.out.println(c.mostrarNotas());
                    }
                    break;
                }
                case 6 -> { // Eliminamos un alumno de la lista
                    System.out.println("Ingrese el codigo del alumno a eliminar:");
                    String codigoAlumno = sc.nextLine();

                    // buscamos al alumno
                    Alumno alumnoEncontrado = Alumno.buscarAlumno(listaAlumnos, codigoAlumno);

                    if (alumnoEncontrado != null) {
                        // buscamos las calificaciones
                        Calificacion notasEncontradas = Calificacion.buscarCalificacion(
                            registroNotas, codigoAlumno
                        );

                        // procedemos a eliminar al alumno y calificaciones
                        listaAlumnos.remove(alumnoEncontrado);

                        if (notasEncontradas != null) {
                            registroNotas.remove(notasEncontradas);
                        }

                        System.out.println("Alumno y calificaciones eliminados correctamente.");
                    } else {
                        System.out.println("No se encontró al alumno.");
                    }

                    break;
                }
                case 7 -> { // Salimos del sistema
                    condicion = false;
                    break;
                }
            }
        }while(condicion);
    }
}