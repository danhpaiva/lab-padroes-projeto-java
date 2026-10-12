# Explorando Padrões de Projetos na Prática com Java 🚀

Repositório estruturado para demonstrar a aplicação prática de **Padrões de Projeto (Design Patterns)** 
<br>utilizando **Java puro**, desenvolvido como evolução do Lab da Digital Innovation One (DIO).

## 🎯 Sobre o Desafio
O objetivo deste projeto é consolidar conceitos fundamentais de arquitetura de software e design de código, <br>aplicando padrões clássicos da Gang of Four (GoF) e evoluindo a arquitetura inicial para cenários mais robustos, <br>testáveis e aderentes ao mercado de desenvolvimento back-end.

---

## 🛠️ Padrões de Projeto Implementados

### 1. **Singleton**
Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso para ela. Foram exploradas três abordagens:
* **Singleton Lazy:** Instanciação tardia (apenas no primeiro uso).
* **Singleton Eager:** Instanciação antecipada (carregada no carregamento da classe).
* **Singleton Lazy Holder:** Abordagem thread-safe altamente eficiente que utiliza uma classe interna estática para otimizar o consumo de memória e concorrência.

### 2. **Strategy**
Permite definir uma família de algoritmos, encapsular cada um deles e torná-los intercambiáveis. No projeto, é utilizado para gerenciar diferentes comportamentos de movimentação de um robô (`Normal`, `Defensivo` e `Agressivo`).

### 3. **Facade** *(Evoluído)*
Fornece uma interface unificada para um conjunto de interfaces em um subsistema, simplificando a sua utilização. 
* **Evoluções aplicadas:** 
  * Refatorado para utilizar **Injeção de Dependências** via construtor e interfaces (`ICepService` e `ICrmService`), eliminando o acoplamento estático rígido.
  * Inclusão de validações de entrada (tratamento de dados nulos e formatação de CEP).
  * Substituição de saídas de console simples (`System.out.println`) por logs estruturados (`java.util.logging.Logger`).

---

## 📁 Estrutura do Projeto

```text
src/
├── one/digitalinnovation/gof/
│   ├── facade/
│   │   └── Facade.java
│   ├── singleton/
│   │   ├── SingletonEager.java
│   │   ├── SingletonLazy.java
│   │   └── SingletonLazyHolder.java
│   ├── strategy/
│   │   ├── Comportamento.java
│   │   ├── ComportamentoAgressivo.java
│   │   ├── ComportamentoDefensivo.java
│   │   ├── ComportamentoNormal.java
│   │   └── Robo.java
│   └── Test.java
└── subsistema1/
│   └── crm/
│       ├── CrmService.java
│       └── ICrmService.java
└── subsistema2/
    └── cep/
        ├── CepApi.java
        └── ICepService.java
```

### 🚀 Como Executar o Projeto
Certifique-se de ter o JDK 17 ou superior instalado em sua máquina.

Clone este repositório:

~~~
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
~~~

Importe o projeto em sua IDE favorita (Eclipse, IntelliJ IDEA ou VS Code).

Execute a classe principal Test.java para visualizar a execução dos padrões integrados.

### 💡 Tecnologias Utilizadas
Java (Puro / Core)

Padrões GoF (Singleton, Strategy, Facade)

Princípios SOLID (Aplicados na refatoração da camada Facade)