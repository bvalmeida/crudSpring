package br.com.registro.model.repository;

import br.com.registro.model.entity.RegistroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroEntity, Long> {
}
