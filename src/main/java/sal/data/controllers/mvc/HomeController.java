package sal.data.controllers.mvc;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "home";
	}
    
}
