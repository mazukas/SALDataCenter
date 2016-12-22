package sal.data.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DataSource implements Serializable {
	private String name;
	private Date firstSeen, lastSeen;
	
	public DataSource(String name, Date firstSeen, Date lastSeen) {
		this.name = name;
		this.firstSeen = firstSeen;
		this.lastSeen = lastSeen;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFirstSeen() {
		return firstSeen;
	}
	public void setFirstSeen(Date firstSeen) {
		this.firstSeen = firstSeen;
	}
	public Date getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}
}
