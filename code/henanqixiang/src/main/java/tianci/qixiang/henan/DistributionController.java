package tianci.qixiang.henan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DistributionController {
	
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
	
	
}
