package sal.data.models.files;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface SalDataFileDao extends CrudRepository<SalDataFile, Long> {

	@Query("from SalDataFile f WHERE DATE(uploaded) = CURDATE() GROUP BY f.uploaded")
	public Iterable<SalDataFile> filesProcessedToday();

}
