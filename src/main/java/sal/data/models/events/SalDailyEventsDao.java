package sal.data.models.events;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SalDailyEventsDao extends CrudRepository<SalDailyEvents, Long> {

	@Query("from SalDailyEvents WHERE DATE(last_seen) = CURDATE()")
	public Iterable<SalDailyEvents> today();
	
	@Query(value="SELECT sde.eventType, sum(sde.eventCount) FROM SalDailyEvents sde WHERE DATE(time_frame) = CURDATE() group BY sde.eventType")
	public List<Object[]> allEventCountsToday();
	
	@Query(value="SELECT sde.eventType, sum(sde.eventCount) FROM SalDailyEvents sde WHERE sde.timeFrame BETWEEN :start AND :end  group BY sde.eventType")
	public List<Object[]> allEventCountByEnv(@Param("start") Date start, @Param("end") Date end);
	
	@Query(value="SELECT sde.env, sum(sde.eventCount) FROM SalDailyEvents sde WHERE sde.timeFrame BETWEEN :start AND :end  group BY sde.env")
	public List<Object[]> eventCountByEnv(@Param("start") Date start, @Param("end") Date end);
	
	@Query(value="SELECT sde.timeFrame, sde.env, sum(sde.eventCount) FROM SalDailyEvents sde WHERE sde.timeFrame BETWEEN :start AND :end group BY sde.timeFrame, sde.env ORDER BY sde.timeFrame")
	public List<Object[]> eventCountByEnvZoom(@Param("start") Date start, @Param("end") Date end);
	
	@Query(value = "SELECT sde.eventType, SUM(sde.eventCount) as totalCount FROM SalDailyEvents sde WHERE data_source = :ds and env= :env and sde.timeFrame BETWEEN :start AND :end GROUP BY sde.eventType")
	public List<Object[]> eventCountByDataSourceByEnv(@Param("ds") String ds, @Param("env") String env, @Param("start") Date start, @Param("end") Date end);
	
	@Query(value="SELECT sde.timeFrame, sde.eventType, sde.eventCount FROM SalDailyEvents sde WHERE data_source = :ds and env= :env and sde.timeFrame BETWEEN :start AND :end ORDER BY sde.eventType, sde.timeFrame")
	public List<Object[]> eventCountByDataSourceForZoomGraph(@Param("ds") String ds, @Param("env") String env, @Param("start") Date start, @Param("end") Date end);
	
}
