package tianci.qixiang.henan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/distribution")
public class DistributionController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
		
		return "distribution/index";
	}
	@RequestMapping(value="/current", method = RequestMethod.GET)
	public String current(){
		
		return "distribution/current";
	}
	
	@RequestMapping(value="/config", method = RequestMethod.GET)
	public String config(){
		return "distribution/config";
	}
	@RequestMapping(value="/monitor", method = RequestMethod.GET)
	public String monitor(Model model){
		
		return "distribution/monitor";
	}
	
	
}
