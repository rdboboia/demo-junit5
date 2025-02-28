package es.rdboboia.demo.juni5.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import es.rdboboia.demo.juni5.controller.PostmanScriptsDemoController;
import es.rdboboia.demo.juni5.dto.MyObjectDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostmanScriptsDemoControllerImpl implements PostmanScriptsDemoController {

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
		Long id = (long) this.myObjectDtoList.size();
		return this.myObjectDtoList.put(id, myObjectDto);
	}
}
