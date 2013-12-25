package tianci.qixiang.henan.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tianci.qixiang.henan.bean.Earth;
import tianci.qixiang.henan.bean.Info;
import tianci.qixiang.henan.bean.ManualVisual;
import tianci.qixiang.henan.bean.Pressure;
import tianci.qixiang.henan.bean.Rain;
import tianci.qixiang.henan.bean.Station;
import tianci.qixiang.henan.bean.Temparature;
import tianci.qixiang.henan.bean.Visual;
import tianci.qixiang.henan.bean.Wind;

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
				Station newstation = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					
					cur++;
//					System.out.println(lineTxt);
					
//					58015 20131111072000 342700 1162000 00442 00454 4 199 000
//					PP 10215 ///// //// //// 10217 //// 10215 0720
//					TH 0856 0853 0704 0856 0720 //// //// //// 1083 020 020 0720 033
//					RE //// ///// ///// ///// ///// // ///// ////
//					WI 048 026 027 023 018 024 0713 062 023 015 035 0707 /// /// /// ///
//					DT 0860 0838 0702 0860 0720 //// 0848 0859 0869 0873 0856 0837 0818 0809 0829 0811 0703 0829 0720
//					VV ///// ///// ///// ////
//					CW //// /// /// /// ///// //////////////////////// /// // // / / //
//					SP //// /// /// /// /// /// / / /// ///
//					MR 0000000000000000000000000000000000000000////////////////////////////////////////////////////////////////////////////////
//					MW //,.
//					QC
//					Q1 03330600 0000033300000 33333333 0000000000003333 0000030000000000000 3333 333333333333 3333333333 000000000000000000003333333333333333333333333333333333333333
//					Q2 99999999 9999999999999 99999999 9999999999999999 9999999999999999999 9999 999999999999 9999999999 999999999999999999999999999999999999999999999999999999999999
//					Q3 99999999 9999999999999 99999999 9999999999999999 9999999999999999999 9999 999999999999 9999999999 999999999999999999999999999999999999999999999999999999999999=

					if (cur % 15 == 1 && !lineTxt.equals("NNNN")) {
						Station station = Station.read(lineTxt.toString());
						newstation = Station.save(getConnection(),station);
						if(null == newstation){
							return;
						}

					}
					if(lineTxt.toString().contains("PP")){
						Pressure pressure = Pressure.read(lineTxt.toString());
						pressure.setStation_id(newstation.getId());
						pressure.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Pressure.save(getConnection(),pressure);
					}
					
					if(lineTxt.toString().contains("TH")){
						Temparature temparature = Temparature.read(lineTxt.toString());
						temparature.setStation_id(newstation.getId());
						temparature.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Temparature.save(getConnection(),temparature);
					}
					
					if(lineTxt.toString().contains("RE")){
						Rain rain = Rain.read(lineTxt.toString());
						rain.setStation_id(newstation.getId());
						rain.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Rain.save(getConnection(),rain);
					}

					if(lineTxt.toString().contains("WI")){
						Wind wind = Wind.read(lineTxt.toString());
						wind.setStation_id(newstation.getId());
						wind.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Wind.save(getConnection(),wind);
					}
					
					if(lineTxt.toString().contains("DT")){
						Earth earth = Earth.read(lineTxt.toString());
						earth.setStation_id(newstation.getId());
						earth.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Earth.save(getConnection(),earth);
					}
					
					if(lineTxt.toString().contains("VV")){
						Visual visual = Visual.read(lineTxt.toString());
						visual.setStation_id(newstation.getId());
						visual.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Visual.save(getConnection(),visual);
					}
					
					if(lineTxt.toString().contains("CW")){
						ManualVisual manualVisual = ManualVisual.read(lineTxt.toString());
						manualVisual.setStation_id(newstation.getId());
						manualVisual.setStation_code(Integer.parseInt(newstation.getStation_no()));
						ManualVisual.save(getConnection(),manualVisual);
					}
					
					if(lineTxt.toString().contains("SP")){
						Info info = Info.read(lineTxt.toString());
						info.setStation_id(newstation.getId());
						info.setStation_code(Integer.parseInt(newstation.getStation_no()));
						Info.save(getConnection(),info);
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