package tianci.qixiang.henan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tianci.qixiang.henan.service.FileService;

@Controller
public class FtpController {

	@Autowired
	FileService fileService;
	
	@RequestMapping(value = "/ftp/load", method = RequestMethod.GET)  
    public @ResponseBody String load() {
		
		return "success";  
    }  
	
	@RequestMapping(value = "/ftp/store", method = RequestMethod.GET)  
    public @ResponseBody String store(String destname) {
		
		return "success";  
    } 
		
}

