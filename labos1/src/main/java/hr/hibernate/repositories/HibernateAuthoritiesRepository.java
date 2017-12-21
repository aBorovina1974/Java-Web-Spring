package hr.hibernate.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateAuthoritiesRepository implements AuthoritiesRepository {
	
	private SessionFactory sessionFactory;
	
	@Autowired
    public HibernateAuthoritiesRepository(SessionFactory sessionFactory) 
	{
    	this.sessionFactory = sessionFactory;
	}
    
	private Session currentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean hasAdminRole(String username) 
	{
		Query query = currentSession().createQuery(
		"SELECT count(*) FROM UserRole WHERE username = ? AND role = 'ROLE_ADMIN'");
		query.setParameter(0, username);
		Long  count =  (Long) query.uniqueResult();
		
	   	if(count > 0)
	   	{
	   		return true;
	   	}
	   	else
	   	{
	   		return false;
	   	}		
	}

}
