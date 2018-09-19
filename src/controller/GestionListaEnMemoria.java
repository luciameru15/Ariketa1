/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ApplicationClass;

/**
 *
 * @author aitor
 */
public class GestionListaEnMemoria {
    
 //  
    
    public static ObservableList<ApplicationClass> cargarDatos(){
        
        return FXCollections.observableArrayList(new ApplicationClass("web", "Smith", "jacob.smith@example.com","67", "90"),
            new ApplicationClass("Isabella", "Johnson", "isabella.johnson@example.com","67", "90"),
            new ApplicationClass("Ethan", "Williams", "ethan.williams@example.com","67", "90"),
            new ApplicationClass("Emma", "Jones", "emma.jones@example.com","67", "90"),
            new ApplicationClass("Michael", "Brown", "michael.brown@example.com","67", "90")
        );
    }     
    
//    public static void añadirDato(ObservableList<Application> lista,nApplication app){
//        
//        lista.add(app);
//    }      
//    
    
}
