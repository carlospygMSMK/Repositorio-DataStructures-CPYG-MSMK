package com.prueba.demo;

import java.util.ArrayList;

public class myQueue {

    private int contador;
    private ArrayList<Integer> numeros;
    private ArrayList<String> nombres;
    //Ahora los lenguajes actuales permiten que los arrays sean de tamaños definidos, por ello el List

    //Todas las acciones son públicas
    //Si usamos void, no devuelve nada, podemos usarlo (más limpio) pues tendriamos que usar get cada vez
    //Usamos el this.contador para referenciar al constuctor (Es habitual) porque muchas veces escribir el propio contador
    //Pero podríamos escribir this entodo el codigo para referenciar al constructor
    //Creamos funciones a partir de los constructores

    public myQueue(int valor_inicial) {
        this.contador = valor_inicial;
        this.numeros = new ArrayList<>();
        this.nombres = new ArrayList<>();
    }

    //ADT FILA QUEUE
    public int incrementar(int aumento){
        contador = contador + aumento;
        return contador;
    }
    public int decrementar(int bajar){
        contador = contador - bajar;
        return contador;
    }
    public int getContador(){
        return contador;
    }

    //ADT ARRAY FILA NUMEROS
    public void insertar(int numero){

        numeros.add(numero);
    }
    public int extraer(){
        int numero = numeros.get(0);
        numeros.remove(0);
        return numero;
    }
    public int leer(){
        return numeros.get(0);
    }
    public int tamaño(){
        return numeros.size();
    }

    //nombres
    public void insertar_nombres(String nombre_visitante){
        nombres.add(nombre_visitante);
    }
    public String leer_nombres(){
        String leer = nombres.get(0);
        return leer;
    }

}
