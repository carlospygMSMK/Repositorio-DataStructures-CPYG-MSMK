package edu.msmk.clases;

import edu.msmk.clases.service.TramoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

@SpringBootApplication
@Slf4j
public class ClasesApplication implements CommandLineRunner {

    private final TramoService tramoService;

    public ClasesApplication(TramoService tramoService) {
        this.tramoService = tramoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClasesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            ServicioValidarDireccion CoverturaServicio1 = tramoService.leerTramos();
            String puebloRecibido = "MADRID";
            Timestamp inicio = new Timestamp(System.currentTimeMillis());
            log.info("Damos serivcio a {}?: {}", puebloRecibido, CoverturaServicio1.damosServicio(puebloRecibido));
            Timestamp acabo = new Timestamp(System.currentTimeMillis());
            log.info("Tiempo de ejecución: {}", acabo.getTime() - inicio.getTime());
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
