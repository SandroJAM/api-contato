package com.evolution.api_contato.service;

import com.evolution.api_contato.DTO.ContatoDTO;
import com.evolution.api_contato.exceptions.ObjectNotFoundException;
import com.evolution.api_contato.model.Contato;
import com.evolution.api_contato.repository.ContatoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Contato findById(Integer id) {
        Optional<Contato> con = contatoRepository.findById(id);
        if (con.isPresent()){
            return con.get();
        }
        throw new ObjectNotFoundException("Contato não encontrado!");
    }

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Contato save(ContatoDTO contatoDTO) {
        findByNome(contatoDTO);
        contatoDTO.setId(null);
        return contatoRepository.save(modelMapper.map(contatoDTO, Contato.class));
    }

    public Contato update(ContatoDTO contatoDTO) {
        findById(contatoDTO.getId());
        findByNome(contatoDTO);
        return contatoRepository.save(modelMapper.map(contatoDTO, Contato.class));
    }

    public void delete(Integer id) {
        findById(id);
        Optional<Contato> con = contatoRepository.findById(id);
        contatoRepository.deleteById(id);
    }

    private void findByNome(ContatoDTO contatoDTO){
        Optional<Contato> con = contatoRepository.findByNome(contatoDTO.getNome());
    }

    public void buscarPorNome(String nome) {
        Optional<Contato> con = contatoRepository.findByNomeContainingIgnoreCase(nome);
        if(con.isEmpty()) {
            throw new ObjectNotFoundException("Contato não encontrado!");
        }
    }

}
