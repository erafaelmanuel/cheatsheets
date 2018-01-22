package io.ermdev.ibatis.typeconverter;

import io.ermdev.ibatis.data.person.Person;
import io.ermdev.ibatis.data.person.PersonRepository;
import io.ermdev.mapfierj.TypeConverter;
import io.ermdev.mapfierj.TypeConverterAdapter;
import io.ermdev.mapfierj.TypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@TypeConverter
public class PersonConverter extends TypeConverterAdapter<Long, Person>{

    private PersonRepository personRepository;

    @Autowired
    public PersonConverter(PersonRepository personRepository) {
        super(null);
        this.personRepository = personRepository;
    }

    @Override
    public Object convert() throws TypeException {
        if(o instanceof Long)
            return convertTo((Long) o);
        else if(o instanceof Person)
            return convertFrom((Person) o);
        else return null;
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
