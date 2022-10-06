package app_administracion_medicamentos_backend.api.publics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
	
	private String code;
	private T body;
	private String message;

}
