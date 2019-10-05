package com.transunion.test.loreTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

class Sortbyroll implements Comparator<Usuario> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Usuario a, Usuario b) 
    { 
        return b.getEdad() - a.getEdad(); 
    } 
} 

@RestController
@RequestMapping(path="/hola")
public class RestTest {
	@Autowired
	LogicaTest logica;
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/mundo",
			consumes = "application/json",
			produces = "application/json")
	public @ResponseBody Usuario mundo(@RequestBody Usuario usuario) {
		int edadNueva = (int)(Math.random()*100+1);
		usuario.setEdad(edadNueva);
		return usuario;
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/asincrono",
			consumes = "application/json")
	public @ResponseBody String asincrono() {
		logica.asyncLongOperation();
		return "Si se hizo";
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/mundos",
			consumes = "application/json",
			produces = "application/json")
	public @ResponseBody Usuario mundos(@RequestBody ArrayList<Usuario> usuarios) {
		Usuario aux = new Usuario();
		for (Usuario usuario : usuarios) {
			if(usuario.getEdad()>aux.getEdad()) {
				aux = usuario;
			}
		}
		return aux;
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/varios",
			consumes = "application/json",
			produces = "application/json")
	public @ResponseBody ArrayList<Usuario> varios(@RequestBody ArrayList<Usuario> usuarios) {
		Collections.sort(usuarios, new Sortbyroll());
		return usuarios;
	}
}
