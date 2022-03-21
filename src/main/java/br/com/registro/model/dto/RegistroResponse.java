package br.com.registro.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistroResponse {

    private Long id;

    private String nome;

    private String email;

    private String phone;
}
