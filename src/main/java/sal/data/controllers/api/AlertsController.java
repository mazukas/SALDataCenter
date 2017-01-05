package sal.data.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import sal.data.models.alerts.Alert;
import sal.data.models.alerts.AlertsDao;

@RestController
public class AlertsController extends BaseApiController {

	@Autowired
	private AlertsDao alertsDao;
	
	@RequestMapping("/alerts")
	public List<Alert> getAll() {
		return Lists.newArrayList(alertsDao.findAll());
	}
}
