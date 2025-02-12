package es.rdboboia.demo.juni5.repository;

public interface MessageEsRepository {

	default String getMessage() {
		return "Hola";
	}
}
