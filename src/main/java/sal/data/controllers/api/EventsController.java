package sal.data.controllers.api;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sal.data.domain.graph.PieGraphElement;
import sal.data.domain.graph.ZoomGraphElement;
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
    
    @RequestMapping("/events/today/chart/pie")
    public JSONObject todayPieChart() {
    	PieGraphElement pge = new PieGraphElement(	null, 
    												null, 
    												dailyEvents.allEventCountsToday());
    	
    	return pge.createJson();
    }
    
    @RequestMapping("/events/chart/pie/{dataSource}/{env}")
    public JSONObject getEventsChartPie(@PathVariable(value="dataSource") String dataSource, @PathVariable(value="env")String env, @RequestParam("from") long from, @RequestParam("to") long to) {
    	PieGraphElement pge = new PieGraphElement(	dataSource, 
    												env, 
    												new Date(from), 
    												new Date(to), 
    												dailyEvents.eventCountByDataSourceByEnv(dataSource, env, new Date(from), new Date(to)));
    	
    	return pge.createJson();
    }
    
    @RequestMapping("/events/chart/zoom/{dataSource}/{env}")
    public JSONObject getEventsChartZoom(@PathVariable(value="dataSource") String dataSource, @PathVariable(value="env")String env, @RequestParam("from") long from, @RequestParam("to") long to) {
    	ZoomGraphElement zge = new ZoomGraphElement(	dataSource, 
    													env, 
    													new Date(from), 
    													new Date(to), 
    													"|",
    													dailyEvents.eventCountByDataSourceForZoomGraph(dataSource, env, new Date(from), new Date(to)));
    	

    	return zge.createJson();
    }
    
    @RequestMapping("/events/chart/pie")
    public JSONObject getEventsChartPie(@RequestParam("from") long from, @RequestParam("to") long to) {
    	PieGraphElement pge = new PieGraphElement(	new Date(from), 
    												new Date(to), 
    												dailyEvents.eventCountByEnv(new Date(from), new Date(to)));
    	
    	return pge.createJson();
    }
    
    @RequestMapping("/events/chart/zoom")
    public JSONObject getEventsChartZoom(@RequestParam("from") long from, @RequestParam("to") long to) {
    	
    	ZoomGraphElement zge = new ZoomGraphElement(	new Date(from), 
    													new Date(to), 
    													"|",
    													dailyEvents.eventCountByEnvZoom(new Date(from), new Date(to)));
    	

    	return zge.createJson();
    }
    
    @RequestMapping("/events/all/chart/pie")
    public JSONObject getAllEventsChartPie(@RequestParam("from") long from, @RequestParam("to") long to) {
    	PieGraphElement pge = new PieGraphElement(	new Date(from), 
    												new Date(to), 
    												dailyEvents.allEventCountByEnv(new Date(from), new Date(to)));
    	
    	return pge.createJson();
    }
}
