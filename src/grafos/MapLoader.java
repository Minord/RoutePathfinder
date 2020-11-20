/**
 *
 * @author Orellana
 * 
 * Esta clase tiene como proposito el crear el grafo que corresponda a el mapa
 * de las carreteras y ciudades en el salvador en forma simplificada.
 * 
 * Obteniendo esta informacion del archivo grafoMapa.xml (XML) que
 * contiene las propiedades de las ciudades tales como nombre y sus coordenas
 * tambien contiene un lista de los vertices que componen la carreteras entre ciudades
 * 
 */
package grafos;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MapLoader {
 
    private final String filename;
    Grafo grafoMapa = new Grafo();

    
    public MapLoader(){
        this.filename = "src/Img/grafoMapa.xml";
    }
    
    public MapLoader(String filename){
        this.filename = filename;
    }
    
    public Grafo loadMapaGrafo(){
        try
        {
            File xmlFile = new File(filename);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            //Cargar ciudades y carreteras dentro del grafo
            addNodes(doc);
            addEdges(doc);
        }
        catch (IOException | ParserConfigurationException | SAXException e){
            System.out.println(e.getMessage());
        }

        return grafoMapa;
    }
    
    private void addNodes(Document doc)
    {
        NodeList nodes = doc.getElementsByTagName("nodes");
        for (int i = 0; i < nodes.getLength(); i++){
            Element node = (Element) nodes.item(i);
            
            //Pasar de texto a el tipo indicado
            int ID = Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent());
            String name = node.getElementsByTagName("name").item(0).getTextContent();
            String type = node.getElementsByTagName("type").item(0).getTextContent();
            float x =  Float.parseFloat(node.getElementsByTagName("x").item(0).getTextContent());
            float y = Float.parseFloat(node.getElementsByTagName("y").item(0).getTextContent());
            
            //Convertir a km
            x -= -90.161f;
            y -= 14.667f;
            x *= 110.649f;
            y *= -107.550f;
            
            //Crear vertice que representa una ciudad
            Vertice ver = new Vertice(ID, name, type, x, y);
            //Añadirlo al grafo
            grafoMapa.agregarVertice(ver);
        }
    }
    
    private void addEdges(Document doc)
    {
        NodeList edges = doc.getElementsByTagName("edges");
        for (int i = 0; i < edges.getLength(); i++){
            Element edge = (Element) edges.item(i); 
            
            //Pasar de texto a enteros los identificadores de las ciudades
            int ID1 = Integer.parseInt(edge.getElementsByTagName("origin").item(0).getTextContent());
            int ID2 = Integer.parseInt(edge.getElementsByTagName("destino").item(0).getTextContent());
            
            //Buscar nodos
            Vertice vorigen = grafoMapa.buscarVerticeById(ID1);
            Vertice vdestino = grafoMapa.buscarVerticeById(ID2);
           
            //Crear la lista
            Arista arista = new Arista(vorigen, vdestino);
            
            //Agregar la arista a los nodos involucrados
            grafoMapa.buscarVerticeById(ID1).agregarArista(arista);
            grafoMapa.buscarVerticeById(ID2).agregarArista(arista);
        }
    }

    
}
