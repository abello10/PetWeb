package com.petweb.petweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.petweb.petweb.model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository  <Carrito, Integer> {

}
