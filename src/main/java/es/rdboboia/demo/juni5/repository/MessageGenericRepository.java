package es.rdboboia.demo.juni5.repository;

public interface MessageGenericRepository {

	default String getMessage(String language) {
		if ("es".equals(language)) {
			return "Hola";
		} else {
			return "Hello";
		}
	}

	default void doSomething() {
		System.out.println("Doing something");
	}
}
