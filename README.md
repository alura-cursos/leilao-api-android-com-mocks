## API de leilões públicos

Essa é uma aplicação web em Spring Boot destinada ao curso de testes no Android com Mocks. O objetivo dela é permitir o cadastro de leilões e manter os dados de lances. O projeto foi desenvolvido com base no Gradle utilizando Kotlin e Java 8.

## Como importar e modificar o código

> Para modificar o código, recomendo que utilize o IntelliJ (pode ser o Community), pois ele já vem com o plugin do Gradle por padrão. Fique à vontade em usar sua ferramenta preferida, certifique-se que ela dê suporte ao Gradle. Evite o uso do Gradle instalado no seu computador, utilize o [Gradle Wrapper](https://medium.com/collabcode/gradle-nativo-ou-wrapper-saiba-qual-utilizar-e029058bf80) para que mantenha a mesma versão do build.

Ao clonar o projeto, você pode importá-lo como um projeto Gradle, siga as orientações da IDE até que o build seja finalizado. Todo código fonte vai estar acessível no diretório **src/main/kotlin**.

## Executando o projeto

O projeto pode ser executado a partir da função `main` do arquivo `src/main/kotlin/br/com/alura/leilaoapi/LeilaoApiApplication.kt`, por padrão, ela ficará disponível na porta 8080 sendo acessível via endereço http://localhost:8080/.

Caso tenha interesse em modificar a porta, vá no arquivo **/src/main/resources/application.yml** e altere o valor da propriedade `server.port`, segue o exemplo:

```yml
server:
  port: ${port:8081}
```

Nessa amostra a execução do servidor vai ser feita na porta 8081.

## Mapeamentos disponíveis

Por padrão, o projeto provê três mapeamentos.

### Páginas HTML

- **GET** `/` -> Essa é a rota inicial na qual é apresentada a página que permite cadastrar os leilões e listá-los com os seus IDs.

### API REST

- **GET** `/leilao` -> Devolve a lista com todos os leilões cadastrados e seus lances.

- **PUT** `/leilao/{id}/lance` -> Permite a adição de novos lances com base no id do leilão existente, recebendo o lance via corpo da requisição. O objeto para o lance pode ser enviado com a seguinte estrutura:

```json
{
	"usuario" : {
		"id": 1,
		"nome" : "Alex"
	},
	"valor" : 1520.0
}
```

Para mais detalhes de implementação, consulte o código dos controllers da aplicação.

## Dúvidas sobre o Spring Boot

Caso não conheça o mínimo do Spring Boot com Kotlin e tenha interesse em aprender, sugiro os conteúdos que mantenho para a comunidade que estão acessíveis nestes links:

- [CRUD API parte 1](https://medium.com/collabcode/implementando-uma-crud-api-no-spring-boot-com-kotlin-parte-1-c6e281d0f8f8);

- [CRUD API parte 2](https://medium.com/collabcode/implementando-uma-crud-api-no-spring-boot-com-kotlin-parte-2-3346312dc956);

- [Boas práticas para API com Spring](https://medium.com/collabcode/boas-pr%C3%A1ticas-para-a-implementa%C3%A7%C3%A3o-de-apis-no-spring-boot-com-kotlin-6e77aac110da).
