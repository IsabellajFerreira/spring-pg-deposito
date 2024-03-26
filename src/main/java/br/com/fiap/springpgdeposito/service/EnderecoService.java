package br.com.fiap.springpgdeposito.service;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.dto.request.EnderecoRequest;
import br.com.fiap.springpgdeposito.dto.response.EnderecoResponse;
import br.com.fiap.springpgdeposito.entity.Endereco;
import br.com.fiap.springpgdeposito.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService implements ServiceDTO<Endereco, EnderecoRequest, EnderecoResponse, AbstractDTO> {

    @Autowired
    EnderecoRepository repo;


    @Override
    public Endereco toEntity(EnderecoRequest enderecoRequest) {
        return Endereco.builder()
                .cep(enderecoRequest.cep())
                .numero(enderecoRequest.numero())
                .complemento(enderecoRequest.complemento())
                .build();
    }

    @Override
    public EnderecoResponse toResponse(Endereco endereco) {
        if(endereco == null) return null;
        return new EnderecoResponse(endereco.getId(), endereco.getCep(), endereco.getNumero(), endereco.getComplemento());
    }

    @Override
    public Endereco findDatabaseObjet(AbstractDTO abstractDTO) {
        return repo.findById(abstractDTO.id()).orElse(null);
    }

    @Override
    public Endereco save(EnderecoRequest endereco) {
        return repo.save(toEntity(endereco));
    }

    @Override
    public List<Endereco> findAll() {
        return repo.findAll();
    }

    @Override
    public Endereco findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
