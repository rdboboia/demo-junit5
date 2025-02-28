package es.rdboboia.demo.juni5.controller.postman.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyObjectDto {
	private Long id;
	private String description;
}
