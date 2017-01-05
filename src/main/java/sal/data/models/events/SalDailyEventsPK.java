package sal.data.models.events;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SalDailyEventsPK implements Serializable {
	private String dataSource;
	private String env;
	private String eventType;
	private Date timeFrame;
	
	public SalDailyEventsPK() {
		
	}
	
	public SalDailyEventsPK(String dataSource, String env, String eventType, Date timeFrame) {
		this.dataSource = dataSource;
		this.env = env;
		this.eventType = eventType;
		this.timeFrame = timeFrame;
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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(Date timeFrame) {
		this.timeFrame = timeFrame;
	}
}

