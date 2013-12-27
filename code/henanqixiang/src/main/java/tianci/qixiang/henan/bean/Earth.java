package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Earth {
	private int id;
	private int station_id;
	private int station_code;
	private float temp;
	private float highest;
	private float highesttime;
	private float lowest;
	private float lowesttime;
	private float last12lowest;
	private float _5cm;
	private float _10cm;
	private float _15cm;
	private float _20cm;
	private float _40cm;
	private float _80cm;
	private float _160cm;
	private float _320cm;
	private float gossy;
	private float gossyhighest;
	private float gossyhighesttime;
	private float gossylowest;
	private float gossylowesttime;


	
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

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getHighest() {
		return highest;
	}

	public void setHighest(float highest) {
		this.highest = highest;
	}

	public float getHighesttime() {
		return highesttime;
	}

	public void setHighesttime(float highesttime) {
		this.highesttime = highesttime;
	}

	public float getLowest() {
		return lowest;
	}

	public void setLowest(float lowest) {
		this.lowest = lowest;
	}

	public float getLowesttime() {
		return lowesttime;
	}

	public void setLowesttime(float lowesttime) {
		this.lowesttime = lowesttime;
	}

	public float getLast12lowest() {
		return last12lowest;
	}

	public void setLast12lowest(float last12lowest) {
		this.last12lowest = last12lowest;
	}

	public float get_5cm() {
		return _5cm;
	}

	public void set_5cm(float _5cm) {
		this._5cm = _5cm;
	}

	public float get_10cm() {
		return _10cm;
	}

	public void set_10cm(float _10cm) {
		this._10cm = _10cm;
	}

	public float get_15cm() {
		return _15cm;
	}

	public void set_15cm(float _15cm) {
		this._15cm = _15cm;
	}

	public float get_20cm() {
		return _20cm;
	}

	public void set_20cm(float _20cm) {
		this._20cm = _20cm;
	}

	public float get_40cm() {
		return _40cm;
	}

	public void set_40cm(float _40cm) {
		this._40cm = _40cm;
	}

	public float get_80cm() {
		return _80cm;
	}

	public void set_80cm(float _80cm) {
		this._80cm = _80cm;
	}

	public float get_160cm() {
		return _160cm;
	}

	public void set_160cm(float _160cm) {
		this._160cm = _160cm;
	}

	public float get_320cm() {
		return _320cm;
	}

	public void set_320cm(float _320cm) {
		this._320cm = _320cm;
	}

	public float getGossy() {
		return gossy;
	}

	public void setGossy(float gossy) {
		this.gossy = gossy;
	}

	public float getGossyhighest() {
		return gossyhighest;
	}

	public void setGossyhighest(float gossyhighest) {
		this.gossyhighest = gossyhighest;
	}

	public float getGossyhighesttime() {
		return gossyhighesttime;
	}

	public void setGossyhighesttime(float gossyhighesttime) {
		this.gossyhighesttime = gossyhighesttime;
	}

	public float getGossylowest() {
		return gossylowest;
	}

	public void setGossylowest(float gossylowest) {
		this.gossylowest = gossylowest;
	}

	public float getGossylowesttime() {
		return gossylowesttime;
	}

	public void setGossylowesttime(float gossylowesttime) {
		this.gossylowesttime = gossylowesttime;
	}

	public static Earth read(String lineTxt) {
		Earth earth = new Earth();
		String[] arr = lineTxt.split(" ");
		earth.setTemp(Float.parseFloat((arr[1].contains("//"))?"0":arr[1]));
		earth.setHighest(Float.parseFloat((arr[2].contains("//"))?"0":arr[2]));
		earth.setHighesttime(Float.parseFloat((arr[3].contains("//"))?"0":arr[3]));
		earth.setLowest(Float.parseFloat((arr[4].contains("//"))?"0":arr[4]));
		earth.setLowesttime(Float.parseFloat((arr[5].contains("//"))?"0":arr[5]));
		earth.setLast12lowest(Float.parseFloat((arr[6].contains("//"))?"0":arr[6]));
		earth.set_5cm(Float.parseFloat((arr[7].contains("//"))?"0":arr[7]));
		earth.set_10cm(Float.parseFloat((arr[8].contains("//"))?"0":arr[8]));
		earth.set_15cm(Float.parseFloat((arr[9].contains("//"))?"0":arr[9]));
		earth.set_20cm(Float.parseFloat((arr[10].contains("//"))?"0":arr[10]));
		earth.set_40cm(Float.parseFloat((arr[11].contains("//"))?"0":arr[11]));
		earth.set_80cm(Float.parseFloat((arr[12].contains("//"))?"0":arr[12]));
		earth.set_160cm(Float.parseFloat((arr[13].contains("//"))?"0":arr[13]));
		earth.set_320cm(Float.parseFloat((arr[14].contains("//"))?"0":arr[14]));
		earth.setGossy(Float.parseFloat((arr[15].contains("//"))?"0":arr[15]));
		earth.setGossyhighest(Float.parseFloat((arr[16].contains("//"))?"0":arr[16]));
		earth.setGossyhighesttime(Float.parseFloat((arr[17].contains("//"))?"0":arr[17]));
		earth.setGossylowest(Float.parseFloat((arr[18].contains("//"))?"0":arr[18]));
		earth.setGossylowesttime(Float.parseFloat((arr[19].contains("//"))?"0":arr[19]));
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
			stmt.setFloat(3, earth.getTemp());
			stmt.setFloat(4, earth.getHighest());
			stmt.setFloat(5, earth.getHighesttime());
			stmt.setFloat(6, earth.getLowest());
			stmt.setFloat(7, earth.getLowesttime());
			stmt.setFloat(8, earth.getLast12lowest());
			stmt.setFloat(9, earth.get_5cm());
			stmt.setFloat(10, earth.get_10cm());
			stmt.setFloat(11, earth.get_15cm());
			stmt.setFloat(12,earth.get_20cm());
			stmt.setFloat(13,earth.get_40cm());
			stmt.setFloat(14, earth.get_80cm());
			stmt.setFloat(15, earth.get_160cm());
			stmt.setFloat(16, earth.get_320cm());
			stmt.setFloat(17, earth.getGossy());
			stmt.setFloat(18, earth.getGossyhighest());
			stmt.setFloat(19, earth.getGossyhighesttime());
			stmt.setFloat(20, earth.getGossylowest());
			stmt.setFloat(21, earth.getGossylowesttime());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
