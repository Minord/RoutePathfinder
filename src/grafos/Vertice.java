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
   private String dato;
   private List<Arista> aristasAdyacentes;
   private boolean evaluado;
   private int x;
   private int y;

   public Vertice(String dato, int x, int y)
   {
      this.aristasAdyacentes = new ArrayList<>();
      this.dato = dato;
      this.x = x;
      this.y = y;
   }

   public void setEvaluado(boolean evaluado)
   {
      this.evaluado = evaluado;
   }
   
   public boolean getEvaluado()
   {
      return evaluado;
   }
   
   public void agregarArista(Arista a)
   {
      this.aristasAdyacentes.add(a);
   }
   
   public List<Arista> getAristas()
   {
      return aristasAdyacentes;
   }
   
   public String getDato() {
      return dato;
   }
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
}
