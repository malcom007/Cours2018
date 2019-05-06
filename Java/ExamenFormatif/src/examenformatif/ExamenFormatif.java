/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenformatif;

import java.util.*;

/**
 *
 * @author mk
 */
public class ExamenFormatif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            int f, result = 0;

            System.out.println("Entrez un entier");
            f = input.nextInt();

            if (f < 0) {
                throw new NullPointerException();
            }

            
            System.out.println("la fibo (" + f + ") = " + fib(f));
        } catch (NullPointerException e) {
            System.out.println("");
            System.out.println("Donnez une valeur supérieur a 0");
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Entrez chiffre seulement");
        }
    }

    private static int fib(int i) {
        {
            if (i <= 1) {
                return i;
            }
            return fib(i - 1) + fib(i - 2);
        }

    }

}
