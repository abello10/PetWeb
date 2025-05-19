package com.petweb.petweb.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.petweb.petweb.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer>{

// Buscar por x cosa
List<Producto>  findByExistenciasId (Integer id);
List<Producto>  findByCategoriasId  (Integer id);

}
