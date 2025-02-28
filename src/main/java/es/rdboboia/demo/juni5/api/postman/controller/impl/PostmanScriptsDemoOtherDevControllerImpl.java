package es.rdboboia.demo.juni5.api.postman.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import es.rdboboia.demo.juni5.api.postman.controller.PostmanScriptsDemoOtherDevController;
import es.rdboboia.demo.juni5.api.postman.dto.OtherDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostmanScriptsDemoOtherDevControllerImpl implements PostmanScriptsDemoOtherDevController {

	@Override
	public List<OtherDto> getOtherList() {
		List<OtherDto> list = new ArrayList<>();

		OtherDto otherDto = OtherDto.builder().build();
		list.add(otherDto);

		OtherDto otherDto2 = OtherDto.builder().id(1L).desc("DESC").name("NAME").build();
		list.add(otherDto2);

		return list;
	}

}
