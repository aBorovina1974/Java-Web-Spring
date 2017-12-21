package hr.hibernate.repositories;

import java.util.List;

import hr.biljeznica.Biljeska;

public interface BiljeskaRepository {

	Biljeska findOne(Integer id);
	Biljeska findBiljeskaByKorisnickoIme(String korisnickoIme);
	List<Biljeska> findAllByKorisnickoIme(String korisnickoIme);
	List<Biljeska> findAll();
	Biljeska save(Biljeska biljeska);
	void delete(Biljeska biljeska);
}
