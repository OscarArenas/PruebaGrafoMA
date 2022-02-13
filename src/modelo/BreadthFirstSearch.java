package modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Oscar Arenas
 */
public class BreadthFirstSearch {

    private boolean[] visitado;
    private int[] ruta;
    private final int s;
    private IGrafo grafo;

    public BreadthFirstSearch(IGrafo grafo, int s) {
        if (grafo == null) {
            throw new IllegalArgumentException();
        }
        this.grafo = grafo;
        this.s = s;

        visitado = new boolean[grafo.cantidadVertices()];
        ruta = new int[grafo.cantidadVertices()];

        if (grafo.existeVertice(s)) {
            bfs(s);
        }
    }

    private void bfs(int s) {
        visitado[s] = true;

        ArrayDeque<Integer> cola = new ArrayDeque<>();
        cola.add(s);

        while (!cola.isEmpty()) {
            int v = cola.remove();
            ArrayList<Integer> vecinos = grafo.adyacentes(v);

            for (int w : vecinos) {
                if (!visitado[w]) {
                    ruta[w] = v;
                    visitado[w] = true;
                    cola.add(w);
                }
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
