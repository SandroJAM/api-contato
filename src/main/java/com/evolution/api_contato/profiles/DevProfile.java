package com.evolution.api_contato.profiles;

import com.evolution.api_contato.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfile {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB(){
        this.dbService.instanciaDB();
    }

}
