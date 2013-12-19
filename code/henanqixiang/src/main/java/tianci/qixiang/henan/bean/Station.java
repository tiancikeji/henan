package tianci.qixiang.henan.bean;

public class Station {
	private int id;
	private String station_no;
	private String ober_time;
	private String lat;
	private String lng;
	private String station_altitude;
	private String sensor_altitude;
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
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getStation_altitude() {
		return station_altitude;
	}
	public void setStation_altitude(String station_altitude) {
		this.station_altitude = station_altitude;
	}
	public String getSensor_altitude() {
		return sensor_altitude;
	}
	public void setSensor_altitude(String sensor_altitude) {
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
	
}
