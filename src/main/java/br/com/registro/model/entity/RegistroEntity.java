package br.com.registro.model.entity;

import br.com.registro.model.dto.RegistroRequest;
import br.com.registro.model.dto.RegistroResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String phone;

    public static RegistroEntity converteRequestParaEntity(RegistroRequest registroRequest){
        return RegistroEntity.builder()
                .nome(registroRequest.getNome())
                .email(registroRequest.getEmail())
                .phone(registroRequest.getPhone())
                .build();
    }

    public static RegistroResponse converteEntityParaResponse(RegistroEntity registroEntity){
        return RegistroResponse.builder()
                .id(registroEntity.getId())
                .nome(registroEntity.getNome())
                .email(registroEntity.getEmail())
                .phone(registroEntity.getPhone())
                .build();
    }

}
