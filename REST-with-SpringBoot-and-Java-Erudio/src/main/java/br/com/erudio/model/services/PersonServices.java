package br.com.erudio.model.services;

import java.util.List;
import java.util.logging.Logger;

import br.com.erudio.model.data.vo.v1.PersonVOV1;
import br.com.erudio.model.data.vo.v2.PersonVOV2;
import br.com.erudio.model.entities.Person;
import br.com.erudio.model.exceptions.ResourceNotFoundException;
import br.com.erudio.model.repositories.PersonRepository;
import br.com.erudio.model.util.mapper.DozerMapper;
import br.com.erudio.model.util.mapper.custom.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;

	public List<PersonVOV1> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVOV1.class);
	}

	public PersonVOV1 findById(Long id) {
		
		logger.info("Finding one person!");
		
		var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PersonVOV1.class);
	}
	
	public PersonVOV1 create(PersonVOV1 person) {

		logger.info("Creating one person!");
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVOV1.class);
		return vo;
	}
	public PersonVOV2 createV2(PersonVOV2 person) {

		logger.info("Creating one person with V2!");
		var entity = mapper.convertVoToEntity(person);
		var vo =  mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVOV1 update(PersonVOV1 person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVOV1.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}


}
