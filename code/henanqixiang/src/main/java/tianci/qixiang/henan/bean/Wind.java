package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Wind {
	private int id;
	private int station_id;
	private int station_code;
	private String _2min;
	private String _2minavg;
	private String _10min;
	private String _10minavg;
	private String bigestdirection;
	private String bigestspeed;
	private String bigestspeedtime;
	private String nowdirection;
	private String nowspeed;
	private String maxdirection;
	private String maxspeed;
	private String maxspeedtime;
	private String last6maxspeed;
	private String last6maxdirection;
	private String last12maxspeed;
	private String last12maxdirection;
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
	public String get_2min() {
		return _2min;
	}
	public void set_2min(String _2min) {
		this._2min = _2min;
	}
	public String get_2minavg() {
		return _2minavg;
	}
	public void set_2minavg(String _2minavg) {
		this._2minavg = _2minavg;
	}
	public String get_10min() {
		return _10min;
	}
	public void set_10min(String _10min) {
		this._10min = _10min;
	}
	public String get_10minavg() {
		return _10minavg;
	}
	public void set_10minavg(String _10minavg) {
		this._10minavg = _10minavg;
	}
	public String getBigestdirection() {
		return bigestdirection;
	}
	public void setBigestdirection(String bigestdirection) {
		this.bigestdirection = bigestdirection;
	}
	public String getBigestspeed() {
		return bigestspeed;
	}
	public void setBigestspeed(String bigestspeed) {
		this.bigestspeed = bigestspeed;
	}
	public String getBigestspeedtime() {
		return bigestspeedtime;
	}
	public void setBigestspeedtime(String bigestspeedtime) {
		this.bigestspeedtime = bigestspeedtime;
	}
	public String getNowdirection() {
		return nowdirection;
	}
	public void setNowdirection(String nowdirection) {
		this.nowdirection = nowdirection;
	}
	public String getNowspeed() {
		return nowspeed;
	}
	public void setNowspeed(String nowspeed) {
		this.nowspeed = nowspeed;
	}
	public String getMaxdirection() {
		return maxdirection;
	}
	public void setMaxdirection(String maxdirection) {
		this.maxdirection = maxdirection;
	}
	public String getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(String maxspeed) {
		this.maxspeed = maxspeed;
	}
	public String getMaxspeedtime() {
		return maxspeedtime;
	}
	public void setMaxspeedtime(String maxspeedtime) {
		this.maxspeedtime = maxspeedtime;
	}
	public String getLast6maxspeed() {
		return last6maxspeed;
	}
	public void setLast6maxspeed(String last6maxspeed) {
		this.last6maxspeed = last6maxspeed;
	}
	public String getLast6maxdirection() {
		return last6maxdirection;
	}
	public void setLast6maxdirection(String last6maxdirection) {
		this.last6maxdirection = last6maxdirection;
	}
	public String getLast12maxspeed() {
		return last12maxspeed;
	}
	public void setLast12maxspeed(String last12maxspeed) {
		this.last12maxspeed = last12maxspeed;
	}
	public String getLast12maxdirection() {
		return last12maxdirection;
	}
	public void setLast12maxdirection(String last12maxdirection) {
		this.last12maxdirection = last12maxdirection;
	}
	public static Wind read(String lineTxt) {
		Wind wind = new Wind();
		String[] arr = lineTxt.split(" ");
		wind.set_2min(arr[1]);
		wind.set_2minavg(arr[2]);
		wind.set_10min(arr[3]);
		wind.set_10minavg(arr[4]);
		wind.setBigestdirection(arr[5]);
		wind.setBigestspeed(arr[6]);
		wind.setBigestspeedtime(arr[7]);
		wind.setNowdirection(arr[8]);
		wind.setNowspeed(arr[9]);
		wind.setMaxdirection(arr[10]);
		wind.setMaxspeed(arr[11]);
		wind.setMaxspeedtime(arr[12]);
		wind.setLast6maxspeed(arr[13]);
		wind.setLast6maxdirection(arr[14]);
		wind.setLast12maxspeed(arr[15]);
		wind.setLast12maxdirection(arr[16]);
		return wind;
	}
	public static void save(Connection conn, Wind wind) {
		PreparedStatement stmt;
		String sql = "INSERT INTO wind (station_id,station_code,_2min,_2minavg,_10min,_10minavg,"
				+ "bigestdirection,bigestspeed,bigestspeedtime,nowdirection,nowspeed,"
				+ "maxdirection,maxspeed,maxspeedtime,last6maxspeed,last6maxdirection,last12maxspeed,"
				+ "last12maxdirection)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, wind.getStation_id());
			stmt.setInt(2, wind.getStation_code());
			stmt.setString(3, wind.get_2min());
			stmt.setString(4, wind.get_2minavg());
			stmt.setString(5, wind.get_10min());
			stmt.setString(6, wind.get_10minavg());
			stmt.setString(7, wind.getBigestdirection());
			stmt.setString(8, wind.getBigestspeed());
			stmt.setString(9, wind.getBigestspeedtime());
			stmt.setString(10, wind.getNowdirection());
			stmt.setString(11, wind.getNowspeed());
			stmt.setString(12, wind.getMaxdirection());
			stmt.setString(13, wind.getMaxspeed());
			stmt.setString(14, wind.getMaxspeedtime());
			stmt.setString(15, wind.getLast6maxspeed());
			stmt.setString(16, wind.getLast6maxdirection());
			stmt.setString(17, wind.getLast12maxspeed());
			stmt.setString(18, wind.getLast12maxdirection());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
