package tianci.qixiang.henan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tianci.qixiang.henan.bean.DestServiceObj;
import tianci.qixiang.henan.dao.DestServiceDao;
import tianci.qixiang.henan.service.DestServService;

@Service
@Transactional
public class DestServServiceImpl implements DestServService {

	@Autowired
	private DestServiceDao destServiceDao;
	
	@Override
	public void addDestService(DestServiceObj ds) {
		destServiceDao.addDestService(ds);
	}

	@Override
	public List<DestServiceObj> getDestList() {
		return destServiceDao.getDestList();
	}

}
