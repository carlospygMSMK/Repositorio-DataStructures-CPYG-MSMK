package com.prueba.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);}

    @Override
    public void run(String... arg){
        log.info("Voy a crear mi contador");
        myQueue queue = new myQueue(1); //New nos crea un nuevo objeto para usarlo con . sus funciones public
        log.info("El valor inicial es {}", queue.getContador());
        log.info("...-----------------------------------------------...");
        log.info("el valor es {}",queue.incrementar(4));
        log.info("...-----------------------------------------------...");
        log.info("Ahora el valor es {}",queue.decrementar(2 ));
        log.info("...-----------------------------------------------...");

        //ARRAY
        queue.insertar(10); //INSERTAMOS 10
        log.info("...--------------------ARRAY--------------------------...");
        log.info("Ahora vemos el tamaño {}",queue.tamaño()); //Vemos Tamaño -> 1
        log.info("...-----------------------------------------------...");
        log.info("Ahora leemos {}",queue.leer());           //Cual es el siguiente, pero no hay
        log.info("...-----------------------------------------------...");
        log.info("Ahora extraemos {}",queue.extraer());     //Extraemos el 10
        log.info("...-----------------------------------------------...");
        log.info("Ahora vemos el tamaño {}",queue.tamaño()); //Vemos Tamaño -> 0
        log.info("...-----------------------------------------------...");
        //log.info("Ahora leemos {}",queue.leer());           //Cual es el siguiente, pero no hay

        log.info("...-----------------------------------------------...");
        queue.insertar_nombres("Carlos");
        queue.insertar_nombres("Pedro");
        log.info("...-----------------------------------------------...");
        log.info("Ahora leemos los nombres {}",queue.leer_nombres());
    }

}
