package hr.hibernate.repositories;

public interface AuthoritiesRepository {

	boolean hasAdminRole(String username);
}
