package com.transunion.test.loreTest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogicaTest {
	
	@Autowired
	DatosRepository datosRepo;
	@Autowired
	ComplementarioRepository comprep;
	
	@Transactional
	@Async //This annotation replaces building your own thread
    public void asyncLongOperation() {
		try {
			Datos d= new Datos();
			d.setAsunto("hola");
			List<Datos> datos = datosRepo.findByAsunto("hola");
			//List<Datos> datos = datosRepo.findAll();
			for (Datos datos2 : datos) {
				Collection<Complementario> resultado = datos2.getComplementarioCollection();
				for (Complementario res : resultado) {
					System.out.println(res.getSaludo());
				}
				List<Complementario> comp = comprep.findByDatoId(datos2.getDatosId());
				for (Complementario datos3 : comp) {
					System.out.println(datos3.getSaludo());
				}
			}
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			System.out.println("Errorsito "+e.toString());
		}
		System.out.println("Execute method asynchronously. "
			      + Thread.currentThread().getName());
    }
}
