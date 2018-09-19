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
        
    private final SimpleStringProperty ID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Owner;
    private final SimpleStringProperty Type;
    private final SimpleStringProperty Size;
    
    
    public ApplicationClass(String id, String appName, String owner, String type, String size) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.ID = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(appName);
        this.Owner = new SimpleStringProperty(owner);
        this.Type = new SimpleStringProperty(type);
        this.Size = new SimpleStringProperty(size);
    }
    public String getId() {
        return ID.get();
    }
    public void setId(String id) {
        ID.set(id);
    }
    public String getName() {
        return Name.get();
    }
    public void setName(String id) {
        Name.set(id);
    }
    public String getOwner() {
        return Owner.get();
    }
    public void setOwner(String id) {
        Owner.set(id);
    }
    public String getType() {
        return Type.get();
    }
    public void setType(String id) {
        Type.set(id);
    }
    public String getSize() {
        return Size.get();
    }
    public void setSize(String id) {
        Size.set(id);
    }
}
