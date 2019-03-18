/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopo_b1;

/**
 *
 * @author heliof
 */
public class TrabalhoPO_B1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaEncadeada lista = new ListaEncadeada();
        lista.add(10);
        lista.add(5);
        lista.add(11);
        lista.add(12);
        lista.add(6);
        
        lista.exibir();
        
        
        Arquivo_Java arq = new Arquivo_Java("teste.dat");
        arq.executa();
        
        arq.OrdenarSelecaoDireta();
        arq.exibirArq();
    }
    
}
