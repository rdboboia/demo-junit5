package es.rdboboia.demo.juni5.controller.junit.impl;

import org.springframework.web.bind.annotation.RestController;

import es.rdboboia.demo.juni5.controller.junit.MyController;
import es.rdboboia.demo.juni5.controller.junit.dto.MessageDto;
import es.rdboboia.demo.juni5.service.MyService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MyControllerImpl implements MyController {

	private final MyService myService;

	@Override
	public MessageDto getMessage(Boolean isSpanish) {
		String hello = this.myService.getHello(isSpanish);
		return new MessageDto(hello);
	}

	@Override
	public MessageDto getMessageWithPathVariable(Boolean isSpanish) {
		String hello = this.myService.getGenericHello(isSpanish);
		return new MessageDto(hello);
	}

}
