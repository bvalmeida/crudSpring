package br.com.registro.model.service;

import br.com.registro.model.dto.RegistroRequest;
import br.com.registro.model.dto.RegistroResponse;
import br.com.registro.model.entity.RegistroEntity;
import br.com.registro.model.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistroServiceImpl implements RegistroService{

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    public void adicionarRegistro(RegistroRequest registroRequest) {
        this.registroRepository.save(RegistroEntity.converteRequestParaEntity(registroRequest));
    }

    @Override
    public List<RegistroResponse> findAll() {
        return this.registroRepository.findAll()
                .stream()
                .map(registroEntity -> RegistroEntity.converteEntityParaResponse(registroEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarRegistro(Long id) {
        this.registroRepository.deleteById(id);
    }

    @Override
    public void atualizarRegistro(Long id, RegistroRequest registroRequest) {
        this.registroRepository.findById(id).map(registroEntity -> {
            registroEntity.setNome(registroRequest.getNome());
            registroEntity.setEmail(registroRequest.getEmail());
            registroEntity.setPhone(registroRequest.getPhone());
            return this.registroRepository.save(registroEntity);
        });
    }
}
