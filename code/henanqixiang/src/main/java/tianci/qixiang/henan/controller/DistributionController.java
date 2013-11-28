package tianci.qixiang.henan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tianci.qixiang.henan.bean.DestServiceObj;
import tianci.qixiang.henan.service.DestServService;

@Controller
public class DistributionController {
	
	@Autowired
	DestServService destServService;
	
	@RequestMapping(value="/distribution", method = RequestMethod.GET)
	public String index(Model model){
		
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


	
	
	
}
