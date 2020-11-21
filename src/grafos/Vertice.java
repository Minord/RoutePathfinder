/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author criss
 */
public class Vertice {
   private int id;
   private String dato;
   private String type;
   private List<Arista> aristasAdyacentes;
   private float x;
   private float y;
   
   public Vertice(int id, String name, String type, float x, float y) {
        this.aristasAdyacentes = new ArrayList<>();
        this.id = id;
        this.dato = name;
        this.type = type;
        this.x = x;
        this.y = y;
   }
   
   public void agregarArista(Arista a)
   {
      this.aristasAdyacentes.add(a);
   }
   
   public List<Arista> getAristas()
   {
      return aristasAdyacentes;
   }
   
   public int getId() {
      return id;
   }
   
   public String getDato() {
      return dato;
   }
   
   public String getType() {
       return type;
   }

   //Estos getter son para retornar coordenadas en pixeles en pantalla
   public int getX()
   {
      return (int) (x * 3.585) - 3;
   }
   
   public int getY()
   {
      return (int) (y * 3.65) - 55;
   }
   //Estos getters son para retornar coordenadas reales en KM
   public float getXReal(){
       return x;
   }
   public float getYReal(){
       return y;
   }
}
