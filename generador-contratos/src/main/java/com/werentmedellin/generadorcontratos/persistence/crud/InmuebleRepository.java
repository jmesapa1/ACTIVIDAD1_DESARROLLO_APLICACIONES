package com.werentmedellin.generadorcontratos.persistence.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;

@Repository
public interface InmuebleRepository extends CrudRepository<Inmueble, Long>  {
    public List<Inmueble> findByMunicipio(String valor);
}
