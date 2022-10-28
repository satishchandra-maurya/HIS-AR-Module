package in.satish.binding;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class CitizenData {

	private String fullName;
					
	private String email;	
	
	private Long phoneNo;
					
	private String gender;				
	
	private Long ssn;
	
	private Date dob;
}
