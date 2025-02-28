package es.rdboboia.demo.juni5.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import es.rdboboia.demo.juni5.controller.PostmanScriptsDemoDevController;
import es.rdboboia.demo.juni5.dto.MyObjectDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostmanScriptsDemoControllerDevImpl implements PostmanScriptsDemoDevController {

	// "Repository" in memory.
	private final Map<Long, MyObjectDto> myObjectDtoList = new HashMap<>();

	@Override
	public List<MyObjectDto> getObjectList() {
		return this.myObjectDtoList.values().stream().toList();
	}

	@Override
	public MyObjectDto getObject(Long id) {
		return this.myObjectDtoList.get(id);
	}

	@Override
	public MyObjectDto createObject(MyObjectDto myObjectDto) {
		// Save the object in memory.
		Long id = (long) this.myObjectDtoList.size() + 1;
		myObjectDto.setId(id);
		this.myObjectDtoList.put(id, myObjectDto);

		// Return the object.
		return this.myObjectDtoList.get(id);
	}
}
