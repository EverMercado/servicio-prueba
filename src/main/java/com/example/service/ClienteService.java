package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.domain.Cliente;
import com.example.domain.Resultado;

@Service
public class ClienteService {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	public Resultado postData(){
		
        Resultado resultado = new Resultado();
		String url = "https://jsonplaceholder.typicode.com/comments";
		
		try {
			ResponseEntity<List<Cliente>> result = restTemplateBuilder.build().
	                exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Cliente>>() {});

	        List<Cliente> clienteList = new ArrayList<>();
	        
	        clienteList.addAll(result.getBody());
	        
	        String[] cadena = new String[clienteList.size()];

	        for (int i = 0; i < clienteList.size(); i++) {
	        	cadena[i] = clienteList.get(i).getPostId()+"|"+clienteList.get(i).getId()+"|"+clienteList.get(i).getEmail();
			}

	        resultado.setData(Arrays.asList(cadena));
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return resultado;
	}
}
