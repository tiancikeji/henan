package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Earth {
	private int id;
	private int station_id;
	private int station_code;
	private String temp;
	private String highest;
	private String highesttime;
	private String lowest;
	private String lowesttime;
	private String last12lowest;
	private String _5cm;
	private String _10cm;
	private String _15cm;
	private String _20cm;
	private String _40cm;
	private String _80cm;
	private String _160cm;
	private String _320cm;
	private String gossy;
	private String gossyhighest;
	private String gossyhighesttime;
	private String gossylowest;
	private String gossylowesttime;

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

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
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

	public String getLast12lowest() {
		return last12lowest;
	}

	public void setLast12lowest(String last12lowest) {
		this.last12lowest = last12lowest;
	}

	public String get_5cm() {
		return _5cm;
	}

	public void set_5cm(String _5cm) {
		this._5cm = _5cm;
	}

	public String get_10cm() {
		return _10cm;
	}

	public void set_10cm(String _10cm) {
		this._10cm = _10cm;
	}

	public String get_15cm() {
		return _15cm;
	}

	public void set_15cm(String _15cm) {
		this._15cm = _15cm;
	}

	public String get_20cm() {
		return _20cm;
	}

	public void set_20cm(String _20cm) {
		this._20cm = _20cm;
	}

	public String get_40cm() {
		return _40cm;
	}

	public void set_40cm(String _40cm) {
		this._40cm = _40cm;
	}

	public String get_80cm() {
		return _80cm;
	}

	public void set_80cm(String _80cm) {
		this._80cm = _80cm;
	}

	public String get_160cm() {
		return _160cm;
	}

	public void set_160cm(String _160cm) {
		this._160cm = _160cm;
	}

	public String get_320cm() {
		return _320cm;
	}

	public void set_320cm(String _320cm) {
		this._320cm = _320cm;
	}

	public String getGossy() {
		return gossy;
	}

	public void setGossy(String gossy) {
		this.gossy = gossy;
	}

	public String getGossyhighest() {
		return gossyhighest;
	}

	public void setGossyhighest(String gossyhighest) {
		this.gossyhighest = gossyhighest;
	}

	public String getGossyhighesttime() {
		return gossyhighesttime;
	}

	public void setGossyhighesttime(String gossyhighesttime) {
		this.gossyhighesttime = gossyhighesttime;
	}

	public String getGossylowest() {
		return gossylowest;
	}

	public void setGossylowest(String gossylowest) {
		this.gossylowest = gossylowest;
	}

	public String getGossylowesttime() {
		return gossylowesttime;
	}

	public void setGossylowesttime(String gossylowesttime) {
		this.gossylowesttime = gossylowesttime;
	}

	public static Earth read(String lineTxt) {
		Earth earth = new Earth();
		String[] arr = lineTxt.split(" ");
		earth.setTemp(arr[1]);
		earth.setHighest(arr[2]);
		earth.setHighesttime(arr[3]);
		earth.setLowest(arr[4]);
		earth.setLowesttime(arr[5]);
		earth.setLast12lowest(arr[6]);
		earth.set_5cm(arr[7]);
		earth.set_10cm(arr[8]);
		earth.set_15cm(arr[9]);
		earth.set_20cm(arr[10]);
		earth.set_40cm(arr[11]);
		earth.set_80cm(arr[12]);
		earth.set_160cm(arr[13]);
		earth.set_320cm(arr[14]);
		earth.setGossy(arr[15]);
		earth.setGossyhighest(arr[16]);
		earth.setGossyhighesttime(arr[17]);
		earth.setGossylowest(arr[18]);
		earth.setGossylowesttime(arr[19]);
		return earth;
	}

	public static void save(Connection conn, Earth earth) {
		PreparedStatement stmt;
		String sql = "INSERT INTO earth_temparature (station_id,station_code,temp,highest,highesttime ,"
				+ "lowest,lowesttime,last12lowest,_5cm,_10cm"
				+ ",_15cm,_20cm,_40cm,_80cm,_160cm,"
				+ " _320cm,gossy,gossyhighest,gossyhighesttime,gossylowest,"
				+ "gossylowesttime)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, earth.getStation_id());
			stmt.setInt(2, earth.getStation_code());
			stmt.setString(3, earth.getTemp());
			stmt.setString(4, earth.getHighest());
			stmt.setString(5, earth.getHighesttime());
			stmt.setString(6, earth.getLowest());
			stmt.setString(7, earth.getLowesttime());
			stmt.setString(8, earth.getLast12lowest());
			stmt.setString(9, earth.get_5cm());
			stmt.setString(10, earth.get_10cm());
			stmt.setString(11, earth.get_15cm());
			stmt.setString(12,earth.get_20cm());
			stmt.setString(13,earth.get_40cm());
			stmt.setString(14, earth.get_80cm());
			stmt.setString(15, earth.get_160cm());
			stmt.setString(16, earth.get_320cm());
			stmt.setString(17, earth.getGossy());
			stmt.setString(18, earth.getGossyhighest());
			stmt.setString(19, earth.getGossyhighesttime());
			stmt.setString(20, earth.getGossylowest());
			stmt.setString(21, earth.getGossylowesttime());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
