package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Visual {
	  private int id;
	  private int station_id;
	  private int station_code;
	  private String  _1minavg;
	  private String _10minavg;
	  private String  min;   
	  private String  mintime;
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
	public String get_1minavg() {
		return _1minavg;
	}
	public void set_1minavg(String _1minavg) {
		this._1minavg = _1minavg;
	}
	public String get_10minavg() {
		return _10minavg;
	}
	public void set_10minavg(String _10minavg) {
		this._10minavg = _10minavg;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMintime() {
		return mintime;
	}
	public void setMintime(String mintime) {
		this.mintime = mintime;
	}
	public static Visual read(String lineTxt) {
		Visual visual  = new Visual();
		String[] arr = lineTxt.split(" ");
		visual.set_1minavg(arr[1]);
		visual.set_10minavg(arr[2]);
		visual.setMin(arr[3]);
		visual.setMintime(arr[4]);
		return visual;
	}
	public static void save(Connection conn, Visual visual) {
		PreparedStatement stmt;
		String sql = "INSERT INTO visual( station_id,station_code,_1minavg,_10minavg,min ,mintime) values(?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, visual.getStation_id());
			stmt.setInt(2, visual.getStation_code());
			stmt.setString(3, visual.get_1minavg());
			stmt.setString(4, visual.get_10minavg());
			stmt.setString(5, visual.getMin());
			stmt.setString(6, visual.getMintime());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
}
