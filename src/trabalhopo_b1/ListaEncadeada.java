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
public class ListaEncadeada {
    
    private Caixa inicio;
    private Caixa fim;

    public ListaEncadeada() {
        this.inicio = null;
        this.fim = null;
    }
    
    // refazer pra lista duplamente encadeada
    public void add(int info){
        Caixa cx = new Caixa(info);
        if(inicio == null)
            inicio = fim = cx;
        else
        {
            cx.setProx(inicio);
            inicio.setAnt(cx);
            inicio = cx;
        }
        
            
    }
    
    public void exibir(){
        Caixa aux = inicio;
        while(aux != null){
            System.out.print(aux.getInfo()+" ");
            aux = aux.getProx();
        }
    }
    
}
