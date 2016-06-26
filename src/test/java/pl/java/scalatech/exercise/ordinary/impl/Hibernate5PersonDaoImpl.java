package pl.java.scalatech.exercise.ordinary.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;
import pl.java.scalatech.exercise.ordinary.PersonDao;

@Repository
@Slf4j
public class Hibernate5PersonDaoImpl implements PersonDao {
	
	@Autowired
	SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Person findById(Long id) {
		return session().load(Person.class, id);

	}

	@Override
	public Long save(final Person Person) {
		return (Long) session().save(Person);
	}

	@Override
	public void update(final Person Person) {
		session().update(Person);
	}

	@Override
	public void delete(final Long id) {
		session().delete(session().get(Person.class, id));
	}

	@Override
	public void delete(final Person conf) {
		session().refresh(conf);
		session().delete(conf);
	}

	@Override
	public void deleteAll() {
		List<Person> all = session().createQuery("from Person").list();
		for (Person c : all) {
			delete(c);
		}
	}

	@Override
	public Person findByName(String name) {
		List<Person> all = session().createQuery("from Person where name= :name").setParameter("name", name).list();
		if(!all.isEmpty()){
			return all.get(0);
		}
		
		return null;
	}
}