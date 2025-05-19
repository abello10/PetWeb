package com.petweb.petweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.petweb.petweb.model.Boleta;


@Repository
public interface BoletaRepository extends JpaRepository <Boleta, Integer>{
    

// buscar por estado o cliente

List<Boleta>findByEstadoId(Integer id);
List<Boleta>findByClienteId(Integer id);
}

