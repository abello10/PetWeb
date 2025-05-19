package com.petweb.petweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petweb.petweb.model.Existencias;

@Repository
public interface ExistenciasRepository extends JpaRepository <Existencias, Integer>{

}
