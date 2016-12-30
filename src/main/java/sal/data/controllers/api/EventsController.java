package sal.data.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.models.events.SalDailyEvents;
import sal.data.models.events.SalDailyEventsDao;

import com.google.common.collect.Lists;

@RestController
public class EventsController extends BaseApiController {
    
	@Autowired
	private SalDailyEventsDao dailyEvents;
	
    @RequestMapping("/events/today")
    public List<SalDailyEvents> today() {
    	return Lists.newArrayList(dailyEvents.today());
    }
    
}
