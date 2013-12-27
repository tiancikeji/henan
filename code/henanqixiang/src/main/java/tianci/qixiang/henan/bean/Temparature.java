package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Temparature {
	private int id;
	private int station_id;
	private int station_code;
	private Float temp;
	private Float highest;
	private String highesttime;
	private Float lowest;
	private String lowesttime;
	private Float _24hours;
	private Float last24hours;
	private Float last24hourshightest;
	private Float last24hourslowest;
	private Float dewpoint;
	private Float relativehumidity;
	private Float lowestrelativehumidity;
	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getHighest() {
		return highest;
	}

	public void setHighest(Float highest) {
		this.highest = highest;
	}

	public Float getLowest() {
		return lowest;
	}

	public void setLowest(Float lowest) {
		this.lowest = lowest;
	}

	public Float get_24hours() {
		return _24hours;
	}

	public void set_24hours(Float _24hours) {
		this._24hours = _24hours;
	}

	public Float getLast24hours() {
		return last24hours;
	}

	public void setLast24hours(Float last24hours) {
		this.last24hours = last24hours;
	}

	public Float getLast24hourshightest() {
		return last24hourshightest;
	}

	public void setLast24hourshightest(Float last24hourshightest) {
		this.last24hourshightest = last24hourshightest;
	}

	public Float getLast24hourslowest() {
		return last24hourslowest;
	}

	public void setLast24hourslowest(Float last24hourslowest) {
		this.last24hourslowest = last24hourslowest;
	}

	public Float getDewpoint() {
		return dewpoint;
	}

	public void setDewpoint(Float dewpoint) {
		this.dewpoint = dewpoint;
	}

	public Float getRelativehumidity() {
		return relativehumidity;
	}

	public void setRelativehumidity(Float relativehumidity) {
		this.relativehumidity = relativehumidity;
	}

	public Float getLowestrelativehumidity() {
		return lowestrelativehumidity;
	}

	public void setLowestrelativehumidity(Float lowestrelativehumidity) {
		this.lowestrelativehumidity = lowestrelativehumidity;
	}

	public Float getLowestrelativehumiditytime() {
		return lowestrelativehumiditytime;
	}

	public void setLowestrelativehumiditytime(Float lowestrelativehumiditytime) {
		this.lowestrelativehumiditytime = lowestrelativehumiditytime;
	}

	public Float getWaterpressue() {
		return waterpressue;
	}

	public void setWaterpressue(Float waterpressue) {
		this.waterpressue = waterpressue;
	}

	private Float lowestrelativehumiditytime;
	private Float waterpressue;

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


	public void setHighesttime(String highesttime) {
		this.highesttime = highesttime;
	}


	public String getLowesttime() {
		return lowesttime;
	}

	public void setLowesttime(String lowesttime) {
		this.lowesttime = lowesttime;
	}


	public static Temparature read(String lineTxt) {
		Temparature temparature = new Temparature();
		String[] arr = lineTxt.split(" ");
		temparature.setTemp(Float.parseFloat((arr[1].contains("//"))?"0":arr[1]));
		temparature.setHighest(Float.parseFloat((arr[2].contains("//"))?"0":arr[2]));
		temparature.setHighesttime(arr[3]);
		temparature.setLowest(Float.parseFloat((arr[4].contains("//"))?"0":arr[4]));
		temparature.setLowesttime(arr[5]);
		temparature.set_24hours(Float.parseFloat((arr[6].contains("//"))?"0":arr[6]));
		temparature.setLast24hourshightest(Float.parseFloat((arr[7].contains("//"))?"0":arr[7]));
		temparature.setLast24hourslowest(Float.parseFloat((arr[8].contains("//"))?"0":arr[8]));
		temparature.setDewpoint(Float.parseFloat((arr[9].contains("//"))?"0":arr[9]));
		temparature.setRelativehumidity(Float.parseFloat((arr[10].contains("//"))?"0":arr[10]));
		temparature.setLowestrelativehumidity(Float.parseFloat((arr[11].contains("//"))?"0":arr[11]));
		temparature.setLowestrelativehumiditytime(Float.parseFloat((arr[12].contains("//"))?"0":arr[12]));
		temparature.setWaterpressue(Float.parseFloat((arr[13].contains("//"))?"0":arr[13]));
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
			stmt.setFloat(3, temparature.getTemp());
			stmt.setFloat(4, temparature.getHighest());
			stmt.setString(5, temparature.getHighesttime());
			stmt.setFloat(6, temparature.getLowest());
			stmt.setString(7, temparature.getLowesttime());
			stmt.setFloat(8, temparature.get_24hours());
			stmt.setFloat(9, 0);
			stmt.setFloat(10, temparature.getLast24hourshightest());
			stmt.setFloat(11, temparature.getLast24hourslowest());
			stmt.setFloat(12, temparature.getDewpoint());
			stmt.setFloat(13, temparature.getRelativehumidity());
			stmt.setFloat(14, temparature.getLowestrelativehumidity());
			stmt.setFloat(15, temparature.getLowestrelativehumiditytime());
			stmt.setFloat(16, temparature.getWaterpressue());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
