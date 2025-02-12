package es.rdboboia.demo.juni5.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import es.rdboboia.demo.juni5.extensions.VerifyNoMoreInteractionsExtension;

@ExtendWith({ MockitoExtension.class, VerifyNoMoreInteractionsExtension.class })
class MessageGenericRepositoryTest {

	@Test
	void getMessageTest() {
		MessageGenericRepository repository = new MessageGenericRepository() {
		};

		String message = repository.getMessage(new String("es"));

		assertEquals("Hola", message);
	}
}
