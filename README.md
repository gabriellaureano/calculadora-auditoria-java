# 🧮 Auditoria de Cálculos em Java

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

Este projeto é uma aplicação de console desenvolvida para praticar e consolidar os fundamentos da **Programação Orientada a Objetos (POO)** e a manipulação de arquivos em Java. O sistema permite realizar diferentes tipos de cálculos matemáticos e armazena cada operação em um log de auditoria persistente.

## 🚀 Funcionalidades

- **Verificação de Números Primos:** Lógica otimizada para identificar números primos.
- **Análise de Par/Ímpar:** Identificação automática de integridade numérica.
- **Cálculo de Potenciação:** Utilização da biblioteca `Math` para cálculos de expoentes.
- **Sistema de Auditoria:** Cada cálculo gera um registro automático com **Data e Hora** formatadas.
- **Persistência de Dados:** Leitura e escrita em arquivo `.txt`, garantindo que o histórico não seja perdido ao fechar o programa.
- **Tratamento de Erros:** Proteção contra entradas inválidas (letras no lugar de números) e tratamento para arquivos inexistentes.

## 🧠 Conhecimentos Consolidados

Durante o desenvolvimento deste projeto, apliquei conceitos fundamentais de POO para garantir um código organizado e escalável:

- **Uso de Interfaces:** Implementação do contrato `Calculavel`, garantindo que o sistema aceite novos módulos de cálculo de forma plugável e padronizada.
- **Domínio de Polimorfismo:** Capacidade de tratar diferentes lógicas (Primos, Potência, Par/Ímpar) através de uma única referência comum em listas e loops.
- **Encapsulamento:** Organização de dados e comportamentos dentro das classes, utilizando construtores para garantir a integridade e inicialização correta dos objetos.
- **Abstração:** Separação clara entre a definição das operações e suas implementações específicas, facilitando a manutenção do código.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (JDK 17+)
- **Entrada de Dados:** `java.util.Scanner`
- **Manipulação de Arquivos:** `java.io.BufferedWriter` e `java.io.BufferedReader`
- **Data e Hora:** `java.time.LocalDateTime` e `java.time.format.DateTimeFormatter`

## 📋 Como executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git](https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git)
