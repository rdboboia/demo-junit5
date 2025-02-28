package es.rdboboia.demo.juni5.controller.postman.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenDto {
	private String accessToken;
	private Long expiresIn;
}
