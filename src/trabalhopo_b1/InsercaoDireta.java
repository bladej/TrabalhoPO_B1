/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopo_b1;

/**
 *
 * @author helio
 */
public class InsercaoDireta {
    
    private int numeros[];
    private int TF;

    public InsercaoDireta(int TF) {
        this.TF = TF;
        this.numeros = new int[TF];
        for (int i = 0; i < TF; i++) {
            this.numeros[i] = (int)(Math.random()*100);
            
        }
    }
    
    public void exibir(){
        
        for (int i = 0; i < TF; i++) {
            System.out.print(numeros[i]+" ");
            if((i+1)%50 == 0)
                System.out.println(" ");
        }
        System.out.println(" ");
    }
    
    public void ordenar(){
        int aux, pos, i;
          
        
        if(TF > 1){
            pos=1;
            
            while(pos < TF){
               aux=numeros[pos];
               i=pos-1;
               while(i >= 0 && aux < numeros[i]){
                   numeros[i+1] = numeros[i];    
                   i--;
               }
               numeros[i+1]=aux;
               pos++;
            }
        }
    }
    
    
}
