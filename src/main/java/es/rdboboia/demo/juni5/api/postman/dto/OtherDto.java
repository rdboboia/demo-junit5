package es.rdboboia.demo.juni5.api.postman.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtherDto {
	private Long id;
	private String desc;
	private String name;
}
