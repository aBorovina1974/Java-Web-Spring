package hr.hibernate.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.biljeznica.Korisnik;

@Repository
@Transactional
public class HibernateKorisnikRepository implements KorisnikRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateKorisnikRepository(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Korisnik findOne(Integer korisnikId) {
		return currentSession().find(Korisnik.class, korisnikId);
	}

	@Override
	public List<Korisnik> findAll() {
		return currentSession().createQuery("FROM Korisnik", 
		Korisnik.class).getResultList();
	}

}
