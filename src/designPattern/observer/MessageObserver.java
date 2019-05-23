/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPattern.observer;

/**
 *
 * @author USER
 */
public class MessageObserver {

    public static void main(String[] args) {
        
        Bureau b1 = new Bureau(1,"exemple sigle","0123456","beau bureau");
        Bureau b2 = new Bureau(2,"exemple sigle2","0123456","beau bureau");
        
        Utilisateur u1 = new Utilisateur(1,"matr1","nom1","prenom1",1);
        Utilisateur u2 = new Utilisateur(1,"matr2","nom2","prenom2",1);
        
        b1.addObserver(u1);
        b1.addObserver(u2);
        b2.addObserver(u2);
        
        b1.setTel("6543210");
        b2.setTel("6543210");
        
        
        
    }

}
