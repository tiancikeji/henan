package tianci.qixiang.henan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/gis")
public class GisController {

	@RequestMapping(value="/")
	public String index(){
		return "gis/index";
	}
}
