## Projeto de integração dos microservicos da Casa de Cambio

## Resumo do Projeto
Uma casa de câmbio que opera BitCoins está buscando inovar os seus sistemas e migrar seus serviços para uma cloud e com isso está precisando recriar uma série  de serviços utilizando uma arquitetura de micro-serviços.

## Instruções para execução

1. Clonar os projetos: 
  - casa-de-cambio-cadastro-microservice: https://github.com/crllm/casa-de-cambio-cadastro-microservice
  - casa-de-cambio-transferencia-microservice: https://github.com/crllm/casa-de-cambio-transferencia-microservice
  - casa-de-cambio-bitcoin-microservice: https://github.com/crllm/casa-de-cambio-bitcoin-microservice
  - casa-de-cambio: https://github.com/crllm/casa-de-cambio

2. Após clonar os projetos, importe-os como maven project;

3. No projeto casa-de-cambio há uma collection do postman para execução dos testes;

4. Os testes na aplicação poderão ser realizados no postman(pela collection) ou pelo link do swagger: http://localhost:8083/swagger-ui.html

5. Antes dos testes, executar todos os microsserviços(item 1);

----------------------------------------------------------------------------------------------------------------------------------
## Informações a respeito das aplicações

## Tecnologias utilizadas
1. Springboot
2. Webclient
3. Junit
4. Spring gateway
5. Maven
6. Mysql

## Como realizar novas atualizações da aplicação
Criar uma pipeline de CI/CD para realização dos testes e deploy em um serviço de Kubernete, como o EKS

## Arquitetura do projeto
O projeto foi desenvolvido em microsserviços, os packages dos microsserviços foram dividos em MVC, onde a comunicação entre cada serviço esta sendo feita no projeto principal casa-de-cambio.

## Conexão entre microsserviços
A conexão foi feita por um microsserviço gateway, que faz requisições HTTP para os microsserviços utilizando o WebClient e consolida as informações

## Escalabilidade e Performance
Para evitar a perda de performance da aplicação, deveriamos deployar o serviço no docker e/ou cloud.
