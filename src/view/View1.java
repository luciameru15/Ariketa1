/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import controller.Controller;

import model.Person;


/**
 *
 * @author Luciam
 */
public class View1 extends Application {

    private final TableView<Person> table = new TableView<>();

    final HBox hb = new HBox();
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        
        ObservableList<Person> data = Controller.cargarDatos();
        
        stage.setTitle("Ezkurdi K.T.");
        stage.setWidth(650);
        stage.setHeight(550);
        final Label label = new Label("Jugadores");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
        
        TableColumn<Person, String> firstNameCol =
            new TableColumn<>("Nombre");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstNameCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
            ((Person) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setFirstName(t.getNewValue());
            });
        
        TableColumn<Person, String> lastNameCol =
            new TableColumn<>("Apellido");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        lastNameCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
            ((Person) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setLastName(t.getNewValue());
            });
        
        TableColumn<Person, String> ageCol = new TableColumn<>("Edad");
        ageCol.setMinWidth(200);
        ageCol.setCellValueFactory(
        new PropertyValueFactory<>("age"));
        ageCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        ageCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setAge(t.getNewValue());
            });
        TableColumn<Person, String> positionCol = new TableColumn<>("Posicion");
        positionCol.setMinWidth(200);
        positionCol.setCellValueFactory(
        new PropertyValueFactory<>("position"));
        positionCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        positionCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setPosition(t.getNewValue());
            });
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, ageCol, positionCol);
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("nombre");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("apellido");
        final TextField addage = new TextField();
        addage.setMaxWidth(ageCol.getPrefWidth());
        addage.setPromptText("edad");
        final TextField addposition = new TextField();
        addposition.setMaxWidth(ageCol.getPrefWidth());
        addposition.setPromptText("posicion");
       
        final Button addButton = new Button("Agregar");        
        addButton.setOnAction((ActionEvent e) -> {
            Person p = new Person(
                addFirstName.getText(),
                addLastName.getText(),
                addage.getText(),
                addposition.getText());
            data.add(p);
            
            addFirstName.clear();
            addLastName.clear();
            addage.clear();
            addposition.clear();
        });
        
        final Button removeButton = new Button("Borrar");        
        removeButton.setOnAction((ActionEvent e) -> {
            Person person = table.getSelectionModel().getSelectedItem();    
            data.remove(person);
        });
        
        hb.getChildren().addAll(addFirstName, addLastName, addage, addposition, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
