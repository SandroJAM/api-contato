package com.evolution.api_contato.controler;

import com.evolution.api_contato.DTO.ContatoDTO;
import com.evolution.api_contato.model.Contato;
import com.evolution.api_contato.service.ContatoService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("contato")
@CrossOrigin("*")
public class ContatoControler {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> findById(@PathVariable Integer id) {
        Contato con = contatoService.findById(id);
        ContatoDTO conDto = modelMapper.map(con, ContatoDTO.class);
        return ResponseEntity.ok().body(conDto);
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> findAll() {
        List<Contato> list = contatoService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, ContatoDTO.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ContatoDTO> save(@Valid @RequestBody ContatoDTO contatoDTO) {
        Contato cat = contatoService.save(contatoDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, ContatoDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> update(@PathVariable Integer id, @Valid @RequestBody ContatoDTO contatoDTO) {
        contatoDTO.setId(id);
        Contato con = contatoService.update(contatoDTO);
        ContatoDTO conDto = modelMapper.map(con, ContatoDTO.class);
        return ResponseEntity.ok().body(conDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

