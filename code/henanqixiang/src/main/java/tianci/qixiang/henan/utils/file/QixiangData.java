package tianci.qixiang.henan.utils.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tianci.qixiang.henan.bean.Station;

public class QixiangData {
	
	public static void readTxtFile(String filePath) {
		try {
			String encoding = "utf8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				int cur = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					cur++;
					if (cur % 15 == 1 && !lineTxt.equals("NNNN")) {
						Station station = readStation(lineTxt.toString());
						saveStation(station);
					}
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}

	private static Station readStation(String lineTxt) {
		Station station = new Station();
		String[] arr = lineTxt.split(" ");
		station.setStation_no(arr[0]);
		station.setOber_time(arr[1]);
		station.setLat(arr[2]);
		station.setLng(arr[3]);
		station.setStation_altitude(arr[4]);
		station.setSensor_altitude(arr[5]);
		station.setOber_method(arr[6]);
		station.setQuality_flag(arr[7]);
		station.setFile_update_flag(arr[8]);
//		System.out.println(station.getOber_time());
		return station;
	}
	
	private static void saveStation(Station station){
		Connection conn = getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO station (station_no,ober_time,lat,lng,statiion_altitude,sensor_altitude,ober_method,quality_flag,file_update_flag)"
					+ " VALUES(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,station.getStation_no());	
			stmt.setString(2,station.getOber_time());
			stmt.setString(3, station.getLat());
			stmt.setString(4,station.getLng());
			stmt.setString(5, station.getStation_altitude());
			stmt.setString(6, station.getSensor_altitude());
			stmt.setString(7, station.getOber_method());
			stmt.setString(8,station.getQuality_flag());
			stmt.setString(9, station.getFile_update_flag());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	 public static Connection getConnection() {
	        try {
	            Class.forName("net.sourceforge.jtds.jdbc.Driver");
	            String url = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=henan";
	            String username = "sa";
	            String password = "woaixuexi";
	            Connection conn = DriverManager.getConnection(url, username,password);
	            return conn;
	        } catch (Exception e) {
	            throw new IllegalArgumentException(e);
	        }
	    } 

	public static void main(String argv[]) {
		String filePath = "F:\\河南气象\\Z_SURF_C_BEHF_20131111072206_O_AWS_FTM.txt";
		// "res/";
		readTxtFile(filePath);
		
	}

}