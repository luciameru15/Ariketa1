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

public class ApplicationClass {
        
    private final SimpleStringProperty Id;
    private final SimpleStringProperty appName;
    private final SimpleStringProperty owner;
    private final SimpleStringProperty type;
    
    public ApplicationClass(String id, String aName, String owner, String type) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.Id = new SimpleStringProperty(id);
        this.appName = new SimpleStringProperty(aName);
        this.owner = new SimpleStringProperty(owner);
        this.type = new SimpleStringProperty(type);
    }
    public String getID() {
        return Id.get();
    }
    public void setID(String id) {
        Id.set(id);
    }
    public String getAppName() {
        return appName.get();
    }
    public void setAppName(String id) {
        appName.set(id);
    }
    public String getOwner() {
        return owner.get();
    }
    public void setOwner(String id) {
        owner.set(id);
    }
    public String getType() {
       return type.get();
    }
    public void setType(String id) {
       type.set(id);
    }
}