package es.rdboboia.demo.juni5.controller.postman;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.rdboboia.demo.juni5.controller.postman.dto.MyObjectDto;

@RequestMapping(PostmanScriptsDemoDevController.BASE_URL)
public interface PostmanScriptsDemoDevController {

	public static final String BASE_URL = "my-object-ms-dev/postman-scripts-demo";

	public static final String ENDPOINT = "/my-object";
	public static final String ENDPOINT_WITH_PATH_PARAM = ENDPOINT + "/{id}";

	@GetMapping(path = ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	List<MyObjectDto> getObjectList();

	@GetMapping(path = ENDPOINT_WITH_PATH_PARAM, produces = MediaType.APPLICATION_JSON_VALUE)
	MyObjectDto getObject(@PathVariable Long id);

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = ENDPOINT)
	MyObjectDto createObject(@RequestBody MyObjectDto myObjectDto);
}
