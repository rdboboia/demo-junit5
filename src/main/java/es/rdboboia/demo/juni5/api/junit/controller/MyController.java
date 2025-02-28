package es.rdboboia.demo.juni5.api.junit.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.rdboboia.demo.juni5.api.junit.dto.MessageDto;

@RequestMapping(MyController.BASE_URL)
public interface MyController {

	public static final String BASE_URL = "/controller";

	public static final String ENDPOINT = "/message";
	public static final String ENDPOINT_WITH_PATH_PARAM = ENDPOINT + "/{isSpanish}";

	@GetMapping(path = ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	MessageDto getMessage(@RequestParam Boolean isSpanish);

	@GetMapping(path = ENDPOINT_WITH_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	MessageDto getMessageWithPathVariable(@PathVariable Boolean isSpanish);
}
