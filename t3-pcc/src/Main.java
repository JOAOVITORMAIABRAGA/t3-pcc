public class Main {
    public static void main(String[] args) throws Exception {
        Digraph g = Digraph.fromFile("dados/entrada_exemplo.txt");

        System.out.println("Antes do balanceamento:");
        for (int v = 0; v < g.V(); v++) {
            System.out.println("Vértice " + v +
                " | outDegree=" + g.outDegree(v) +
                " | inDegree=" + g.inDegree(v));
        }

        // Arestas adicionadas manualmente para eulerizar
        g.addEdge(new DirectedEdge(1, 4, 1.0));
        g.addEdge(new DirectedEdge(4, 3, 1.0));

        System.out.println("\nDepois do balanceamento:");
        for (int v = 0; v < g.V(); v++) {
            System.out.println("Vértice " + v +
                " | outDegree=" + g.outDegree(v) +
                " | inDegree=" + g.inDegree(v));
        }

        DirectedEulerianCycle euler = new DirectedEulerianCycle(g);
        System.out.println("\nCircuito Euleriano:");
        for (int v : euler.cycle()) {
            System.out.print(v + " ");
        }
        System.out.println("\nCusto total: " + euler.cost());
    }
}