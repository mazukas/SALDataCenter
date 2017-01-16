package sal.data.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.domain.OneTimeLoad;
import sal.data.services.LoadXXXServices;

@RestController
public class PushToXXXController extends BaseApiController {

	@Autowired
	private LoadXXXServices laodService;
	
	@RequestMapping("/pushToXXX/oneTime")
	public String oneTimePush(@RequestBody OneTimeLoad oneTimeLoad) {
		return laodService.oneTimePush(oneTimeLoad);
	}
}
