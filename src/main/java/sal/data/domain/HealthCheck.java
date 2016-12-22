package sal.data.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class HealthCheck implements Serializable {
	private String msg;
	private Date date;
	
	public HealthCheck(String msg) {
		this.msg = msg;
		this.date = new Date();
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
