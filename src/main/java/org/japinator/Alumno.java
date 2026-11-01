package org.japinator;
import java.util.Objects;
import java.util.SortedSet;

public class Alumno implements Comparable<Alumno> {
    private String codigo;
    private String nombre;

    public Alumno(String codigo, String nombre){
        this.codigo =  codigo;
        this.nombre = nombre;
    }

    // Aqui creamos los getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }

    public String getAlumno(SortedSet<Alumno> listaAlumnos) {
        String nombreAlumnoSeleccionado = "Juan";
        return nombreAlumnoSeleccionado;
    }

    @Override
    public int compareTo(Alumno otroAlumno){
        return this.codigo.compareTo(otroAlumno.codigo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " - Nombre: " + nombre;
    }

    // Buscar un alumno por su código
    public static Alumno buscarAlumno(SortedSet<Alumno> listaAlumnos, String codigo) {
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getCodigo().equals(codigo)) {
                return alumno;
            }
        }
        return null;
    }
}
