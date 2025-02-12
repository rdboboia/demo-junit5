package es.rdboboia.demo.juni5.service.impl;

import org.springframework.stereotype.Service;

import es.rdboboia.demo.juni5.repository.MessageEnRepository;
import es.rdboboia.demo.juni5.repository.MessageEsRepository;
import es.rdboboia.demo.juni5.repository.MessageGenericRepository;
import es.rdboboia.demo.juni5.service.MyService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MyServiceImpl implements MyService {

	private final MessageEsRepository messageEsRepository;
	private final MessageEnRepository messageEnRepository;
	private final MessageGenericRepository messageGenericRepository;

	@Override
	public String getHello(Boolean isSpanish) {
		if (isSpanish.booleanValue()) {
			return this.messageEsRepository.getMessage();
		} else {
			return this.messageEnRepository.getMessage();
		}
	}

	@Override
	public String getGenericHello(Boolean isSpanish) {
		String language = isSpanish.booleanValue() ? "es" : "en";
		return this.messageGenericRepository.getMessage(language);
	}

	@Override
	public void doSomething() {
		this.messageGenericRepository.doSomething();
	}

}
