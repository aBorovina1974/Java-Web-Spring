package hr.jdbc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import hr.biljeznica.Biljeska;
import hr.biljeznica.Biljeznica;
import hr.biljeznica.Korisnik;

public class JdbcBiljeskaRepository implements BiljeskaRepository {
	
	private static final String SELECT_BILJESKA = "SELECT b.id, b.naslov, b.tekst, b.korisnik,"
	+ "b.biljeznica, bilj.naziv, bilj.opis, k.id AS korisnikId, k.username, k.ime, k.prezime "
	+ "FROM biljeska b "
	+ "INNER JOIN biljeznica bilj ON b.biljeznica = bilj.naziv "
	+ "INNER JOIN user k ON b.korisnik = k.username";
	
	private static final String SELECT_BILJESKA_BY_ID = SELECT_BILJESKA + " WHERE b.id = ?";
	
	private static final String SELECT_BILJESKA_BY_KORISNICKO_IME = 
    SELECT_BILJESKA + " WHERE b.korisnik = ?";
	
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcBiljeskaRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Biljeska findOne(Integer id) {
		return jdbcTemplate.queryForObject(SELECT_BILJESKA_BY_ID, 
		new BiljeskaRowMapper(), id);
	}

	@Override
	public Biljeska findBiljeskaByKorisnickoIme(String korisnickoIme) {
		return jdbcTemplate.queryForObject(SELECT_BILJESKA_BY_KORISNICKO_IME,
	    new BiljeskaRowMapper(), korisnickoIme);
	}

	@Override
	public List<Biljeska> findAll() {
		return jdbcTemplate.query(SELECT_BILJESKA, new BiljeskaRowMapper());
	}
	
	@Override
	public List<Biljeska> findAllByKorisnickoIme(String korisnickoIme) {
		return jdbcTemplate.query(SELECT_BILJESKA_BY_KORISNICKO_IME,
	    new BiljeskaRowMapper(), korisnickoIme);
	}

	@Override
	public Biljeska save(Biljeska biljeska) {
		Integer biljeskaId = insertBiljeskaAndReturnId(biljeska);
		return new Biljeska(biljeskaId, biljeska.getNaslov(), biljeska.getText(),
		biljeska.getKorisnik(), biljeska.getBiljeznica());
	}

	@Override
	public void delete(Integer id) {
	    jdbcTemplate.update("DELETE FROM biljeska WHERE id = ?", id);
	}
	
	private Integer insertBiljeskaAndReturnId(Biljeska biljeska)
	{
		SimpleJdbcInsert jdbcInsert = new 
		SimpleJdbcInsert(jdbcTemplate).withTableName("biljeska");
		jdbcInsert.setGeneratedKeyName("id");
		Map<String, Object> args = new HashMap<>();
		args.put("naslov", biljeska.getNaslov());
		args.put("tekst", biljeska.getText());
		args.put("korisnik", biljeska.getKorisnik().getKorisnickoIme());
		args.put("biljeznica", biljeska.getBiljeznica().getNaziv());
		Integer biljeskaId = jdbcInsert.executeAndReturnKey(args).intValue();
		return biljeskaId;
	}
	
	private static final class BiljeskaRowMapper implements RowMapper<Biljeska>
	{

		@Override
		public Biljeska mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer biljeskaId = rs.getInt("id");
			String  naslov = rs.getString("naslov");
			String  text = rs.getString("tekst");
			
			Integer korisnikId = rs.getInt("korisnikId");
			String  korisnickoIme = rs.getString("username");
			String  imeKorisnika = rs.getString("ime");
			String  prezimeKorisnika = rs.getString("prezime");
			Korisnik korisnik = new 
			Korisnik(korisnikId, korisnickoIme, imeKorisnika, prezimeKorisnika);
			
			String  naziv = rs.getString("naziv");
			String  opisSadrzaja = rs.getString("opis");
			Biljeznica biljeznica = new Biljeznica(naziv, opisSadrzaja);
			
			return new Biljeska(biljeskaId, naslov, text, korisnik, biljeznica);
		}
		
	}

}
