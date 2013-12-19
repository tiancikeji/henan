package tianci.qixiang.henan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tianci.qixiang.henan.bean.OtherServerObj;
import tianci.qixiang.henan.dao.OtherServerDao;
import tianci.qixiang.henan.service.OtherServerService;

@Service
@Transactional
public class OtherServerServiceImpl implements OtherServerService {

	@Autowired
	private OtherServerDao otherServerDao;

	
	@Override
	public void addOtherServer(OtherServerObj os) {
		otherServerDao.addOtherServer(os);
	}


	@Override
	public List<OtherServerObj> getOtherServerList() {
		return otherServerDao.getOtherServerList();
	}

}
