package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Integer[] enteros = {1,4,7,2,1,9};
        Conjunto<Integer> conjuntoEnteros = new Conjunto<Integer>(enteros);

        Persona p1 = new Persona("Oscar", "Sandoval");
        Persona p2 = new Persona("Eduardo", "Huerta");
        Persona p3 = new Persona("Daniel", "Leyva");
        Persona p4 = new Persona("Rafael", "Zavala");
        Persona p5 = new Persona("Victor", "Batiz");
        Persona p6 = new Persona("Saul", "Palazuelos");
        Persona p7 = new Persona("Rafael", "Imperial");
        Persona p8 = new Persona("Manuel", "Medrano");
        Persona p9 = new Persona("Misael", "Burruel");
        Persona p10 = new Persona("Marcos", "Plata");
        Persona p11 = new Persona("Glen", "Della Roca");

        Persona[] grupo1 = {p1, p2, p3, p4, p5, p7, p8};
        Persona[] grupo2 = {p4, p5, p6, p9, p10, p11};

        Conjunto<Persona> peopleSet = new Conjunto<Persona>(grupo1);
        Conjunto<Persona> genteSet = new Conjunto<Persona>(grupo2);

        Conjunto<Persona> unionPeople = peopleSet.union(genteSet);
        Conjunto<Persona> interseccionPeople = peopleSet.interseccion(genteSet);
        Conjunto<Persona> diferenciaPeople = peopleSet.diferencia(genteSet);


        Integer[] elementosC1 = {1,2,3};
        Integer[] elementosC2 = {5,7,9};
        Integer[] elementosC3 = {1};

        Conjunto<Integer> c1 = new Conjunto<>(elementosC1);
        Conjunto<Integer> c2 = new Conjunto<>(elementosC2);
        Conjunto<Integer> c3 = new Conjunto<>(elementosC3);

        ArrayList<Conjunto> elementosC4 = new ArrayList<>();
        elementosC4.add(c1);
        elementosC4.add(c2);
        elementosC4.add(c3);
        Conjunto<Conjunto> c4 = new Conjunto<Conjunto>(elementosC4);

        System.out.println(c4);

        boolean pertenenciac3DeC4 = c4.contains(c3);
        System.out.println("¿Contiene el conjunto 4 al conjunto 3? "+pertenenciac3DeC4);

        //c1 = c1.diferencia(c3);
        System.out.println("Los elementos de la diferencia del conjunto 1 y el conjunto 3: "+c1);
//        System.out.println(c1);
        System.out.println(c4);
        System.out.println(c1.productC(c4));

        System.out.println(c2.pow());


        Alumno Oscar = new Alumno("Oscar", "Sandoval", 123456);
        Alumno Marcos = new Alumno("Marcos", "Plata", 136924);
        Alumno Daniel = new Alumno("Daniel", "Leyva", 123478);
        Alumno Eduardo = new Alumno("Eduardo", "Huerta", 142546);

        Maestro Dr_Ramon = new Maestro("Dr-Ramon", "Zatarain", 12345678);
        Maestro Dra_Lucia = new Maestro("Dra-Lucia", "Barrón", 16723458);
        Maestro Dr_Ricardo = new Maestro("Dr-Ricardo", "Quintero", 14523678);
        Maestro Dr_Hector = new Maestro("Dr-Hector", "Rangel", 18765432);

        Conjunto<Alumno> alumnos = new Conjunto<>();
        Conjunto<Maestro> maestros = new Conjunto<>();

        alumnos.add(Oscar);
        alumnos.add(Marcos);
        alumnos.add(Daniel);
        alumnos.add(Eduardo);

        maestros.add(Dr_Ramon);
        maestros.add(Dra_Lucia);
        maestros.add(Dr_Ricardo);
        maestros.add(Dr_Hector);

        Conjunto<Object> uniondatosPeople = peopleSet.union(conjuntoEnteros);
        System.out.println("Union tipo de personas con integers" + uniondatosPeople);

        Conjunto<Persona> personas1 = alumnos.union(maestros);

        System.out.println("Union de alumnos con maestros"+ personas1);
    }
}