# Geral
##Desafio tecnico.<br>
A area de negócio que atendemos identificou a necessidade de parametrizar ovalor cobrado para<br>
compra de moedas estrangeiras por segmento de cliente, poishoje cobramos a mesma taxa para todos os clientes.<br> 
Os segmentos que temos hoje são : 
* Varejo 
* Personnalite
* Private
<br> 
####A formula nos passada para calcular o valor total da conversão da moeda estrangeira para Real é a seguinte:

```
X = ( B * Y ) * ( 1 + T ) 

Onde:  
X = valor em Reais  
B = quantidade desejada da moeda estrangeira  
Y = taxa de conversão da moeda estrangeira para Real  
T = taxa parametrizada por segmento
```

###Dado o cenário, necessitamos que sejam construídas as seguintes funcionalidades:

* Tela para cotação da compra de moeda estrangeira pelo cliente
* Tela de parametrização e consulta da taxa cobrada do cliente por segmento

###application.properties OU bootstrap.yml
* Arquivo responsável por centralizar as configurações da aplicação.<br>

### .gitlab-ci.yml
* Arquivo responsável por gerenciar a pipeline do projeto.<br>

### build.gradle
* Arquivo responsável pelo gerenciamento de todas as dependências do projeto.
* Compile o projeto localmente
`$ gradle build`
* Leia mais informacoes sobre o Gradle
*https://gradle.org/install/*

### Artifactory
* Ferramenta utilizada para gerência/armazenamento de artefatos.
*https://www.jfrog.com/confluence/display/RTF/General+Information*

##Conteinerize esta aplicacao
###O comando a seguir usa Gradle :
`$ ./gradlew bootBuildImage`

###Você pode executar o contêiner localmente :
`$ docker run -p 8080:8080 compramoedas:0.0.1-SNAPSHOT`

## Acesse a tela" de visualização das operações da nossa API
*http://localhost:8080/swagger-ui/*
### Tela" para cotação da compra de moeda estrangeira pelo cliente
*http://localhost:8080/swagger-ui/#/cotacao-controller*

### Tela" de parametrização e consulta da taxa cobrada do cliente por segmento.
*http://localhost:8080/swagger-ui/#/parametrizacao-controller*
<br>


