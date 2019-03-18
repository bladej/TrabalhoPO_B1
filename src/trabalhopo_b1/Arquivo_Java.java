/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopo_b1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Arquivo_Java {
    private String nomearquivo;
    private RandomAccessFile arquivo;

    public Arquivo_Java(String nomearquivo)
    {
        try
        {
            arquivo = new RandomAccessFile(nomearquivo, "rw");
        } catch (IOException e)
        { }
    }

    public void truncate(long pos) //desloca eof
    {
        try
        {
            arquivo.setLength(pos * Registro.length());
        } catch (IOException exc)
        { }
    }

    //semelhante ao feof() da linguagem C
    //verifica se o ponteiro esta no <EOF> do arquivo
    public boolean eof()  
    {
        boolean retorno = false;
        try
        {
            if (arquivo.getFilePointer() == arquivo.length())
                retorno = true;                               
        } catch (IOException e)
        { }
        return (retorno);
    }

    //insere um Registro no final do arquivo, passado por parâmetro
    public void inserirRegNoFinal(Registro reg)
    {
        seekArq(filesize());//ultimo byte
        reg.gravaNoArq(arquivo);
    }
    
    public void inserirRegPos(Registro reg, int pos){
        seekArq(pos);
        reg.gravaNoArq(arquivo);
    }

    public void exibirArq()
    {
        int i;
        Registro aux = new Registro();
        seekArq(0);
        i = 0;
        while (!this.eof())
        {
            System.out.println("Posicao " + i);
            aux.leDoArq(arquivo);
            aux.exibirReg();
            i++;
        }
    }

    public void exibirUmRegistro(int pos)
    {
        Registro aux = new Registro();
        seekArq(pos);
        System.out.println("Posicao " + pos);
        aux.leDoArq(arquivo);
        aux.exibirReg();
    }

    public void seekArq(int pos)
    {
        try
        {
            arquivo.seek(pos * Registro.length());
        } catch (IOException e)
        { }
    }

    public void leArq()
    {
        int codigo, idade;
        String nome;
        codigo = Entrada.leInteger("Digite o código");
        while (codigo != 0)
        {
            nome = Entrada.leString("Digite o nome");
            idade = Entrada.leInteger("Digite a idade");
            inserirRegNoFinal(new Registro(codigo, nome, idade));
            codigo = Entrada.leInteger("Digite o código");
        }
    
    
}

    private int filesize() {
        try {
            return (int) (arquivo.length()/Registro.length());
        } catch (IOException ex) {
            Logger.getLogger(Arquivo_Java.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    
    }
    
    public void OrdenarSelecaoDireta(){
        int menorPos=0, menor;
        Registro menorReg, Reg;
        Reg = new Registro();
        menorReg = new Registro();

        int TL = filesize();
        
        for (int i = 0; i < TL-1; i++) {
            seekArq(i);
            menorReg.leDoArq(arquivo);
            menor = menorReg.getCodigo();
            menorPos = i;
            for (int j = i+1; j < TL; j++) {
                seekArq(j);
                Reg.leDoArq(arquivo);
                if(Reg.getCodigo() < menor){
                    menor = Reg.getCodigo();
                    menorPos = j;
                }
            }
                   
            seekArq(menorPos);
            menorReg.leDoArq(arquivo);
            
            seekArq(i);
            Reg.leDoArq(arquivo);

            seekArq(menorPos);
            Reg.gravaNoArq(arquivo);
            
            seekArq(i);
            menorReg.gravaNoArq(arquivo);
        }
    }
    
    public void executa()
    {
        leArq();
        exibirArq();
        
    }

}
