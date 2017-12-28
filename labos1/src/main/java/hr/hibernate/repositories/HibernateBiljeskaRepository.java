package hr.hibernate.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.biljeznica.Biljeska;

@Repository
@Transactional
public class HibernateBiljeskaRepository implements BiljeskaRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateBiljeskaRepository (SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Biljeska findOne(Integer id) {
		
		return currentSession().find(Biljeska.class, id);
	}

	@Override
	public Biljeska findBiljeskaByKorisnickoIme(String korisnickoIme) {
		
		return currentSession().find(Biljeska.class, korisnickoIme);
	}

	@Override
	public List<Biljeska> findAllByKorisnickoIme(String korisnickoIme) {
	
		Query query = currentSession().createQuery(
		"FROM Biljeska b WHERE b.korisnik.korisnickoIme = ?");
		query.setParameter(0, korisnickoIme);
		return (List<Biljeska>)query.list();
	}

	@Override
	public List<Biljeska> findAll() {
		
		return currentSession().createQuery("FROM Biljeska", 
		Biljeska.class).getResultList();
	}

	@Override
	public Biljeska save(Biljeska biljeska) {
		
		Integer biljeskaId = (Integer) currentSession().save(biljeska);
		return currentSession().find(Biljeska.class, biljeskaId);
	}

	@Override
	public void delete(Biljeska biljeska) {
		currentSession().delete(biljeska);
	}

}
