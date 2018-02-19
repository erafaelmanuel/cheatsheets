package io.ermdev.ibatis.typeconverter;

import io.ermdev.ibatis.data.person.Person;
import io.ermdev.ibatis.data.person.PersonRepository;
import mapfierj.TypeConverter;
import mapfierj.TypeConverterAdapter;
import mapfierj.TypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@TypeConverter
public class PersonConverter extends TypeConverterAdapter<Long, Person> {

    private PersonRepository personRepository;

    public PersonConverter() {
    }

    @Autowired
    public PersonConverter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person convertTo(Long ownerId) throws TypeException {
        try {
            return personRepository.findById(ownerId);
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Long convertFrom(Person person) throws TypeException {
        return person.getId();
    }
}
