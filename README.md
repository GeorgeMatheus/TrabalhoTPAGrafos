# TrabalhoGrafos

A biblioteca de grafos a ser desenvolvida deve ser capaz de representar e manipular grafos orientados.

## Implementação da representação de grafos: Listas de adjacência

Cada vértice do grafo deve armazenar um valor de tipo genérico. 

### Funcionalidades 

**A classe grafo deve prover métodos que permitam:**

+ Incluir vértices no grafo;

+ Incluir arestas no grafo;

+ Verificar se há ciclos no grafo e retornar true, caso haja ciclo e false caso contrário. Uma forma clássica de se verificar ciclos em grafo é fazer uma pesquisa em profundidade (DFS), verificando se um vértice é visitado mais de uma vez;

+ Fazer ordenação topológica do grafo. Uma ordenação topológica é uma ordenação linear de todos os vértices do grafo, tal que se o grafo contém uma aresta do vértice v1 para um vértice v2, v1 aparecerá antes de v2 na ordenação. Assim, só é possível gerar ordenação topológica em grafos orientados acíclicos.

Para realizar a ordenação topológica desse grafo, um método eficiente é 
empregar uma pesquisa em profundidade (DFS). O algoritmo de ordenação topológica consiste em inserir os vértices no início de uma lista à medida que são concluídos.
Isso resulta em uma ordenação linear dos vértices, onde, se há uma aresta do vértice v1 para o vértice v2, v1 aparecerá antes de v2 na ordenação. Esta técnica é particularmente útil em cenários nos quais é vital estabelecer uma sequência ordenada de eventos.


Link para o relartório:  https://docs.google.com/document/d/1zxiVaxygUfCQvWpLY5ubUX-0PmQnUbE1/edit
