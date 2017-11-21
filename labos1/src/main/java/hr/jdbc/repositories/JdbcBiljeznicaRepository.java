package hr.jdbc.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hr.biljeznica.Biljeznica;

public class JdbcBiljeznicaRepository implements BiljeznicaRepository {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcBiljeznicaRepository(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Biljeznica findOne(String naziv) {
		return jdbcTemplate.queryForObject(
		"SELECT naziv, opisSadrzaja FROM biljeznica WHERE naziv = ?", 
		new BiljeznicaRowMapper(), naziv);
	}

	@Override
	public List<Biljeznica> findAll() {
		return jdbcTemplate.query("SELECT * FROM biljeznica", 
		new BiljeznicaRowMapper());
	}
	
	private static final class BiljeznicaRowMapper implements RowMapper<Biljeznica>
	{

		@Override
		public Biljeznica mapRow(ResultSet rs, int rowNum) throws SQLException {
			String naziv = rs.getString("naziv");
			String opisSadrzaja = rs.getString("opis");
			return new Biljeznica(naziv, opisSadrzaja);
		}
		
	}

}
