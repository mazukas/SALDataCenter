package sal.data.models.datasources;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DataSourcePK implements Serializable {
	protected String name;
	protected String env;

	public DataSourcePK() {

	}

	public DataSourcePK(String name, String env) {
		this.name = name;
		this.env = env;
	}
}