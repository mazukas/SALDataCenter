package sal.data.controllers.api;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sal.data.domain.DataSource;

@RestController
public class DataSourcesController extends BaseApiController {
    
    @RequestMapping("/datasource")
    public DataSource index() {
        return new DataSource("Mock DS", new Date(), new Date());
    }
    
}
