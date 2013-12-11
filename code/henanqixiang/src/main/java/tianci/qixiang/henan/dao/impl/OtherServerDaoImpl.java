package tianci.qixiang.henan.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tianci.qixiang.henan.bean.OtherServerObj;
import tianci.qixiang.henan.dao.OtherServerDao;

@Repository
public class OtherServerDaoImpl implements OtherServerDao {

	@Autowired
	DataSource dataSource;

	
	@Override
	public void addOtherServer(OtherServerObj os) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into ftpserver (ftpip, ftpname, ftpdir) values (?, ?, ?)", 
				new Object[] { os.getFtpIp(), os.getFtpName(), os.getFtpDir()});

	}


	@Override
	public List<OtherServerObj> getOtherServerList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM ftpserver";
		List<OtherServerObj> orbitList = jdbcTemplate.query(sql, new RowMapper<OtherServerObj>() {
			public OtherServerObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				OtherServerObj orbit = new OtherServerObj();
				orbit.setFtpIp(rs.getString("ftpip"));
				orbit.setFtpName(rs.getString("ftpname"));
				orbit.setFtpDir(rs.getString("ftpdir"));
				return orbit;
			}
		});
		return orbitList;
	}

}
