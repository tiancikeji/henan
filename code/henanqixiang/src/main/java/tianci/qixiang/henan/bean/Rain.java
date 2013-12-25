package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rain {
	private int id;
	private int station_id;
	private int station_code;
	private String onehour;
	private String lastthreehour;
	private String lastsixhour;
	private String lasttwelvehour;
	private String twentyfourhour;
	private String period;
	private String precipitation;
	private String evaporationcapacity;

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

	public String getOnehour() {
		return onehour;
	}

	public void setOnehour(String onehour) {
		this.onehour = onehour;
	}

	public String getLastthreehour() {
		return lastthreehour;
	}

	public void setLastthreehour(String lastthreehour) {
		this.lastthreehour = lastthreehour;
	}

	public String getLastsixhour() {
		return lastsixhour;
	}

	public void setLastsixhour(String lastsixhour) {
		this.lastsixhour = lastsixhour;
	}

	public String getLasttwelvehour() {
		return lasttwelvehour;
	}

	public void setLasttwelvehour(String lasttwelvehour) {
		this.lasttwelvehour = lasttwelvehour;
	}

	public String getTwentyfourhour() {
		return twentyfourhour;
	}

	public void setTwentyfourhour(String twentyfourhour) {
		this.twentyfourhour = twentyfourhour;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}

	public String getEvaporationcapacity() {
		return evaporationcapacity;
	}

	public void setEvaporationcapacity(String evaporationcapacity) {
		this.evaporationcapacity = evaporationcapacity;
	}

	public static Rain read(String lineTxt) {
		Rain rain = new Rain();
		String[] arr = lineTxt.split(" ");
		rain.setOnehour(arr[1]);
		rain.setLastthreehour(arr[2]);
		rain.setLastsixhour(arr[3]);
		rain.setLasttwelvehour(arr[4]);
		rain.setTwentyfourhour(arr[5]);
		rain.setPeriod(arr[6]);
		rain.setPrecipitation(arr[7]);
		rain.setEvaporationcapacity(arr[8]);
		return rain;
	}

	public static void save(Connection conn, Rain rain) {
		PreparedStatement stmt;
		String sql = "INSERT INTO rain (station_id,station_code,onehour,lastthreehour,lastsixhour,"
				+ "lasttwelvehour,twentyfourhour,period,precipitation,evaporationcapacity)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rain.getStation_id());
			stmt.setInt(2, rain.getStation_code());
			stmt.setString(3, rain.getOnehour());
			stmt.setString(4, rain.getLastthreehour());
			stmt.setString(5, rain.getLastsixhour());
			stmt.setString(6, rain.getLasttwelvehour());
			stmt.setString(7, rain.getTwentyfourhour());
			stmt.setString(8, rain.getPeriod());
			stmt.setString(9, rain.getPrecipitation());
			stmt.setString(10, rain.getEvaporationcapacity());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
