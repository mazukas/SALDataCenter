package sal.data.controllers.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.domain.GraphElement;
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
    
    @RequestMapping("/events/all/{dataSource}/{env}")
    public List<GraphElement> prototype(@PathVariable(value="dataSource") String dataSource, @PathVariable(value="env")String env) {
    	List<GraphElement> vals = new ArrayList<GraphElement>();
    	for (Object[] o : dailyEvents.eventCountByDataSourceByEnv(dataSource, env)){
    		vals.add(new GraphElement(o[0].toString(), o[1].toString()));
    	}
    	return vals;
    }
}
