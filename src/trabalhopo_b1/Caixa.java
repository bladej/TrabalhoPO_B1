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
public class Caixa {
    
    private Caixa ant;
    private int info;
    private Caixa prox;

    public Caixa(int info) {
        this.info = info;
        this.ant = null;
        this.prox = null;
    }

    public Caixa getAnt() {
        return ant;
    }

    public void setAnt(Caixa ant) {
        this.ant = ant;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Caixa getProx() {
        return prox;
    }

    public void setProx(Caixa prox) {
        this.prox = prox;
    }
           
    
    
}
