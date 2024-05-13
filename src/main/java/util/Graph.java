package util;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Graph<V>{

    // Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();

    /**
     * Añade el vértice `v` al grafo.
     *
     * @param v vértice a añadir.
     * @return `true` si no estaba anteriormente y `false` en caso contrario.
     */
    public boolean addVertex(V v){
        if (adjacencyList.containsKey(v))
            return false;
        adjacencyList.put(v, new HashSet<>());
        return true;
    }

    /**
     * Añade un arco entre los vértices `v1` y `v2` al grafo. En caso de
     * que no exista alguno de los vértices, lo añade también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return `true` si no existía el arco y `false` en caso contrario.
     */
    public boolean addEdge(V v1, V v2){
        addVertex(v1);
        addVertex(v2);
        return adjacencyList.get(v1).add(v2);
    }

    /**
     * Obtiene el conjunto de vértices adyacentes a `v`.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     */
    public Set<V> obtainAdjacents(V v) throws Exception{
        if(adjacencyList.get(v) == null) throw new Exception("Vertice no encontrado");
        Set<V> adjacents = adjacencyList.get(v);
        return adjacents;
    }

    /**
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return `true` si `v` es un vértice del grafo.
     */
    public boolean containsVertex(V v){
        return adjacencyList.containsKey(v);
    }

    /**
     * Método `toString()` reescrito para la clase `Grafo.java`.
     * @return una cadena de caracteres con la lista de adyacencia.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        if (!adjacencyList.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Obtiene, en caso de que exista, el camino más corto entre
     * `v1` y `v2`. En caso contrario, devuelve `null`.
     * 
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto
     * entre `v1` y `v2`
     **/
    public List<V> shortestPath(V v1, V v2){
        Map<V, V> previo = new HashMap<V,V>();
        List<V> caminoMasCorto = new ArrayList<>();
        if (v2.equals(v1) && adjacencyList.containsKey(v2)){
            caminoMasCorto.add(v2);
            return caminoMasCorto;
        }
        Queue<V> cola = new LinkedList<V>();
        cola.add(v1);
        previo.put(v1, null);
        boolean encontrado = false;
        while(!encontrado && !cola.isEmpty()){
            V nodoActual = cola.poll();            
            encontrado = nodoActual.equals(v2);
            Set<V> sucesores =
                adjacencyList.get(nodoActual).stream().
                   filter(x -> !previo.containsKey(x)).
                      collect(Collectors.toSet());
            cola.addAll(sucesores);
            sucesores.forEach(x -> previo.put(x, nodoActual));

        }

        if (previo.get(v2) == null) return caminoMasCorto;

        for(V vertice = v2; vertice != null; vertice = previo.get(vertice)){
            caminoMasCorto.add(vertice);
        }
        Collections.reverse(caminoMasCorto);
        return caminoMasCorto;

    }
}
