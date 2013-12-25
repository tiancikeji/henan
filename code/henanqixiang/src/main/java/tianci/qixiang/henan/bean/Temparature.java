package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Temparature {
	private int id;
	private int station_id;
	private int station_code;
	private String temp;
	private String highest;
	private String highesttime;
	private String lowest;
	private String lowesttime;
	private String _24hours;
	private String last24hours;
	private String last24hourshightest;
	private String last24hourslowest;
	private String dewpoint;
	private String relativehumidity;
	private String lowestrelativehumidity;
	private String lowestrelativehumiditytime;
	private String waterpressue;

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

	public String getHighesttime() {
		return highesttime;
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

	public String get_24hours() {
		return _24hours;
	}

	public void set_24hours(String _24hours) {
		this._24hours = _24hours;
	}

	public String getLast24hours() {
		return last24hours;
	}

	public void setLast24hours(String last24hours) {
		this.last24hours = last24hours;
	}

	public String getLast24hourshightest() {
		return last24hourshightest;
	}

	public void setLast24hourshightest(String last24hourshightest) {
		this.last24hourshightest = last24hourshightest;
	}

	public String getLast24hourslowest() {
		return last24hourslowest;
	}

	public void setLast24hourslowest(String last24hourslowest) {
		this.last24hourslowest = last24hourslowest;
	}

	public String getDewpoint() {
		return dewpoint;
	}

	public void setDewpoint(String dewpoint) {
		this.dewpoint = dewpoint;
	}

	public String getRelativehumidity() {
		return relativehumidity;
	}

	public void setRelativehumidity(String relativehumidity) {
		this.relativehumidity = relativehumidity;
	}

	public String getLowestrelativehumidity() {
		return lowestrelativehumidity;
	}

	public void setLowestrelativehumidity(String lowestrelativehumidity) {
		this.lowestrelativehumidity = lowestrelativehumidity;
	}

	public String getLowestrelativehumiditytime() {
		return lowestrelativehumiditytime;
	}

	public void setLowestrelativehumiditytime(String lowestrelativehumiditytime) {
		this.lowestrelativehumiditytime = lowestrelativehumiditytime;
	}

	public String getWaterpressue() {
		return waterpressue;
	}

	public void setWaterpressue(String waterpressue) {
		this.waterpressue = waterpressue;
	}

	public static Temparature read(String lineTxt) {
		Temparature temparature = new Temparature();
		String[] arr = lineTxt.split(" ");
		temparature.setTemp(arr[1]);
		temparature.setHighest(arr[2]);
		temparature.setHighesttime(arr[3]);
		temparature.setLowest(arr[4]);
		temparature.setLowesttime(arr[5]);
		temparature.set_24hours(arr[6]);
		temparature.setLast24hourshightest(arr[7]);
		temparature.setLast24hourslowest(arr[8]);
		temparature.setDewpoint(arr[9]);
		temparature.setRelativehumidity(arr[10]);
		temparature.setLowestrelativehumidity(arr[11]);
		temparature.setLowestrelativehumiditytime(arr[12]);
		temparature.setWaterpressue(arr[13]);
		return temparature;
	}

	public static void save(Connection conn, Temparature temparature) {
		PreparedStatement stmt;
		String sql = "INSERT INTO temparature (station_id,station_code,temp,highest,highesttime,lowest,"
				+ "lowesttime,_24hours,last24hours,last24hourshightest,last24hourslowest,dewpoint,relativehumidity,"
				+ "lowestrelativehumidity,lowestrelativehumiditytime,waterpressue)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, temparature.getStation_id());
			stmt.setInt(2, temparature.getStation_code());
			stmt.setString(3, temparature.getTemp());
			stmt.setString(4, temparature.getHighest());
			stmt.setString(5, temparature.getHighesttime());
			stmt.setString(6, temparature.getLowest());
			stmt.setString(7, temparature.getLowesttime());
			stmt.setString(8, temparature.get_24hours());
			stmt.setString(9, temparature.getLast24hours());
			stmt.setString(10, temparature.getLast24hourshightest());
			stmt.setString(11, temparature.getLast24hourslowest());
			stmt.setString(12, temparature.getDewpoint());
			stmt.setString(13, temparature.getRelativehumidity());
			stmt.setString(14, temparature.getLowestrelativehumidity());
			stmt.setString(15, temparature.getLowestrelativehumiditytime());
			stmt.setString(16, temparature.getWaterpressue());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
