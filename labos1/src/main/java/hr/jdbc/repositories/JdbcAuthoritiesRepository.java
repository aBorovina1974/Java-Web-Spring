package hr.jdbc.repositories;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcAuthoritiesRepository implements AuthoritiesRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcAuthoritiesRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean hasAdminRole(String username) 
	{
		Integer count = jdbcTemplate.queryForObject(
		"SELECT count(*) FROM user_role WHERE username = ? AND role = 'ROLE_ADMIN'", 
		Integer.class, username);
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
