package tianci.qixiang.henan.dao.impl;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tianci.qixiang.henan.bean.FileObj;
import tianci.qixiang.henan.dao.FileDao;

@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	DataSource dataSource;
	
	private String ftp_dir = "/home/ftp/tools/apache-ftpserver-1.0.6/res/home";
//	private String ftp_dir = "c://ftp";
	
	@Override
	public List<FileObj> getFileList() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM filelist";
		List<FileObj> orbitList = jdbcTemplate.query(sql, new RowMapper<FileObj>() {
			public FileObj mapRow(ResultSet rs, int rowNum) throws SQLException {
				FileObj orbit = new FileObj();
				orbit.setFileName(rs.getString("filename"));
				orbit.setDestName(rs.getString("destname"));
				return orbit;
			}
		});
		return orbitList;
	}

	@Override
	public void storeFile() {
		File file = new File(ftp_dir);
		String[] filelist = file.list();

		for (int i = 0; i < filelist.length; i++) {
			File readfile = new File(ftp_dir + "\\" + filelist[i]);
			if (!readfile.isDirectory()) {

				System.out.println("name=" + readfile.getName());
				DateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(readfile.lastModified());
				System.out.println("uptime="
						+ formatter.format(calendar.getTime()));
				
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				
				List<String> uNames = jdbcTemplate.queryForList("SELECT filename FROM filelist WHERE filename=?", 
						new String []{readfile.getName()}, String.class); 
				
				System.out.println("name: " + uNames);
				if(uNames.size() == 0) {
					jdbcTemplate.update("insert into filelist (filename, destname, createtime) values (?, ?, ?)", 
							new Object[] { readfile.getName(), "test", new java.sql.Date(new Date().getTime())});
				}

			}
		}
	}
}
