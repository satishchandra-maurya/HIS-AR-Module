package in.satish.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.satish.binding.CitizenData;
import in.satish.entity.CitizenApp;
import in.satish.repository.CitizenAppRepo;

@Service
public class CitizenAppServiceImpl implements CitizenAppService{
 
	@Autowired
	private CitizenAppRepo repo;
	
	@Override
	public Integer createApplication(CitizenData app) {
		
		String apiUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> resEntity = rt.getForEntity(apiUrl, String.class, app.getSsn());
		String stateName = resEntity.getBody();
		
		if("New Jersey".equals(stateName))
		{
			CitizenApp entity = new CitizenApp();
			BeanUtils.copyProperties(app, entity);
			entity.setStateName(stateName);
			repo.save(entity);
			return entity.getAppId();
		}
		
		return 0;
	}

}
