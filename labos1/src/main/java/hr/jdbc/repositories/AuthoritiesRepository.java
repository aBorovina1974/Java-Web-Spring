package hr.jdbc.repositories;

public interface AuthoritiesRepository {

	boolean hasAdminRole(String username);
}
