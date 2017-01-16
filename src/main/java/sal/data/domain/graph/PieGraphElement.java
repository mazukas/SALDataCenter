package sal.data.domain.graph;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PieGraphElement {
	private final String ds, env;
	private final Date startDate, endDate;
	private final List<Object[]> results;
	
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	private long totalEventCount = 0;
	
	public PieGraphElement(Date startDate, Date endDate, List<Object[]> results) {
		this.ds = null;
		this.env = null;
		this.startDate = startDate;
		this.endDate = endDate;
		this.results = results;
	}
	
	public PieGraphElement(String ds, String env, Date startDate, Date endDate, List<Object[]> results) {
		this.ds = ds;
		this.env = env;
		this.startDate = startDate;
		this.endDate = endDate;
		this.results = results;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject createJson() {
		JSONObject root = new JSONObject();
		JSONObject chart = new JSONObject();
		root.put("chart", chart);
		
		if (startDate == null && endDate == null) {
			chart.put("caption", "All Events From Today (" + format.format(new Date()) + ")");
		} else if (null == ds) {
			chart.put("caption", "All Events By Environment from " + format.format(startDate) + " to " + format.format(endDate));
		} else {
			chart.put("caption", ds + " (" + env + ") from " + format.format(startDate) + " to " + format.format(endDate));
		}
		
		chart.put("startingangle", "120");
		chart.put("showlabels", "0");
		chart.put("showlegend", "1");
		chart.put("enablemultislicing", "0");
		chart.put("slicingdistance", "15");
		chart.put("showpercentvalues", "1");
		chart.put("showpercentintooltip", "0");
		if (null == ds) {
			chart.put("plottooltext", "Environment : $label ($datavalue)");
		} else {
			chart.put("plottooltext", "Event Type : $label ($datavalue)");
		}
		
		chart.put("theme", "zune");
		
		JSONArray data = new JSONArray();
		
		for (Object[] r : results) {
			JSONObject d = new JSONObject();
			d.put("label", r[0].toString());
			d.put("value", r[1].toString());
			
			totalEventCount = totalEventCount + new Long(r[1].toString()).longValue();
			data.add(d);
		}
		root.put("data", data);
		
		chart.put("subcaption", "Total # of Events: " + numberFormat.format(totalEventCount));
		
		return root;
	}
}
