package com.werentmedellin.generadorcontratos.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;

@Repository
public interface PropietarioRepository extends CrudRepository<Propietario, Long>  {

}
