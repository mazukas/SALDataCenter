package sal.data.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.models.files.SalDataFile;
import sal.data.models.files.SalDataFileDao;

import com.google.common.collect.Lists;

@RestController
public class FilesController extends BaseApiController {
    
	@Autowired
	private SalDataFileDao salDataFileDao;
	
    @RequestMapping("/files")
    public List<SalDataFile> uploadedFiles() {
    	return Lists.newArrayList(salDataFileDao.findAll());
    }
    
    @RequestMapping("/files/today")
    public List<SalDataFile> today() {
    	return Lists.newArrayList(salDataFileDao.filesProcessedToday());
    }
    
}
