/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Orellana
 * 
 * Algoritmo de busqueda del camino mas coorto implementando
 * el uso de ids en lugar de nombres
 */
public class AlgoritmoDijkstra {
    public static Grafo obtenerRuta(Grafo grafo, Vertice origen, Vertice destino)
    {
        //Crear grafo Ruta que es el resultado
        Grafo ruta = new Grafo();
        
        //Crear lista de vertices ya analizados
        Set<Integer> verticesAnalizados = new HashSet<>();
        //Crear un Diccionario de costos para llegar a los vertices desde el origen
        Map<Integer, Float> costos = new HashMap();
        
        int origenId = origen.getId();
        int destinoId = destino.getId();
        costos.put(origenId, 0.0f); //Declarar el costo al nodo inicial
        Vertice tempVertice = origen;
        //Mientras no se hayan analizado todos los vertices
        while(verticesAnalizados.size() <= grafo.getListaVertices().size()){
            List<Arista> aristasAdjacentes = tempVertice.getAristas();
            
            for (Arista arista : aristasAdjacentes){
                //Calcular a cual vertice se dirige y cual es su costo
                int segundoVerticeId = arista.getSegundoVertice(tempVertice.getId());
                float costo = (float) arista.getPeso();
                float costoAcumulado = costos.get(tempVertice.getId()) + costo;
                //Si el camino actual es mejor
                if ((!costos.keySet().contains(segundoVerticeId)) || 
                    costoAcumulado < costos.get(segundoVerticeId)){
                    //Actualiza el costo a uno mas eficiente
                    costos.put(segundoVerticeId, costoAcumulado);
                }
            }
            //Marcar el vertice actual como completamente analizado
            verticesAnalizados.add(tempVertice.getId());
            
            //Evaluar el siguiente nodo a analizar
            //Que sera el que no este analizado
            //Y tenga el menor costo
            float minCost = Integer.MAX_VALUE;
            int minCostID = -1;
            for(int verticeId : costos.keySet()){
                if(!verticesAnalizados.contains(verticeId)){
                    float costo = costos.get(verticeId);
                    if (minCost >= costo){
                        minCost = costo;
                        minCostID = verticeId;
                    }
                }
            }
            if(minCostID == -1){
                break;
            }
            tempVertice = grafo.buscarVerticeById(minCostID);
        }

        //Segundo bucle para reconstruir el camino
        ruta.agregarVertice(new Vertice(destino.getId(), destino.getDato(),
                                        destino.getType(), destino.getXReal(), destino.getYReal()));
        tempVertice = destino;
        boolean rutaCostruida = false;
        while(!rutaCostruida){
            List<Arista> aristasAdjacentes = tempVertice.getAristas();
            float costoActual = costos.get(tempVertice.getId());
            for(Arista arista : aristasAdjacentes){
                int segundoVerticeId = arista.getSegundoVertice(tempVertice.getId());
                float costo = (float) arista.getPeso();
                //Revizar si el vertice coincide
                if(Math.abs(costos.get(segundoVerticeId) - (costoActual - costo)) <= 0.01){
                    Vertice aux = grafo.buscarVerticeById(segundoVerticeId);
                    Vertice verticePrevio = new Vertice(aux.getId(), aux.getDato(), aux.getType(),
                                                        aux.getXReal(), aux.getYReal());
                    ruta.agregarVertice(verticePrevio);
                    //Crear y agregar nueva arista al grafo.
                    Arista nuevaArista = new Arista(verticePrevio,
                                                    ruta.buscarVerticeById(tempVertice.getId()));
                    ruta.buscarVerticeById(segundoVerticeId).agregarArista(nuevaArista);
                    ruta.buscarVerticeById(tempVertice.getId()).agregarArista(nuevaArista);
                    //Actualizar vertice temporal
                    tempVertice = aux;
                    //Ya se encontro el nodo correcto no es nesesario iterar mas
                    break; 
                }
            }
            if(tempVertice.getId() == origenId){
                rutaCostruida = true;
            }
        }
        return ruta;
    }
}
