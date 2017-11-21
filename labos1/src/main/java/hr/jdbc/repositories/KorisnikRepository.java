package hr.jdbc.repositories;

import java.util.List;

import hr.biljeznica.Korisnik;

public interface KorisnikRepository {
	
	Korisnik findOne(Integer korisnikId);
	List<Korisnik> findAll();
}
