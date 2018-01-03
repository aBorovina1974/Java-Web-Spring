package hr.SpringDataJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.biljeznica.Biljeznica;

@Repository
public interface BiljeznicaRepository extends JpaRepository<Biljeznica, String> {
	
}
