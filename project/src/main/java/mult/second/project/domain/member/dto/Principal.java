package mult.second.project.domain.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mult.second.project.domain.member.domain.Member;

@Data
@NoArgsConstructor
public class Principal {
	
	private String userId;
	private String password;
	private String email;

	public Principal(Member member) {
		this.userId = member.getUserId();
		this.password = member.getPassword();
		this.email = member.getEmail();
	}

	
	
}
