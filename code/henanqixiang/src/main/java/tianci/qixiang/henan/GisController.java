package tianci.qixiang.henan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GisController {

	@RequestMapping(value="/gis")
	public String index(){
		return "gis/index";
	}
}
