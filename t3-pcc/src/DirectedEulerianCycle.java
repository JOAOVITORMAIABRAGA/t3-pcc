import java.util.*;

public class DirectedEulerianCycle {
    private Stack<Integer> cycle;   // circuito euleriano
    private double totalCost;       // custo total

    public DirectedEulerianCycle(Digraph G) {
        cycle = new Stack<>();
        totalCost = 0.0;

        // Verifica se o grafo está balanceado
        boolean balanceado = true;
        for (int v = 0; v < G.V(); v++) {
            if (G.inDegree(v) != G.outDegree(v)) {
                balanceado = false;
                break;
            }
        }

        if (!balanceado) {
            throw new IllegalArgumentException("O grafo não está balanceado!");
        } else {
            System.out.println("O grafo está balanceado. É possível encontrar um circuito euleriano.");
        }

        // Copia listas de adjacência para manipular
        Map<Integer, Deque<DirectedEdge>> localAdj = new HashMap<>();
        for (int v = 0; v < G.V(); v++) {
            Deque<DirectedEdge> edges = new ArrayDeque<>();
            for (DirectedEdge e : G.adj(v)) {
                edges.add(e);
            }
            localAdj.put(v, edges);
        }

        // Escolhe vértice inicial (primeiro com aresta de saída)
        int start = 0;
        for (int v = 0; v < G.V(); v++) {
            if (G.outDegree(v) > 0) {
                start = v;
                break;
            }
        }

        // Algoritmo de Hierholzer
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (!localAdj.get(v).isEmpty()) {
                DirectedEdge e = localAdj.get(v).poll(); // pega próxima aresta
                stack.push(e.to());
                totalCost += e.weight(); // acumula custo
            } else {
                cycle.push(stack.pop());
            }
        }
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public double cost() {
        return totalCost;
    }

    public boolean hasCycle() {
        return !cycle.isEmpty();
    }
}
