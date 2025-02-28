package es.rdboboia.demo.juni5.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.rdboboia.demo.juni5.extensions.VerifyNoMoreInteractionsExtension;
import es.rdboboia.demo.juni5.repository.MessageEnRepository;
import es.rdboboia.demo.juni5.repository.MessageEsRepository;
import es.rdboboia.demo.juni5.repository.MessageGenericRepository;
import es.rdboboia.demo.juni5.service.impl.MyServiceImpl;

@ExtendWith({ MockitoExtension.class, VerifyNoMoreInteractionsExtension.class })
class MyServiceTest {

	@InjectMocks
	private MyServiceImpl myServiceImpl;

	@Mock
	private MessageEsRepository messageEsRepository;

	@Mock
	private MessageEnRepository messageEnRepository;

	@Mock
	private MessageGenericRepository messageGenericRepository;

	static Stream<Arguments> getHelloIsNotSpanishTestGenerator() {
		return Stream.of(
				// Is Spanish, Expected message
				Arguments.of(Boolean.TRUE, "Hola"),
				// Is NOT Spanish, Expected message
				Arguments.of(Boolean.FALSE, "Hello"));
	}

	@MethodSource("getHelloIsNotSpanishTestGenerator")
	@ParameterizedTest
	void getHelloTest(Boolean isSpanish, String expectedMessage) {
		// Arrange
		if (isSpanish.booleanValue()) {
			when(this.messageEsRepository.getMessage()).thenReturn(expectedMessage);
		} else {
			when(this.messageEnRepository.getMessage()).thenReturn(expectedMessage);
		}

		// Act
		String hello = this.myServiceImpl.getHello(isSpanish);

		// Assert
		assertEquals(expectedMessage, hello);

		// Verify already done with extension.
	}

	@Test
	void getGenericHelloTest() {
		ArgumentCaptor<String> languageCaptor = ArgumentCaptor.forClass(String.class);

		// Arrange
		String expectedMessage = "Hello";
		when(this.messageGenericRepository.getMessage(languageCaptor.capture())).thenReturn(expectedMessage);

		// Act
		String hello = this.myServiceImpl.getGenericHello(Boolean.FALSE);

		// Assert
		assertEquals(expectedMessage, hello);
		assertEquals("en", languageCaptor.getValue());

		// Verify already done with extension.
	}

	@Test
	void doSomethingTest() {
		// Arrange
		doNothing().when(this.messageGenericRepository).doSomething();

		// Act
		assertDoesNotThrow(() -> this.myServiceImpl.doSomething());

		// Assert
		// Verify already done with extension.
	}
}
