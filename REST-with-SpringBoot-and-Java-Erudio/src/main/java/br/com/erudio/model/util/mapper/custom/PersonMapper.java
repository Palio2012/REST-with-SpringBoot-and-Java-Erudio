package br.com.erudio.model.util.mapper.custom;

import br.com.erudio.model.data.vo.v2.PersonVOV2;
import br.com.erudio.model.entities.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo (Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setAddress(person.getAddress());
        vo.setBirthdate(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }
    public Person convertVoToEntity (PersonVOV2 person) {
        Person entity = new Person();
        entity.setAddress(person.getAddress());
        // entity.setBirthdate(new Date());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        return entity;
    }
}
