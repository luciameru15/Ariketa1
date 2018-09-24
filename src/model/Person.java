/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aitor
 */

public class Person {
        
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty age;
    private final SimpleStringProperty position;
    
    public Person(String fName, String lName, String age, String position) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.age = new SimpleStringProperty(age);
        this.position = new SimpleStringProperty(position);
    }
    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
    public String getAge() {
        return age.get();
    }
    public void setAge(String fName) {
        age.set(fName);
    }
    public String getPosition() {
        return position.get();
    }
    public void setPosition(String fName) {
        position.set(fName);
    }
}