package sal.data.models.events;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SalDailyEventsDao extends CrudRepository<SalDailyEvents, Long> {

	@Query("from SalDailyEvents WHERE DATE(last_seen) = CURDATE()")
	public Iterable<SalDailyEvents> today();
	
	@Query(value = "SELECT sde.eventType, SUM(sde.eventCount) as totalCount FROM SalDailyEvents sde WHERE data_source = :ds and env= :env GROUP BY sde.eventType")
	public List<Object[]> eventCountByDataSourceByEnv(@Param("ds") String ds, @Param("env") String env);
}
