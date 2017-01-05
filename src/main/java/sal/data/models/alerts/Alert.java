package sal.data.models.alerts;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name = "alerts")
public class Alert implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@NotNull
	@Column(name="title")
	private String title;

	@NotNull
	@Column(name="status")
	private String status;
	
	@NotNull
	@Column(name="recorded")
	private Date recorded;
	
	@Column(name="active")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRecorded() {
		return recorded;
	}

	public void setRecorded(Date recorded) {
		this.recorded = recorded;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}