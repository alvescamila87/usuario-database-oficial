package com.senai.usuario_database_oficial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuarioDatabaseOficialApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioDatabaseOficialApplication.class, args);
	}

	//TODO : 1. Ajustar mensagens de erro em todas as listas, pois ao cadastrar o item, o mesmo já retorna para a lista, entnão não precisa msg;
	//TODO : 2. Ajustar mensagens de {param.erro}, pois estamos utilizando throw exception. Apenas comentar o param erro, pois assim saberemos como usar em projetos futuros sem o throw exception
	//TODO : 3. Adicionar os botões de cadastro de cada item para dentro das listas;
	//TODO : 4. Remover os botões de cadastro de cada item do navbar;
	//TODO : 5. Incluir logo;
	//TODO : 6. Ajustar descrição dto para DTO;
	//TODO : 7. Incluir session security;
	//TODO : 8. Padronizar a entidade completa de usuário para o projeto: Rotas, DTOs, Model; Cuidar como fazer, rever juntos caso for feito!
	//TODO : 9. Finalizar cliente
	//TODO : 10. Finalizar contato e endeço


}
