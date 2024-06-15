package com.werentmedellin.generadorcontratos.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Long> {
    public List<Contrato> findByCanon(Long valor);
}
