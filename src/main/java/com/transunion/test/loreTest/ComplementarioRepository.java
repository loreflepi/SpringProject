package com.transunion.test.loreTest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplementarioRepository extends JpaRepository<Complementario,Long> {
	
	List<Complementario> findByDatoId(Integer datosId);
}
