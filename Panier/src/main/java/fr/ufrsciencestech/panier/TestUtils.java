/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;


import java.awt.Component;
import java.awt.Container;


public class TestUtils {
    
    public static Component getChildNamed(Component parent, String name) {
         // Debug line
         //System.out.println("Class: " + parent.getClass() +
         //    " Name: " + parent.getName());
         if (name.equals(parent.getName())) { return parent; }
   
         if (parent instanceof Container) {
            Component[] children = ((Container)parent).getComponents();
   
            for (int i = 0; i < children.length; ++i) {
               Component child = getChildNamed(children[i], name);
               if (child != null) { return child; }
            }
         }
         return null;
    }
}