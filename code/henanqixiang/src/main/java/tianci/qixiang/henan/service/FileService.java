package tianci.qixiang.henan.service;

import java.util.List;

import tianci.qixiang.henan.bean.FileObj;

public interface FileService {

	List<FileObj> getFileList();

	void storeFile();
}
