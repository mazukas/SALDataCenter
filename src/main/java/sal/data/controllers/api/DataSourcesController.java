package sal.data.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.models.datasources.DataSource;
import sal.data.models.datasources.DataSourcesDao;

import com.google.common.collect.Lists;

@RestController
public class DataSourcesController extends BaseApiController {
    
	@Autowired
	private DataSourcesDao datasourceDao;
	
    @RequestMapping("/datasources")
    public List<DataSource> get() {
		return Lists.newArrayList(datasourceDao.findAllByOrderByNameAsc());
    }
	
    @RequestMapping("/datasources/added/today")
    public List<DataSource> added() {
		return Lists.newArrayList(datasourceDao.getAllNewDataSources());
    }
    
}
