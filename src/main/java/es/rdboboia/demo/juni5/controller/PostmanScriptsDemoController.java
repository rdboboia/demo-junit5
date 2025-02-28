package es.rdboboia.demo.juni5.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.rdboboia.demo.juni5.dto.MyObjectDto;

@RequestMapping(PostmanScriptsDemoController.BASE_URL)
public interface PostmanScriptsDemoController {

	public static final String BASE_URL = "/postman-scripts-demo";

	public static final String ENDPOINT = "/message";
	public static final String ENDPOINT_WITH_PATH_PARAM = ENDPOINT + "/{id}";

	@GetMapping(path = ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	List<MyObjectDto> getObjectList();

	@GetMapping(path = ENDPOINT_WITH_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	MyObjectDto getObject(Long id);

	@PostMapping(path = ENDPOINT)
	MyObjectDto createObject(MyObjectDto myObjectDto);
}
