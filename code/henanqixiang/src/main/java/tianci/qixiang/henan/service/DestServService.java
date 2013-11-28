package tianci.qixiang.henan.service;

import java.util.List;

import tianci.qixiang.henan.bean.DestServiceObj;

public interface DestServService {

	void addDestService(DestServiceObj ds);
	
	List<DestServiceObj> getDestList();

}
