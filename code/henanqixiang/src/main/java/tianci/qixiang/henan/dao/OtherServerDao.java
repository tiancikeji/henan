package tianci.qixiang.henan.dao;

import java.util.List;

import tianci.qixiang.henan.bean.OtherServerObj;

public interface OtherServerDao {

	void addOtherServer(OtherServerObj os);
	
	List<OtherServerObj> getOtherServerList();

}
