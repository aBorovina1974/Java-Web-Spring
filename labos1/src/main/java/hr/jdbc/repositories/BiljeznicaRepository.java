package hr.jdbc.repositories;

import java.util.List;

import hr.biljeznica.Biljeznica;

public interface BiljeznicaRepository {
	
	Biljeznica findOne(String naziv);
	List<Biljeznica> findAll();
}
