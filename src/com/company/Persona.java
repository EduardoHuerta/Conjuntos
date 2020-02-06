package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private List<Persona> grupo;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupo = new ArrayList<Persona>();
    }

   /* public Persona(List<Persona> grupo) {
        this.grupo = grupo;
    }*/

    /*public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public List<Persona> getGrupo() { return grupo; }

    public void setGrupo(List<Persona> grupo) { this.grupo = grupo; }

    public void addGrupo(Persona person) { this.grupo.add(person); }
*/
    @Override
    public String toString() { return this.nombre; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) &&
                Objects.equals(apellido, persona.apellido) &&
                Objects.equals(grupo, persona.grupo);
    }
}
