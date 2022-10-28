package in.satish.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.satish.binding.CitizenData;
import in.satish.service.CitizenAppService;

@RestController
public class AppRegistrationController {

	@Autowired
	private CitizenAppService appService;

	@PostMapping("/app")
	public ResponseEntity<String> createApplication(@RequestBody CitizenData app){
		Integer appId = appService.createApplication(app);
		if(appId > 0) {
			return new ResponseEntity<> ("Application Registration Success With Id :"+appId, HttpStatus.OK);
		}else {
			return new ResponseEntity<> ("Invalid SSN",HttpStatus.BAD_REQUEST);
		}
	}

}

