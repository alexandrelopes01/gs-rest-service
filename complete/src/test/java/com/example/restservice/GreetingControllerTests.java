/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	/*é um framework de teste que permite simular as solicitações HTTP e verificar as respostas recebidas do controlador. */

	/*Eu Alexandre como testador do software gs-rest-service desejo que a classe GreetingControllerTeststenha todos os seus métodos comentados com a descrição do objetivo do teste unitário do referido método. */

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
	}

	/*Este é um método de teste que verifica o comportamento do controlador quando nenhum parâmetro é passado na solicitação. Ele usa o método perform do objeto MockMvc para enviar uma solicitação GET para "/greeting" e então verifica se a resposta tem o status HTTP 200 (OK) e se o conteúdo da resposta contém a mensagem "Hello, World!". */
 

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}

	/*Este é outro método de teste que verifica o comportamento do controlador quando um parâmetro "name" é passado na solicitação. Ele também usa o método perform do objeto MockMvc para enviar uma solicitação GET para "/greeting" com o parâmetro "name" definido como "Spring Community". Em seguida, ele verifica se a resposta tem o status HTTP 200 (OK) e se o conteúdo da resposta contém a mensagem "Hello, Spring Community!". */

	/* Esses testes são úteis para garantir que o controlador esteja se comportando conforme o esperado, retornando as mensagens corretas com base nos parâmetros passados na solicitação. Isso ajuda a garantir a qualidade e o funcionamento adequado do aplicativo Spring Boot.*/
}
