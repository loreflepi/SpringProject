package com.transunion.test.loreTest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosRepository extends JpaRepository<Datos,Long>{

	List<Datos> findAll();
	
	List<Datos> findByAsunto(String asunto);
}
