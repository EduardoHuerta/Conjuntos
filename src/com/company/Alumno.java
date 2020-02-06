package com.company;

public class Alumno extends Persona {
    private String NumeroDeControl;
    public Alumno(String nombre, String apellido, int numeroDeControl){
        super(nombre, apellido);
        NumeroDeControl = "A" + numeroDeControl;
    }
}
