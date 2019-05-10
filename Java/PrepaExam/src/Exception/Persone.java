/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author mk
 */
public class Persone {
    
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeInvalid{
        if (age<=5) {
            throw new AgeInvalid("Age inferieur a 6");
        }
        this.age = age;
    }

    public Persone(int age) {
        this.age = age;
    }

    public Persone() {
    }

    @Override
    public String toString() {
        return age+""; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
