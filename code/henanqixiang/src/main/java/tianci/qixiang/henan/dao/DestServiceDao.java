package tianci.qixiang.henan.dao;

import java.util.List;

import tianci.qixiang.henan.bean.DestServiceObj;

public interface DestServiceDao {

	void addDestService(DestServiceObj ds);
	
	List<DestServiceObj> getDestList();
	
}
