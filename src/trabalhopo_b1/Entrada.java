/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopo_b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Aluno
 */
public class Entrada {
    public static String leString(String msg)
    {
        String line = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try
        {
            System.out.println(msg);
            line = br.readLine();
        } catch (Exception e)
        {  }
        return line;
    }

    public static int leInteger(String msg)
    {
        String line = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try
        {
            System.out.println(msg);
            line = br.readLine();
            int retorno = Integer.valueOf(line);
            return retorno;
        } catch (IOException | NumberFormatException e)
        {  return -1; }
    }
}
