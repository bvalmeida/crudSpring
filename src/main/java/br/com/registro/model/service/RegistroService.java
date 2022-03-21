package br.com.registro.model.service;

import br.com.registro.model.dto.RegistroRequest;
import br.com.registro.model.dto.RegistroResponse;
import br.com.registro.model.entity.RegistroEntity;

import java.util.List;
import java.util.Optional;

public interface RegistroService {

    void adicionarRegistro(RegistroRequest registroRequest);

    List<RegistroResponse> findAll();

    void deletarRegistro(Long id);

    void atualizarRegistro(Long id, RegistroRequest registroRequest);

}
