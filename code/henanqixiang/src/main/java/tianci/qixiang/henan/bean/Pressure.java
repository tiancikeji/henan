package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pressure {

	private Integer id;
	private Integer station_id;
	private Integer station_code;
	private float station;
	private float sealevel;
	private float threehours;
	private float twentyfourhours;
	private float highest;
	private String highesttime;
	private float lowest;
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


	public float getStation() {
		return station;
	}

	public void setStation(float station) {
		this.station = station;
	}

	public float getSealevel() {
		return sealevel;
	}

	public void setSealevel(float sealevel) {
		this.sealevel = sealevel;
	}

	public float getThreehours() {
		return threehours;
	}

	public void setThreehours(float threehours) {
		this.threehours = threehours;
	}

	public float getTwentyfourhours() {
		return twentyfourhours;
	}

	public void setTwentyfourhours(float twentyfourhours) {
		this.twentyfourhours = twentyfourhours;
	}

	public float getHighest() {
		return highest;
	}

	public void setHighest(float highest) {
		this.highest = highest;
	}

	public float getLowest() {
		return lowest;
	}

	public void setLowest(float lowest) {
		this.lowest = lowest;
	}

	public String getHighesttime() {
		return highesttime;
	}

	public void setHighesttime(String highesttime) {
		this.highesttime = highesttime;
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
		pressure.setStation(Float.parseFloat((arr[1].contains("PPC"))?"0":arr[1]));
		pressure.setSealevel(Float.parseFloat((arr[2].contains("//"))?"0":arr[2]));
		pressure.setThreehours(Float.parseFloat((arr[3].contains("//"))?"0":arr[3]));
		pressure.setTwentyfourhours(Float.parseFloat((arr[4].contains("//"))?"0":arr[4]));
		pressure.setHighest(Float.parseFloat((arr[5].contains("//"))?"0":arr[5]));
		pressure.setHighesttime(arr[6]);
		pressure.setLowest(Float.parseFloat((arr[7].contains("//"))?"0":arr[7]));
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
			stmt.setFloat(3, pressure.getStation());
			stmt.setFloat(4, pressure.getSealevel());
			stmt.setFloat(5, pressure.getThreehours());
			stmt.setFloat(6, pressure.getTwentyfourhours());
			stmt.setFloat(7, pressure.getHighest());
			stmt.setString(8, pressure.getHighesttime());
			stmt.setFloat(9, pressure.getLowest());
			stmt.setString(10, pressure.getLowesttime());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
