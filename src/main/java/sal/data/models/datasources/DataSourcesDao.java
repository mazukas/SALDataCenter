package sal.data.models.datasources;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DataSourcesDao extends CrudRepository<DataSource, Long> {
	
	public Iterable<DataSource> findAllByOrderByNameAsc();
	
	@Query("from DataSource ds WHERE DATE(first_seen) = CURDATE() GROUP BY ds.name")
	public Iterable<DataSource> getAllNewDataSources();

}
