package org.japinator;
import java.util.ArrayList;
import java.util.Collections;

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

    public String mostrarNotas() {
        String formatoNotas  = "";
        int indice = 1;
        for(double nota : notasEstudiante){
            formatoNotas += String.format("Nota %d -> %.2f\n", indice, nota);
            indice++;
        }

        return formatoNotas;
    }

    public double calcularPromedio(){
        if (notasEstudiante.isEmpty()){
            return 0;
        }
        double suma = 0;

        for (double nota:notasEstudiante){
            suma+=nota;
        }
        promedio = suma / notasEstudiante.size();
        return promedio;
    }
    //recuperar nota segun su posicion
    public double obtenerNota(int indice){
        if (indice>= 0 && indice<notasEstudiante.size()){
            return notasEstudiante.get(indice);
        }
        return -1;
    }

    //ordenar las notas de menor a mayor
    public void ordenarNotas(){
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
}
