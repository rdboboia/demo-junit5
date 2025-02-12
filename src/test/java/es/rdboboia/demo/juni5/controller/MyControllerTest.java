package es.rdboboia.demo.juni5.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.rdboboia.demo.juni5.dto.MessageDto;
import es.rdboboia.demo.juni5.extensions.VerifyNoMoreInteractionsExtension;
import es.rdboboia.demo.juni5.service.MyService;

@WebMvcTest(MyController.class)
@ExtendWith({ VerifyNoMoreInteractionsExtension.class })
class MyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private MyService myService;

	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@Test
	void getMessageTest() throws Exception {
		// Init
		String expectedResponse = "Hola";
		Boolean isSpanish = Boolean.TRUE;

		// Arrange
		when(this.myService.getHello(isSpanish)).thenReturn(expectedResponse);

		// Act
		String responseContentAsString = this.mockMvc
				.perform(get(MyController.BASE_URL + MyController.ENDPOINT).param("isSpanish", isSpanish.toString()))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		MessageDto response = this.objectMapper.readValue(responseContentAsString, new TypeReference<>() {
		});

		// Assert
		assertEquals(expectedResponse, response.getMessage());
	}

	@Test
	void getMessageWithPathVariable() throws Exception {
		// Init
		String expectedResponse = "Hola";
		Boolean isSpanish = Boolean.TRUE;

		// Arrange
		when(this.myService.getGenericHello(isSpanish)).thenReturn(expectedResponse);

		// Act
		String responseContentAsString = this.mockMvc
				.perform(post(MyController.BASE_URL + MyController.ENDPOINT_WITH_PATH_PARAM, isSpanish))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		MessageDto response = this.objectMapper.readValue(responseContentAsString, new TypeReference<>() {
		});

		// Assert
		assertEquals(expectedResponse, response.getMessage());
	}
}
