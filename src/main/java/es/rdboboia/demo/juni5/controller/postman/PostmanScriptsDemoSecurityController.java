package es.rdboboia.demo.juni5.controller.postman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.rdboboia.demo.juni5.controller.postman.dto.TokenDto;

@RequestMapping(PostmanScriptsDemoSecurityController.BASE_URL)
public interface PostmanScriptsDemoSecurityController {

	public static final String BASE_URL = "/postman-scripts-demo/security";

	public static final String ENDPOINT = "/get-token";

	@GetMapping(path = ENDPOINT)
	TokenDto getToken();
}
