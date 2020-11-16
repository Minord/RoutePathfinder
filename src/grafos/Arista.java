/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author criss
 */
public class Arista {
   private Vertice origen;
   private Vertice destino;
   private double peso;
   
   public Arista(Vertice origen, Vertice destino, double peso)
   {
      this.origen = origen;
      this.destino = destino;
      this.peso = peso;
   }
   
   public Vertice getOrigen()
   {
      return origen;
   }

   public Vertice getDestino()
   {
      return destino;
   }

   public void setPeso(double peso)
   {
      this.peso = peso;
   }
   
   public double getPeso()
   {
      return peso;
   }
}
