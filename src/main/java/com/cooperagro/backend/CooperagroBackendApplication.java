package com.cooperagro.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication(
        scanBasePackages = {
                "com.cooperagro.backend.*",
                "br.ueg.prog.webi.api.*", "br.ueg.prog.webi.*"})
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class},
        basePackages = {
                "com.cooperagro.backend.*",
                "br.ueg.prog.webi.api.*"})
public class CooperagroBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooperagroBackendApplication.class, args);
    }

}
