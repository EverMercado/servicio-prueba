package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.controller.ClienteController;
import com.example.domain.Resultado;
import com.example.service.ClienteService;

@SpringBootTest
public class ClienteControllerTest {
	
	@Autowired 
	ClienteController clienteController;
	
	@Autowired
	ClienteService clienteService;
	
	ClienteService serviceMock = Mockito.mock(ClienteService.class);
	
	@BeforeEach
	void setup() {
		Resultado mockResultado = new Resultado();
		String[] cadenaMock = new String[3];
		cadenaMock[0] = "1"+"|"+"1"+"|"+"emailprueba@prueba.com";
		cadenaMock[1] = "2"+"|"+"2"+"|"+"emailprueba2@prueba.com";
		cadenaMock[2] = "3"+"|"+"3"+"|"+"emailprueba3@prueba.com";
		
		mockResultado.setData(Arrays.asList(cadenaMock));
		
		Mockito.when(serviceMock.postData()).thenReturn(mockResultado);

	}
	
	
	@Test
	void postData() {
		Resultado resultado;
		
		resultado = serviceMock.postData();

		assertThat(resultado).isNotNull();

	}
	
}
