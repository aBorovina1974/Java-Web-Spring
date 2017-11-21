package hr.jdbc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hr.biljeznica.Korisnik;

public class JdbcKorisnikRepository implements KorisnikRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcKorisnikRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Korisnik findOne(Integer korisnikId) {
		return jdbcTemplate.queryForObject(
		"SELECT id, username, ime, prezime  FROM user WHERE id = ?",
		new KorisnikRowMapper(), korisnikId);
	}

	@Override
	public List<Korisnik> findAll() {
		return jdbcTemplate.query("SELECT id, username, ime, prezime  FROM user", 
		new KorisnikRowMapper());
	}

	private static final class KorisnikRowMapper implements RowMapper<Korisnik>
	{

		@Override
		public Korisnik mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer korisnikId = rs.getInt("id");
			String  korisnickoIme = rs.getString("username");
			String  imeKorisnika = rs.getString("ime");
			String  prezimeKorisnika = rs.getString("prezime");
			
			return new Korisnik(korisnikId, korisnickoIme, imeKorisnika, prezimeKorisnika);
		}
	}
		

}
