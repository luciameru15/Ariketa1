/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

/**
 *
 * @author idoia
 */
public class Controller {
    
 //  
    
    public static ObservableList<Person> cargarDatos(){
        
        return FXCollections.observableArrayList(
            new Person("Izaro", "Sanz", "17", "Central"),
            new Person("Ane", "Gomez", "18", "Delantera"),
            new Person("Leire", "Crespo", "17", "Extremo"),
            new Person("Janire", "Bustinza", "26", "Medio"),
            new Person("Enara", "Retes", "17", "Lateral")
        );
    }         
}
