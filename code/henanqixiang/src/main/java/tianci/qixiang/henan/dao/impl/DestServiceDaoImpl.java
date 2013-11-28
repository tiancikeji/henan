package tianci.qixiang.henan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tianci.qixiang.henan.bean.DestServiceObj;
import tianci.qixiang.henan.dao.DestServiceDao;

@Repository
public class DestServiceDaoImpl implements DestServiceDao {

	@Autowired
	DataSource dataSource;

	@Override
	public void addDestService(DestServiceObj ds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into destservice (destip, destname, destdir, createtime) values (?, ?, ?, ?)", 
				new Object[] { ds.getDestIp(), ds.getDestName(), 
		ds.getDestDir(), new java.sql.Date(new Date().getTime())});

//		jdbcTemplate.update("INSERT INTO destservice VALUES(?,?,..)",                     
//		        new PreparedStatementSetter(){                          
//		               public void setValues(PreparedStatement ps) throws SQLException{      
//		                    ps.setLong(1, user.getId(1)); 
//		                    ps.setString(2, user.getName(2));   
//		                    ps.setDate(3, new java.sql.Date(new Date().getTime());  
//		                    ps.setTimestamp(4, new Timestamp(new Date().getTime());
//		               }                     
//		        }
//		);
	}

	@Override
	public List<DestServiceObj> getDestList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM destservice";
		List<DestServiceObj> orbitList = jdbcTemplate.query(sql, new RowMapper<DestServiceObj>() {
			public DestServiceObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				DestServiceObj orbit = new DestServiceObj();
				orbit.setDestIp(rs.getString("destip"));
				orbit.setDestName(rs.getString("destname"));
				orbit.setDestDir(rs.getString("destdir"));
				return orbit;
			}
		});
		return orbitList;
	}

	
}
