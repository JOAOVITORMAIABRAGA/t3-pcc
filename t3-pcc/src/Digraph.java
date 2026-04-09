import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private final int V; // número de vértices
    private int E;       // número de arestas
    private List<DirectedEdge>[] adj; // lista de adjacência

    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() { return V; }
    public int E() { return E; }

    // Método auxiliar para calcular grau de saída
    public int outDegree(int v) {
        return adj[v].size();
    }

    // Método auxiliar para calcular grau de entrada
    public int inDegree(int v) {
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (DirectedEdge e : adj[i]) {
                if (e.to() == v) count++;
            }
        }
        return count;
    }

    // Leitura do arquivo
    public static Digraph fromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int V = Integer.parseInt(br.readLine().trim());
        int E = Integer.parseInt(br.readLine().trim());
        Digraph g = new Digraph(V);

        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int v = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            double weight = Double.parseDouble(parts[2]);
            g.addEdge(new DirectedEdge(v, w, weight));
        }
        br.close();
        return g;
    }
}
