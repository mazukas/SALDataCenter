package sal.data.models.files;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface SalDataFileDao extends CrudRepository<SalDataFile, Long> {

}
