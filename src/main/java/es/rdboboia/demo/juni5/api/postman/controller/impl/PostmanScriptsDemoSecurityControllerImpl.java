package es.rdboboia.demo.juni5.api.postman.controller.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import es.rdboboia.demo.juni5.api.postman.controller.PostmanScriptsDemoSecurityController;
import es.rdboboia.demo.juni5.api.postman.dto.TokenDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostmanScriptsDemoSecurityControllerImpl implements PostmanScriptsDemoSecurityController {

	@Override
	public TokenDto getToken() {
		return TokenDto.builder()
				.accessToken(UUID.randomUUID().toString())
				.expiresIn(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + 60)
				.build();
	}

}
