/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ApplicationClass;

/**
 *
 * @author aitor
 */
public class GestionListaEnMemoria {
    
 //  
    
    public static ObservableList<Application> cargarDatos(){
        
        return FXCollections.observableArrayList(
            new Application("WhatsApp", "Facebook Inc.", "jacob.smith@example.com", "game"),
            new Application("Isabella", "Johnson", "isabella.johnson@example.com", "game"),
            new Application("Ethan", "Williams", "ethan.williams@example.com", "game"),
            new Application("Emma", "Jones", "emma.jones@example.com", "game"),
            new Application("Michael", "Brown", "michael.brown@example.com", "game")
        );
    }     
    
//    public static void añadirDato(ObservableList<Person> lista, Person persona){
//        
//        lista.add(persona);
//    }      
//    
    
}
