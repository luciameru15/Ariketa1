/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Application;

/**
 *
 * @author aitor
 */
public class GestionListaEnMemoria {
    
 //  
    
    public static ObservableList<Application> cargarDatos(){
        
        return FXCollections.observableArrayList(
            new Application("web", "Smith", "jacob.smith@example.com","67", "90"),
            new Application("Isabella", "Johnson", "isabella.johnson@example.com","67", "90"),
            new Application("Ethan", "Williams", "ethan.williams@example.com","67", "90"),
            new Application("Emma", "Jones", "emma.jones@example.com","67", "90"),
            new Application("Michael", "Brown", "michael.brown@example.com","67", "90")
        );
    }     
    
//    public static void añadirDato(ObservableList<Application> lista,nApplication app){
//        
//        lista.add(app);
//    }      
//    
    
}
