package io.ermdev.ibatis.typeconverter;

import io.ermdev.ibatis.data.person.Person;
import io.ermdev.ibatis.data.person.PersonRepository;
import io.ermdev.mapfierj.TypeConverterAdapter;
import io.ermdev.mapfierj.TypeException;

public class PersonConverter extends TypeConverterAdapter<Long, Person>{

    private PersonRepository personRepository;

    public PersonConverter() {
        super(null);
    }

    public PersonConverter(Object obj) {
        super(obj);
    }

    @Override
    public Object convert() throws TypeException {
        if(super.o instanceof Long)
            return convertTo((Long) super.o);
        else
            return convertFrom((Person) super.o);
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

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
