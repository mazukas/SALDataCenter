package sal.data.models.events;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SalDailyEventsDao extends CrudRepository<SalDailyEvents, Long> {

	@Query("from SalDailyEvents WHERE DATE(last_load) = CURDATE()")
	public Iterable<SalDailyEvents> today();
}
