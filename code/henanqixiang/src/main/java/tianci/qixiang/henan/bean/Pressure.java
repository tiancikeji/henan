package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pressure {

	private Integer id;
	private Integer station_id;
	private Integer station_code;
	private String station;
	private String sealevel;
	private String threehours;
	private String twentyfourhours;
	private String highest;
	private String highesttime;
	private String lowest;
	private String lowesttime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStation_id() {
		return station_id;
	}

	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}

	public Integer getStation_code() {
		return station_code;
	}

	public void setStation_code(Integer station_code) {
		this.station_code = station_code;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getSealevel() {
		return sealevel;
	}

	public void setSealevel(String sealevel) {
		this.sealevel = sealevel;
	}

	public String getThreehours() {
		return threehours;
	}

	public void setThreehours(String threehours) {
		this.threehours = threehours;
	}

	public String getTwentyfourhours() {
		return twentyfourhours;
	}

	public void setTwentyfourhours(String twentyfourhours) {
		this.twentyfourhours = twentyfourhours;
	}

	public String getHighest() {
		return highest;
	}

	public void setHighest(String highest) {
		this.highest = highest;
	}

	public String getHighesttime() {
		return highesttime;
	}

	public void setHighesttime(String highesttime) {
		this.highesttime = highesttime;
	}

	public String getLowest() {
		return lowest;
	}

	public void setLowest(String lowest) {
		this.lowest = lowest;
	}

	public String getLowesttime() {
		return lowesttime;
	}

	public void setLowesttime(String lowesttime) {
		this.lowesttime = lowesttime;
	}

	public static Pressure read(String lineTxt){
		Pressure pressure = new Pressure();
		String[] arr = lineTxt.split(" ");
		pressure.setStation(arr[1]);
		pressure.setSealevel(arr[2]);
		pressure.setThreehours(arr[3]);
		pressure.setTwentyfourhours(arr[4]);
		pressure.setHighest(arr[5]);
		pressure.setHighesttime(arr[6]);
		pressure.setLowest(arr[7]);
		pressure.setLowesttime(arr[8]);
		return pressure;
	}
	
	public static void save(Connection conn,Pressure pressure){
		PreparedStatement stmt;
		String sql = "INSERT INTO pressure (station_id,station_code, station,sealevel,"
				+ "threehours,twentyfourhours,"
				+ "highest,highesttime,lowest,lowesttime) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pressure.getStation_id());
			stmt.setInt(2,pressure.getStation_code());
			stmt.setString(3, pressure.getStation());
			stmt.setString(4, pressure.getSealevel());
			stmt.setString(5, pressure.getThreehours());
			stmt.setString(6, pressure.getTwentyfourhours());
			stmt.setString(7, pressure.getHighest());
			stmt.setString(8, pressure.getHighesttime());
			stmt.setString(9, pressure.getLowest());
			stmt.setString(10, pressure.getLowesttime());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
