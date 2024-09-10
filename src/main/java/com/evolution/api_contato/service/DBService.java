package com.evolution.api_contato.service;

import com.evolution.api_contato.model.Contato;
import com.evolution.api_contato.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ContatoRepository contatoRepository;

    public void instanciaDB() {

        Contato con1 = new Contato(null, "Sandro Muniz", "sandro.mnz@gmail.com", "81-9-8787-2222");
        Contato con2 = new Contato(null, "Barbara Vasconcelos", "barbaravasconcelos@hotmail.com", "81-9-8888-0000");
        Contato con3 = new Contato(null, "Enzo Barbosa", "enzoBarbosa@uol.com", "81-9-9999-7777");

        this.contatoRepository.saveAll(Arrays.asList(con1, con2, con3));

    }

}
