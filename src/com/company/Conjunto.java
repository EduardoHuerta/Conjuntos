package com.company;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.*;


public class Conjunto<E> implements Serializable{

    //Estructura de datos para almacenar los elementos del conjunto.
    private HashSet<E> conjunto;

    //Constructor que genera el conjunto vacio.
    public Conjunto() {
        conjunto = new HashSet<E>();
    }

    //Constructor que recibe un arreglo primitivo de elementos tipo E
    public Conjunto(E[] elementos) {
        conjunto = new HashSet<E>();
        conjunto.addAll(Arrays.asList(elementos)); //El método asList () de la clase java.util.Arrays
        // se usa para
        // devolver una lista de tamaño fijo respaldada
        // por la matriz especificada.
    }

    //Constructor que recibe una coleccion de elementos de tipo E
    public Conjunto(Collection<E> colleccion) {
        conjunto = new HashSet<E>();
        conjunto.addAll(colleccion);
    }

    /*
     * 1.-Representacion String del conjunto toString
     * */
    @Override
    public String toString() {
        StringBuilder cadenaCaracteres = new StringBuilder();
        cadenaCaracteres.append("{");
        int contadorDeElementos = 0;
        for (E elemento : conjunto) {
            cadenaCaracteres.append(elemento);
            if (contadorDeElementos != conjunto.size()-1) {
                cadenaCaracteres.append(" ,");
            }
            contadorDeElementos++;
        }
        cadenaCaracteres.append("}");
        return cadenaCaracteres.toString();
    }

    /*
     * 2.-Tamaño del conjunto (size)
     */
    public int size() {
        return this.conjunto.size(); //Me devuelve la cantidad de elementos del conjunto
    }

    /*
     * 3.-Conjunto vacío es un conjunto sin elementos (empty)
     */
    public boolean empty() {
        return this.conjunto.isEmpty();
    }

    /*
     * 4.-Pertenencia (de un elemento en un conjunto) (contains)
     */
    public boolean contains(E elemento) {

        return this.conjunto.contains(elemento);
    }

    /*
     * 5.-Unión de conjuntos (union)
     */
    public  Conjunto union(Conjunto conjuntoB) {
        Conjunto conjuntoAUnir = new Conjunto(this.conjunto);
        conjuntoAUnir.conjunto.addAll(conjuntoB.conjunto);
        return conjuntoAUnir;
    }

    /*
     *6.-Intersección de conjuntos (intersection)
     */
    public Conjunto interseccion(Conjunto conjuntoB) {

        Conjunto conjuntoAIntersectar = new Conjunto(this.conjunto);
        conjuntoAIntersectar.conjunto.retainAll(conjuntoB.conjunto);
        return conjuntoAIntersectar;
    }

    /*
     *7.-Diferencia de conjuntos (difference)
     */
    public Conjunto diferencia(Conjunto conjuntoB) {
        Conjunto conjuntoAdiferenciar = new Conjunto(this.conjunto);
        conjuntoAdiferenciar.conjunto.removeAll(conjuntoB.conjunto);
        return conjuntoAdiferenciar;
    }

    /*
     *8.-subconjuntos (subSet)
     *conjunto A es un subconjunto del conjunto B si todo elemento de A es también elemento de B.
     */
    public boolean subConjunto(Conjunto<E> conjuntoB) {
        return this.conjunto.containsAll(conjuntoB.conjunto);
    }
    /*
     * Regresa si el conjunto B recibido como parametro es subconjunto propio de este conjunto.
     * Un conjunto A es un subconjunto propio del conjunto B si el elemento de A es tambien elemento de B
     * y ademas existe un elemento de B que no es elemento de A.
     * 9.-subconjunto Propio (subSetP)
     */
    public boolean subConjuntoPropio(Conjunto<E> conjuntoB) {
        return this.conjunto.contains(conjuntoB) && !this.conjunto.containsAll(conjuntoB.conjunto);
    }

    /*
     * Regresa el complemento de este conjunto
     * con el conjunto Universo recibido como parametro.
     * Sea A un subconjunto de un conjunto universal U.
     * El complemento de A son todos aquellos elementos de U que
     * no estan en A.
     * 10.- Complemento de conjuntos (complement) (considera un universo)
     */
    public <T> Conjunto<E> complemento(Conjunto<T> universo) {
        HashSet otroConjunto = new HashSet<>(universo.conjunto);
        otroConjunto.removeAll(this.conjunto);
        return new Conjunto<E>(otroConjunto);
    }
    /*
    Sean A y B dos conjuntos (posiblemente iguales pero no vacíos).
    El producto cartesiano de A con B es el conjunto de todas las parejas ordenadas ( a, b )
     *11.- Producto Cartesiano (productC)
     */
    public <T>  Conjunto<Par<E,T>> productC(Conjunto<T> conjunto2){
        Conjunto<Par<E, T>> productoCartesiano = new Conjunto<Par<E, T>>();

        Set<E> conjuntoA = this.conjunto;
        Set<T> conjuntoB = conjunto2.conjunto;

        E elementosDelConjuntoA;
        T elementosDelConjuntoB;

        for (Iterator<E> iteracionA = conjuntoA.iterator(); iteracionA.hasNext();){
            elementosDelConjuntoA = iteracionA.next();
            for (Iterator<T> iteracionB = conjuntoB.iterator();iteracionB.hasNext();){
                elementosDelConjuntoB = iteracionB.next();
                Par<E, T> par = new Par<E, T>(elementosDelConjuntoA, elementosDelConjuntoB);
                productoCartesiano.conjunto.add(par);
            }
        }
        return productoCartesiano;
    }
    /*
     *12.- Potencia de un conjunto (pow)
     * Regresa el conjunto potencia de este conjunto.
     * El conjunto potencia de un conjunto A es el conjunto que contiene todos los
     * posibles subconjuntos de A.
     */
    public Conjunto<Conjunto<E>> pow(){ //https://www.geeksforgeeks.org/power-set/
        Conjunto<Conjunto<E>> conjuntoPotencia = new Conjunto<Conjunto<E>>();

        int numeroElementosDelConjunto = this.conjunto.size();

        //set_size of power set of a set with set_size n is (2^n -1)
        int tamañoConjuntoPotencia = (int) Math.pow(2,numeroElementosDelConjunto);
        for (int contador = 0; contador < tamañoConjuntoPotencia; contador++) {
            String contadorBinario = Integer.toBinaryString(contador);
            //Run from counter 000..0 to 111..1
            while (contadorBinario.length() < numeroElementosDelConjunto) {
                contadorBinario = "0" + contadorBinario;
            }
            Conjunto<E> auxiliar = new Conjunto<E>();
            E valor;
            for (int j = 0; j < numeroElementosDelConjunto; j++) {
                valor = (E) this.conjunto.toArray()[j];
                if (contadorBinario.charAt(j) == '1') {
                    auxiliar.conjunto.add(valor);
                }
            }
            conjuntoPotencia.conjunto.add(auxiliar);
        }
        return conjuntoPotencia;
    }

    /*
     *13.- Igualdad de conjuntos (equals)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Conjunto)) {
            return false;
        }
        Conjunto<E> conjunto1 = (Conjunto<E>) o;
        return Objects.equals(conjunto, conjunto1.conjunto);
    }

    /*
    14.- Clonación de un conjunto (clone) (considera clonación profunda)
    */
    @Override
    protected Object clone(){//https://commons.apache.org/proper/commons-lang/download_lang.cgi
        //Apache Commons Lang 3.9 (Java 8+)
        //Binaries
        // commons-lang3-3.9-bin.tar.gz
        //Esta libreria de apache es para importar el SerializationUtils que me permite
        // la clonacion profunda de un conjunto.
        Conjunto<E> clone = (Conjunto<E>) SerializationUtils.clone(this);
        return clone;
    }

    //Agrega un elemento E a la coleccion
    public void add(E element) {

        this.conjunto.add(element);
    }
}