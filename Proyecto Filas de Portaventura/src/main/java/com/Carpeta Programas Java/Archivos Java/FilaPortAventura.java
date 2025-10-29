package com.prueba.demo;

import java.util.ArrayList;

public class FilaPortAventura {
    //Ahora creamos 2 ADT a partir de nuestras colas creadas con aterioridad
    private myQueue genteVIP;
    private myQueue genteStandard;
    private int numeroDePersonas;

    public FilaPortAventura(int tamañoAtraccion){
        this.genteVIP = new myQueue(0);
        this.genteStandard = new myQueue(0);
        this.numeroDePersonas = tamañoAtraccion;
    }

    public void vieneGente(Boolean esVip, String nombreDelVisitante){
        if (!esVip){
            genteStandard.insertar_nombres(nombreDelVisitante);
        }else {
            genteVIP.insertar_nombres(nombreDelVisitante);
        }
    }

    public int getTamañoVip(){

        return genteVIP.tamaño();
    }
    public int getTamañoStandard(){

        return genteStandard.tamaño();
    }

    public ArrayList<String> llenarAtraccion(){
        ArrayList<String> genteASubir = new ArrayList<>();
        if (genteVIP.tamaño() >= tamañoAtraccion())
        {
            for (int i = 0; i < TamañoAtraccion; i++){
                genteASubir.add(genteVIP.extraer());
            }
        }
        return genteASubir;
    }
}
