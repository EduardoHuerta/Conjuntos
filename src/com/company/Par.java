package com.company;



import java.io.Serializable;

/*
 *  Clase para realizar el producto Cartesiano
 */
public class Par<E,T> implements Serializable { //Clase para representar pares ordenados de un conjunto

    private E elementosC1;
    private T elementosC2;

    public Par(E elementosC1, T elementosC2) {
        this.elementosC1 = elementosC1;
        this.elementosC2 = elementosC2;
    }
/*

    public E getElementosC1() {
        return elementosC1;
    }

    public void setElementosC1(E elementosC1) {
        this.elementosC1 = elementosC1;
    }

    public T getElementosC2() {
        return elementosC2;
    }

    public void setElementosC2(T elementosC2) {
        this.elementosC2 = elementosC2;
    }
*/

    @Override
    public String toString() {
        return "(" + elementosC1 + "," + elementosC2 + ")";
    }
}

