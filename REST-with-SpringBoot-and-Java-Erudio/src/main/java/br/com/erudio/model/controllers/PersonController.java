package br.com.erudio.model.controllers;

import java.util.List;

import br.com.erudio.model.data.vo.v1.PersonVOV1;
import br.com.erudio.model.data.vo.v2.PersonVOV2;
import br.com.erudio.model.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVOV1> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV1 findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV1 create(@RequestBody PersonVOV1 person) {
		return service.create(person);
	}
	@PostMapping(value = "/v2",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return service.createV2(person);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV1 update(@RequestBody PersonVOV1 person) {
		return service.update(person);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}