package sal.data.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class OneTimeLoad implements Serializable {
	private String dataSource, env;
	private Date fromDate, toDate;
	private Map<String, Boolean> selectedEvents;
	
	public OneTimeLoad() {
		
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Map<String, Boolean> getSelectedEvents() {
		return selectedEvents;
	}

	public void setSelectedEvents(Map<String, Boolean> selectedEvents) {
		this.selectedEvents = selectedEvents;
	}
}
