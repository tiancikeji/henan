package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Info {
	private int id;
	private int station_id;
	private int station_code;
	private String snowdeep;
	private String snowpressure;
	private String freezonemax;
	private String freezonemin;
	private String freeztwomax;
	private String freeztwomin;
	private String tornadodistance;
	private String tornadodirection;
	private String verglas;
	private String hailstone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public int getStation_code() {
		return station_code;
	}

	public void setStation_code(int station_code) {
		this.station_code = station_code;
	}

	public String getSnowdeep() {
		return snowdeep;
	}

	public void setSnowdeep(String snowdeep) {
		this.snowdeep = snowdeep;
	}

	public String getSnowpressure() {
		return snowpressure;
	}

	public void setSnowpressure(String snowpressure) {
		this.snowpressure = snowpressure;
	}

	public String getFreezonemax() {
		return freezonemax;
	}

	public void setFreezonemax(String freezonemax) {
		this.freezonemax = freezonemax;
	}

	public String getFreezonemin() {
		return freezonemin;
	}

	public void setFreezonemin(String freezonemin) {
		this.freezonemin = freezonemin;
	}

	public String getFreeztwomax() {
		return freeztwomax;
	}

	public void setFreeztwomax(String freeztwomax) {
		this.freeztwomax = freeztwomax;
	}

	public String getFreeztwomin() {
		return freeztwomin;
	}

	public void setFreeztwomin(String freeztwomin) {
		this.freeztwomin = freeztwomin;
	}

	public String getTornadodistance() {
		return tornadodistance;
	}

	public void setTornadodistance(String tornadodistance) {
		this.tornadodistance = tornadodistance;
	}

	public String getTornadodirection() {
		return tornadodirection;
	}

	public void setTornadodirection(String tornadodirection) {
		this.tornadodirection = tornadodirection;
	}

	public String getVerglas() {
		return verglas;
	}

	public void setVerglas(String verglas) {
		this.verglas = verglas;
	}

	public String getHailstone() {
		return hailstone;
	}

	public void setHailstone(String hailstone) {
		this.hailstone = hailstone;
	}

	public static Info read(String lineTxt) {
		Info info = new Info();
		String[] arr = lineTxt.split(" ");
		info.setSnowdeep(arr[1]);
		info.setSnowpressure(arr[2]);
		info.setFreezonemax(arr[3]);
		info.setFreezonemin(arr[4]);
		info.setFreeztwomax(arr[5]);
		info.setFreeztwomin(arr[6]);
		info.setTornadodirection(arr[7]);
		info.setTornadodistance(arr[8]);
		info.setVerglas(arr[9]);
		info.setHailstone(arr[10]);
		return info;
	}

	public static void save(Connection conn, Info info) {

		PreparedStatement stmt;
		String sql = "INSERT INTO other_info (station_id,station_code,snowdeep,snowpressure,freezonemax,"
				+ "freezonemin,freeztwomax,freeztwomin,tornadodistance ,tornadodirection ,verglas,hailstone) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, info.getStation_id());
			stmt.setInt(2, info.getStation_code());
			stmt.setString(3, info.getSnowdeep());
			stmt.setString(4, info.getSnowpressure());
			stmt.setString(5, info.getFreezonemax());
			stmt.setString(6, info.getFreezonemin());
			stmt.setString(7, info.getFreeztwomax());
			stmt.setString(8, info.getFreeztwomin());
			stmt.setString(9, info.getTornadodistance());
			stmt.setString(10, info.getTornadodirection());
			stmt.setString(11, info.getVerglas());
			stmt.setString(12, info.getHailstone());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
