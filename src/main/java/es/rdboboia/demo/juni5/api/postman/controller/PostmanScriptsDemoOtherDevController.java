package es.rdboboia.demo.juni5.api.postman.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.rdboboia.demo.juni5.api.postman.dto.OtherDto;

@RequestMapping(PostmanScriptsDemoOtherDevController.BASE_URL)
public interface PostmanScriptsDemoOtherDevController {

	public static final String BASE_URL = "other-ms-dev/postman-scripts-demo";

	public static final String ENDPOINT = "/other";

	@GetMapping(path = ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	List<OtherDto> getOtherList();
}
