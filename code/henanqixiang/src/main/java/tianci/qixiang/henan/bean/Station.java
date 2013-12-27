package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Station {
	private int id;
	private String station_no;
	private String ober_time;
	private float lat;
	private float lng;
	private float station_altitude;
	private float sensor_altitude;
	private String ober_method;
	private String quality_flag;
	private String file_update_flag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStation_no() {
		return station_no;
	}
	public void setStation_no(String station_no) {
		this.station_no = station_no;
	}
	public String getOber_time() {
		return ober_time;
	}
	public void setOber_time(String ober_time) {
		this.ober_time = ober_time;
	}

	
	
	
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public float getStation_altitude() {
		return station_altitude;
	}
	public void setStation_altitude(float station_altitude) {
		this.station_altitude = station_altitude;
	}
	public float getSensor_altitude() {
		return sensor_altitude;
	}
	public void setSensor_altitude(float sensor_altitude) {
		this.sensor_altitude = sensor_altitude;
	}
	public String getOber_method() {
		return ober_method;
	}
	public void setOber_method(String ober_method) {
		this.ober_method = ober_method;
	}
	public String getQuality_flag() {
		return quality_flag;
	}
	public void setQuality_flag(String quality_flag) {
		this.quality_flag = quality_flag;
	}
	public String getFile_update_flag() {
		return file_update_flag;
	}
	public void setFile_update_flag(String file_update_flag) {
		this.file_update_flag = file_update_flag;
	}
	
	public static Station read(String lineTxt) {
		Station station = new Station();
		String[] arr = lineTxt.split(" ");
		station.setStation_no(arr[0]);
		station.setOber_time(arr[1]);

		double lat = Double.parseDouble(arr[2].substring(0, 2))+Double.parseDouble(arr[2].substring(2, 4))/60+Double.parseDouble(arr[2].substring(4, 6))/3600;
		
		station.setLat((float) lat);

		double lng = Double.parseDouble(arr[3].substring(0, 3))+Double.parseDouble(arr[3].substring(3, 5))/60+Double.parseDouble(arr[3].substring(5, 7))/3600;
		station.setLng((float) lng);
		
		
		station.setStation_altitude(Float.parseFloat(arr[4]));
		station.setSensor_altitude(Float.parseFloat(arr[5]));
		station.setOber_method(arr[6]);
		station.setQuality_flag(arr[7]);
		station.setFile_update_flag(arr[8]);
//		System.out.println(station.getOber_time());
		return station;
	}
	
	public static Station save(Connection conn,Station station){
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO station (station_no,ober_time,lat,lng,statiion_altitude,sensor_altitude,ober_method,quality_flag,file_update_flag)"
					+ " VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,station.getStation_no());	
			stmt.setString(2,station.getOber_time());
			stmt.setFloat(3, station.getLat());
			stmt.setFloat(4,station.getLng());
			stmt.setFloat(5, station.getStation_altitude());
			stmt.setFloat(6, station.getSensor_altitude());
			stmt.setString(7, station.getOber_method());
			stmt.setString(8,station.getQuality_flag());
			stmt.setString(9, station.getFile_update_flag());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				Long id = rs.getLong(1);
				station.setId(id.intValue());
				return station;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public static void main(String argv[]) {
		String lnt = "342700";
		String lng = "1162000";
		System.out.println(lnt.length());
		if(lnt.length()==6){
		}
		
		System.out.println(lng.length());
	}
	
}
