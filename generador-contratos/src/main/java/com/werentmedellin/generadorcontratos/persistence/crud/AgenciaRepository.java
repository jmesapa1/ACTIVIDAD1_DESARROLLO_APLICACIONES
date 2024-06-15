package com.werentmedellin.generadorcontratos.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.werentmedellin.generadorcontratos.persistence.entity.Agencia;

@Repository
public interface AgenciaRepository extends CrudRepository<Agencia, Long> {
    public List<Agencia> findByNombre(String valor);
}
