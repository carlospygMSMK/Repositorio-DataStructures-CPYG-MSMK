package edu.msmk.clases;

import java.util.HashSet;

public class ServicioValidarDireccion {
    private HashSet<String> pueblos;

    public ServicioValidarDireccion(){
        this.pueblos = new HashSet<>();
    }
    public void add_pueblo (String pueblo){
        this.pueblos.add(pueblo);
    }
    public int numero_pueblos_cubiertos(){
        return this.pueblos.size();
    }
    public boolean damosServicio(String pueblo){
        return pueblos.contains(pueblo);
    }
}
