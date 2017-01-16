package sal.data.domain.graph;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("serial")
public class ZoomGraphElement implements Serializable {
	private Date dateStart, dateEnd;
	private final String ds, env, dataSeparator;
	private final List<Object[]> list;
	
	private final List<String> dates = new ArrayList<String>();
	private final Set<String> eventTypes = new HashSet<String>();
	
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
	private long totalEventCount = 0;

	public ZoomGraphElement(Date dateStart, Date dateEnd, String dataSeparator, List<Object[]> list) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.ds = null;
		this.env = null;
		this.dataSeparator = dataSeparator;
		this.list = list;
		
		getDates();
		getEventTypes();
	}
	
	public ZoomGraphElement(String ds, String env, Date dateStart, Date dateEnd, String dataSeparator, List<Object[]> list) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.ds = ds;
		this.env = env;
		this.dataSeparator = dataSeparator;
		this.list = list;
		
		getDates();
		getEventTypes();
	}

	private void getDates() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateStart);
		while (calendar.getTime().before(dateEnd)) {
			dates.add(format.format(calendar.getTime()));
			calendar.add(Calendar.DATE, 1);
		}
		dates.add(format.format(dateEnd));
	}
	
	private void getEventTypes() {
		for (Object[] results : list) {
			eventTypes.add(results[1].toString());
		}
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	
	private String getCategories() {
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateStart);
		StringBuffer sb = null;
		while (calendar.getTime().before(dateEnd)) {
			if (sb == null) {
				sb = new StringBuffer();
				sb.append(format.format(calendar.getTime()));
			} else {
				sb.append(dataSeparator + format.format(calendar.getTime()));
			}
			calendar.add(Calendar.DATE, 1);
		}
		sb.append(dataSeparator + format.format(dateEnd));
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject createDataSet(String eventType) {
		JSONObject ds = new JSONObject();
		ds.put("seriesname", eventType);
		
		StringBuffer sb = null;
		
		for (String d : dates) {
			long count = 0;
			for (Object[] result : list) {
				Timestamp eventDate = (Timestamp) result[0];
				String strDate = format.format(eventDate.getTime());
				
				if (strDate.equals(d) && result[1].equals(eventType)) {
					count = (Long)result[2];
					break;
				}
			}
			if (sb == null) {
				sb = new StringBuffer();
				sb.append(count);
			} else {
				sb.append(dataSeparator + count);
			}
			totalEventCount = totalEventCount + count;
		}
		ds.put("data", sb.toString());
		
		return ds;
	}
	
	@SuppressWarnings({ "unchecked" })
	public JSONObject createJson() {
		JSONObject root = new JSONObject();
		JSONObject chart = new JSONObject();
		if (null == ds) {
			chart.put("caption", "All Events by Environment from " + format.format(dateStart) + " to " + format.format(dateEnd));
		} else {
			chart.put("caption", ds + " (" + env + ") from " + format.format(dateStart) + " to " + format.format(dateEnd));
		}
		
		chart.put("yaxisname", "Event Count");
		chart.put("xaxisname", "Date");
		chart.put("pixelsPerPoint", "0");
		chart.put("pixelsPerLabel", "30");
		chart.put("lineThickness", "1");
		chart.put("compactdatamode", "1");
		chart.put("dataseparator", dataSeparator);
		chart.put("labelHeight", "30");
		chart.put("theme", "zune");
		root.put("chart", chart);
		
		JSONArray categories = new JSONArray();
		JSONObject category = new JSONObject();
		category.put("category", getCategories());
		categories.add(category);
		root.put("categories", categories);
		
		
		JSONArray datasets = new JSONArray();
		for (String eventType : eventTypes) {
			datasets.add(createDataSet(eventType));
		}
		
		root.put("dataset", datasets);
		chart.put("subcaption", "Total # of Events: " + numberFormat.format(totalEventCount));
		
		return root;
	}
}
