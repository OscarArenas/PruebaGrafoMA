package modelo;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Oscar Arenas
 */
public class DepthFirstSearch {

    private final boolean[] visitado;
    private final int[] ruta;
    private final int s;
    private IGrafo grafo;

    public DepthFirstSearch(IGrafo grafo, int s) {
        if (grafo == null) {
            throw new IllegalArgumentException();
        }
        this.grafo = grafo;
        this.s = s;

        int n = grafo.cantidadVertices();
        visitado = new boolean[n];
        ruta = new int[n];

        if (grafo.existeVertice(s)) {
            dfs(s);
        }
    }

    private void dfs(int v) {
        visitado[v] = true;
        ArrayList<Integer> vecinos = grafo.adyacentes(v);

        for (int w : vecinos) {
            if (!visitado[w]) {
                ruta[w] = v;
                dfs(w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return grafo.existeVertice(v) && visitado[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = ruta[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
