# 🚚 Trabalho 3 – Problema do Carteiro Chinês

## 🎥 Demonstração em vídeo

Confira a execução completa do projeto, incluindo explicação teórica, eulerização e funcionamento do algoritmo:

👉 https://youtu.be/mHcHGJgAho8

## 🎯 Objetivo

Este trabalho tem como objetivo aplicar conceitos fundamentais de grafos no contexto do Problema do Carteiro Chinês, incluindo:

- Modelagem de dígrafos ponderados
- Cálculo de grau de entrada e grau de saída
- Identificação de vértices desbalanceados
- Eulerização manual de uma instância
- Implementação do método de Hierholzer para encontrar um circuito euleriano
- Cálculo do custo total do percurso

## 🧠 Contexto do Problema

O Problema do Carteiro Chinês consiste em encontrar o menor caminho que percorre todas as arestas de um grafo pelo menos uma vez.

Para que exista um circuito euleriano em um dígrafo, é necessário que:

- Todo vértice tenha grau de entrada igual ao grau de saída

Caso contrário, é necessário realizar uma eulerização, adicionando arestas ao grafo original.

## 🔍 Análise da Instância

A partir da figura fornecida pela disciplina, o grafo foi reconstruído no arquivo:

📄 `dados/entrada_original.txt`

Cada linha representa uma aresta no formato:

```
origem destino peso
```

## ⚖️ Identificação dos vértices desbalanceados

Após análise dos graus, foram identificados os seguintes vértices desbalanceados:

- Vértice 1 → grau de saída maior que o de entrada
- Vértice 3 → grau de entrada maior que o de saída

## 🛠️ Eulerização do Grafo

Para balancear o grafo, foram adicionadas manualmente as seguintes arestas:

- 1 → 4 com peso 1.0
- 4 → 3 com peso 1.0

Essas inserções foram feitas com o objetivo de:

- equilibrar os graus de entrada e saída
- garantir a existência de um circuito euleriano

O grafo final pode ser encontrado em:

📄 `dados/entrada_eulerizada.txt`

## 🧩 Estrutura do Projeto

```
t3-pcc/
├── README.md
├── T3.md
├── T3_ava.html
├── dados/
│   ├── entrada_original.txt
│   └── entrada_eulerizada.txt
└── src/
    ├── Main.java
    ├── DirectedEdge.java 
    ├── Digraph.java 
    └── DirectedEulerianCycle.java
```

## ⚙️ Implementação

### 📌 Representação do Grafo

- `Digraph.java`: estrutura do dígrafo com lista de adjacência
- `DirectedEdge.java`: representação das arestas com peso

### 📌 Método de Hierholzer

Implementado em: `DirectedEulerianCycle.java`

O algoritmo:

- Verifica se o grafo está balanceado
- Seleciona um vértice inicial
- Percorre as arestas utilizando uma pilha
- Constrói o circuito euleriano
- Calcula o custo total somando os pesos das arestas

## ▶️ Execução do Programa

Durante a execução, o programa:

- Exibe os graus dos vértices antes do balanceamento
- Aplica as arestas adicionadas manualmente
- Exibe os graus após o balanceamento
- Executa o algoritmo de Hierholzer
- Imprime:
  - o circuito euleriano
  - o custo total do percurso

## 💻 Exemplo de saída

**Antes do balanceamento:**
```
Vértice 1 | outDegree=2 | inDegree=1
...
```

**Depois do balanceamento:**
```
Vértice 1 | outDegree=2 | inDegree=2
...
```

**Circuito Euleriano:**
```
0 1 4 3 0 ...
```

**Custo total:** X.0

## 📦 Dependências

- Java JDK 8 ou superior
- Biblioteca Algs4
- 🔗 https://algs4.cs.princeton.edu/code/

## 🖥️ Como Compilar e Executar

### ✔️ Windows

No diretório src/:

```bash
javac -cp .;..\algs4.jar *.java
```

Execução:

```bash
java -cp .;..\algs4.jar Main
```

## ✅ Conclusão

Após a análise e eulerização:

- O grafo foi corretamente balanceado
- Todos os vértices passaram a ter:
  - grau de entrada = grau de saída
- Foi possível aplicar o método de Hierholzer
- O programa encontrou um circuito euleriano válido
- O custo total do percurso foi calculado com sucesso

## 💡 Observações finais

- A etapa manual de eulerização é essencial para garantir a validade da solução
- O algoritmo de Hierholzer se mostrou eficiente para encontrar o circuito
- A abordagem pode ser expandida para grafos maiores e mais complexos
