package org.japinator;
import java.util.ArrayList;

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


}
