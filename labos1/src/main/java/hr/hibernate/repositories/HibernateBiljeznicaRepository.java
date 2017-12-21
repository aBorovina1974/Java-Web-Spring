package hr.hibernate.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hr.biljeznica.Biljeznica;

@Repository
@Transactional
public class HibernateBiljeznicaRepository implements BiljeznicaRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateBiljeznicaRepository (SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Biljeznica findOne(String naziv) {
		return currentSession().find(Biljeznica.class, naziv);
	}

	@Override
	public List<Biljeznica> findAll() {
		return currentSession().createQuery("FROM Biljeznica", 
		Biljeznica.class).getResultList();
		

	}

}
