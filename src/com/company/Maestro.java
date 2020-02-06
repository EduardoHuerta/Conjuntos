package com.company;

public class Maestro extends Persona {
    private String NumCedulaProfesional;

    public Maestro(String nombre, String apellido, int numCedulaProfesional) {
        super(nombre, apellido);
        NumCedulaProfesional = "M" + numCedulaProfesional;
    }
}
