package tianci.qixiang.henan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tianci.qixiang.henan.bean.DestServiceObj;
import tianci.qixiang.henan.bean.OtherServerObj;
import tianci.qixiang.henan.service.DestServService;
import tianci.qixiang.henan.service.FileService;
import tianci.qixiang.henan.service.OtherServerService;

@Controller
public class DistributionController {
	
	@Autowired
	DestServService destServService;

	@Autowired
	FileService fileService;

	@Autowired
	OtherServerService otherServerService;

	
	@RequestMapping(value="/distribution", method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("filelist", fileService.getFileList());
		return "distribution/index";
	}
	@RequestMapping(value="/distribution/current", method = RequestMethod.GET)
	public String current(){
		
		return "distribution/current";
	}
	
	@RequestMapping(value="/distribution/config", method = RequestMethod.GET)
	public String config(){
		return "distribution/config";
	}
	@RequestMapping(value="/distribution/monitor", method = RequestMethod.GET)
	public String monitor(Model model){
		
		return "distribution/monitor";
	}

	@RequestMapping(value="/distribution/destform", method = RequestMethod.GET)
	public String destform(Model model, DestServiceObj ds){
		return "distribution/destform";
	}
	
	@RequestMapping(value="/distribution/destlist", method = RequestMethod.GET)
	public String destlist(Model model){
		model.addAttribute("destlist", destServService.getDestList());
		return "distribution/destlist";
	}


	@RequestMapping(value="/distribution/destcreate", method = RequestMethod.POST)
	public String destcreate(Model model, DestServiceObj ds){
		destServService.addDestService(ds);
		return "redirect:/distribution/destlist";
	}

	@RequestMapping(value="/distribution/otherserver", method = RequestMethod.GET)
	public String otherserver(Model model){
		model.addAttribute("ftplist", otherServerService.getOtherServerList());
		return "/distribution/otherserver";
	}

	@RequestMapping(value="/distribution/otherserverform", method = RequestMethod.GET)
	public String otherserverform(Model model){
		return "/distribution/otherserverform";
	}

	@RequestMapping(value="/distribution/otherservercreate", method = RequestMethod.POST)
	public String otherservercreate(Model model, OtherServerObj os){
		otherServerService.addOtherServer(os);
		return "redirect:/distribution/otherserver";
	}

	
	
	
}
