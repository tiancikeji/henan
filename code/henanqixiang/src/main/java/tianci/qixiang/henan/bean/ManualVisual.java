package tianci.qixiang.henan.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManualVisual {
	
	private int id;
	private int station_id;
	private int station_code;
	private String visibilty;
	private String totalcloudy;
	private String lowestcloudy;
	private String cloud;
	private String level;
	private String form;
	private String formcode;
	private String weathercode;
	private String lastweathercircle;
	private String lastweatherone;
	private String lastweathertwo;

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

	public String getVisibilty() {
		return visibilty;
	}

	public void setVisibilty(String visibilty) {
		this.visibilty = visibilty;
	}

	public String getTotalcloudy() {
		return totalcloudy;
	}

	public void setTotalcloudy(String totalcloudy) {
		this.totalcloudy = totalcloudy;
	}

	public String getLowestcloudy() {
		return lowestcloudy;
	}

	public void setLowestcloudy(String lowestcloudy) {
		this.lowestcloudy = lowestcloudy;
	}

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getFormcode() {
		return formcode;
	}

	public void setFormcode(String formcode) {
		this.formcode = formcode;
	}

	public String getWeathercode() {
		return weathercode;
	}

	public void setWeathercode(String weathercode) {
		this.weathercode = weathercode;
	}

	public String getLastweathercircle() {
		return lastweathercircle;
	}

	public void setLastweathercircle(String lastweathercircle) {
		this.lastweathercircle = lastweathercircle;
	}

	public String getLastweatherone() {
		return lastweatherone;
	}

	public void setLastweatherone(String lastweatherone) {
		this.lastweatherone = lastweatherone;
	}

	public String getLastweathertwo() {
		return lastweathertwo;
	}

	public void setLastweathertwo(String lastweathertwo) {
		this.lastweathertwo = lastweathertwo;
	}

	public static ManualVisual read(String lineTxt) {
		ManualVisual manualVisual = new ManualVisual();
		String[] arr = lineTxt.split(" ");
		manualVisual.setVisibilty(arr[1]);
		manualVisual.setTotalcloudy(arr[2]);
		manualVisual.setLowestcloudy(arr[3]);
		manualVisual.setCloud(arr[4]);
		manualVisual.setLevel(arr[5]);
		manualVisual.setForm(arr[6]);
		manualVisual.setFormcode(arr[7]);
		manualVisual.setWeathercode(arr[8]);
		manualVisual.setLastweathercircle(arr[9]);
		manualVisual.setLastweatherone(arr[10]);
		manualVisual.setLastweathertwo(arr[11]);
		return manualVisual;
	}

	public static void save(Connection conn, ManualVisual manualVisual) {
		PreparedStatement stmt;
		String sql = "INSERT INTO manual_visual (station_id,station_code,visibilty,totalcloudy,lowestcloudy,"
				+ "cloud,level,form,formcode,weathercode,"
				+ "lastweathercircle,lastweatherone,lastweathertwo) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, manualVisual.getStation_id());
			stmt.setInt(2, manualVisual.getStation_code());
			stmt.setString(3, manualVisual.getVisibilty());
			stmt.setString(4, manualVisual.getTotalcloudy());
			stmt.setString(5, manualVisual.getLowestcloudy());
			stmt.setString(6, manualVisual.getCloud());
			stmt.setString(7, manualVisual.getLevel());
			stmt.setString(8, manualVisual.getForm());
			stmt.setString(9, manualVisual.getFormcode());
			stmt.setString(10, manualVisual.getWeathercode());
			stmt.setString(11, manualVisual.getLastweathercircle());
			stmt.setString(12, manualVisual.getLastweatherone());
			stmt.setString(13, manualVisual.getLastweathertwo());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
