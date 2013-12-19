package tianci.qixiang.henan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tianci.qixiang.henan.bean.FileObj;
import tianci.qixiang.henan.dao.FileDao;
import tianci.qixiang.henan.service.FileService;

@Service
@Transactional
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	
	@Override
	public void storeFile() {
		fileDao.storeFile();
	}

	@Override
	public List<FileObj> getFileList() {
		return fileDao.getFileList();
	}

}
