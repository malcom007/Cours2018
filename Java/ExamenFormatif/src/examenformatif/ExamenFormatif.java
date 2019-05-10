/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenformatif;

import java.text.ParseException;
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

        //Exercice 1
        try {
            int f, result = 0;

            System.out.println("Entrez un entier");
            f = input.nextInt();                        
            System.out.println("la fibo (" + f + ") = " + fib(f));
        } catch (monException e) {
            System.out.println("");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("");
            System.out.println("Entrez chiffre seulement");
        }

//        Exercice 2
//          List<Integer> maListe = Arrays.asList(-3,8,1,5,8,4,-8,2,4,3);
//          List<Integer> liste = new ArrayList<>();
//          
//          int temp, count=0;
//          
//          Collection maCollection = maListe;
//          
//          while (maCollection.iterator().hasNext()==true) {
//              
//              System.out.println(maCollection);
//            
//        }
//          System.out.println("");
         }     
            
        
          
    

    private static int fib(int i) throws monException{
        {
            if (i<0) {
                throw new monException("Donnez une valeur supérieur a 0");
            }
            if (i == 1) {
                return i;
            }
            return fib(i - 1) + fib(i - 2);
        }

    }

}
