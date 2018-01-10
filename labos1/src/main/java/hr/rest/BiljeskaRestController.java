package hr.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import hr.SpringDataJPA.repositories.BiljeskaRepository;
import hr.biljeznica.Biljeska;

@RestController
@RequestMapping("/api/biljeska")
public class BiljeskaRestController {
	
	@Autowired
	BiljeskaRepository biljeskaRepository;
	
	@GetMapping
	public List<Biljeska> findAll() {
	return biljeskaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Biljeska findOne(@PathVariable Integer id) {
	return biljeskaRepository.findOne(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Biljeska save(@RequestBody Biljeska biljeznica) {
	return biljeskaRepository.save(biljeznica);
	}
	
	@PutMapping("/{id}")
	public Biljeska update(@RequestBody Biljeska biljeznica) {
	return biljeskaRepository.save(biljeznica);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
	biljeskaRepository.delete(biljeskaRepository.findOne(id));
	}

}
