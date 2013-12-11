package tianci.qixiang.henan.service;

import java.util.List;

import tianci.qixiang.henan.bean.OtherServerObj;

public interface OtherServerService {

	void addOtherServer(OtherServerObj os);
	
	List<OtherServerObj> getOtherServerList();

}
