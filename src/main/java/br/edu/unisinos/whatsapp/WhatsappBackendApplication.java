package br.edu.unisinos.whatsapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
public class WhatsappBackendApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        showAppVersionInfo();
        SpringApplication.run(WhatsappBackendApplication.class, args);
    }

    private static void showAppVersionInfo() {
        Logger logger = LoggerFactory.getLogger(WhatsappBackendApplication.class);
        logger.info("");
        logger.info("########################################################################################");
        logger.info("## |  java.version  |   " + System.getProperty("java.version"));
        logger.info("## |  java.home     |   " + System.getProperty("java.home"));
        logger.info("## |  java.vendor   |   " + System.getProperty("java.vendor"));
        logger.info("## |  os.arch       |   " + System.getProperty("os.arch"));
        logger.info("## |  os.name       |   " + System.getProperty("os.name"));
        logger.info("## |  os.version    |   " + System.getProperty("os.version"));
        logger.info("## |  spring-boot   |   " + SpringBootApplication.class.getPackage().getImplementationVersion());
        logger.info("########################################################################################");
        logger.info("");
    }

}
