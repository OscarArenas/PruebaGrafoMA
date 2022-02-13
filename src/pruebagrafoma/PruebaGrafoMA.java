/*
 * Copyright (C) 2019 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pruebagrafoma;

import modelo.BreadthFirstSearch;
import modelo.DepthFirstSearch;
import modelo.GrafoMA;

/**
 *
 * @author Oscar Arenas
 */
public class PruebaGrafoMA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrafoMA grafo = new GrafoMA(6);

        grafo.agregarArista(0, 2);
        grafo.agregarArista(0, 4);
        grafo.agregarArista(0, 5);
        grafo.agregarArista(4, 1);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(3, 5);
        grafo.agregarArista(5, 4);

        System.out.println(grafo);

        System.out.println("DFS:");
        DepthFirstSearch dfs = new DepthFirstSearch(grafo, 3);

        System.out.println("Tiene ruta?: " + dfs.hasPathTo(5));

        Iterable<Integer> path = dfs.pathTo(5);

        for (Integer w : path) {
            System.out.println(w);
        }

        System.out.println("BFS:");
        BreadthFirstSearch bfs = new BreadthFirstSearch(grafo, 3);

        System.out.println("Tiene ruta?: " + dfs.hasPathTo(1));

        path = bfs.pathTo(1);

        for (Integer w : path) {
            System.out.println(w);
        }
    }
}
