package sal.data.models.datasources;

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
@Table(name = "data_sources")
@IdClass(DataSourcePK.class)
public class DataSource implements Serializable {
	
	@Id
	@NotNull
	@Column(name="name")
	private String name;
	
	@Id
	@NotNull
	@Column(name="env")
	private String env;
	
	@NotNull
	@Column(name="first_seen")
	private Date firstLoad;

	@NotNull
	@Column(name="last_seen")
	private Date lastLoad;
	
	public DataSource() {
		
	}
	
	public DataSource(String name, String env, Date first, Date last) {
		this.name = name;
		this.env = env;
		this.firstLoad = first;
		this.lastLoad = last;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public Date getFirstLoad() {
		return firstLoad;
	}

	public void setFirstLoad(Date firstLoad) {
		this.firstLoad = firstLoad;
	}

	public Date getLastLoad() {
		return lastLoad;
	}

	public void setLastLoad(Date lastLoad) {
		this.lastLoad = lastLoad;
	}

}
