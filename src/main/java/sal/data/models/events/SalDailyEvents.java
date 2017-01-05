package sal.data.models.events;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "data_source_daily_events")
@IdClass(SalDailyEventsPK.class)
public class SalDailyEvents implements Serializable {
	
	@Id
	@NotNull
	@Column(name="data_source")
	private String dataSource;
	
	@Id
	@NotNull
	@Column(name="env")
	private String env;
	
	@Id
	@NotNull
	@Column(name="event_type")
	private String eventType;

	@Id
	@NotNull
	@Column(name="time_frame")
	private Date timeFrame;
	
	@NotNull
	@Column(name="last_seen")
	private Date lastSeen;
	
	@NotNull
	@Column(name="event_count")
	private long eventCount;

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

	public Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}

	public long getEventCount() {
		return eventCount;
	}

	public void setEventCount(long eventCount) {
		this.eventCount = eventCount;
	}
}
