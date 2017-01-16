package sal.data.services;

import org.springframework.stereotype.Service;

import sal.data.domain.OneTimeLoad;

@Service
public class LoadXXXServices {
	
	public String oneTimePush(OneTimeLoad oneTimeLoad) {
		
		System.out.println("DS : " + oneTimeLoad.getDataSource());
		System.out.println("ENV : " + oneTimeLoad.getEnv());
		System.out.println("FROM : " + oneTimeLoad.getFromDate());
		System.out.println("TO : " + oneTimeLoad.getToDate());
		for (String key : oneTimeLoad.getSelectedEvents().keySet()) {
			System.out.println(key + ":" + oneTimeLoad.getSelectedEvents().get(key));
		}
		
		return "process-tag";
	}

}
