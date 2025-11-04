package edu.msmk.clases.service;

import edu.msmk.clases.ServicioValidarDireccion;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class TramoService {

    public ServicioValidarDireccion leerTramos() throws IOException {

        ServicioValidarDireccion micobertura = new ServicioValidarDireccion();

        ClassPathResource resource = new ClassPathResource("TRAM.D250101.A250630");
        
        if (!resource.exists()) {
            throw new IOException("El archivo TRAM.D250101.A250630 no existe en los recursos");
        }
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.ISO_8859_1))) {
            
            String linea;
            int numeroLinea = 1;
            boolean isEmpty = true;
            
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    isEmpty = false;
                    if (linea.length() >= 91) {
                        // Extraer del carácter 111 al 136 (0-indexed sería 10 a 135)
                        String subcadena = linea.substring(46, 90).trim();
                        micobertura.add_pueblo(subcadena);
                        System.out.println("Línea " + numeroLinea + ": " + subcadena);
                    } else {
                        System.out.println("Línea " + numeroLinea + " es demasiado corta (longitud: " + linea.length() + ")");
                    }
                }
                numeroLinea++;
            }
            
            if (isEmpty) {
                throw new IOException("El archivo está vacío");
            }

            return micobertura;
        }
    }
}
