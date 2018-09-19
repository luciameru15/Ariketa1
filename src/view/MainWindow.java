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
import controller.GestionListaEnMemoria;

import model.Application;

/**
 *
 * @author idoia
 */
public class MainWindow extends Application {

    private final TableView<Application> table = new TableView<>();

    final HBox hb = new HBox();
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        
        ObservableList<Application> data = GestionListaEnMemoria.cargarDatos();
        
        stage.setTitle("Aplikazioen Taula");
        stage.setWidth(450);
        stage.setHeight(550);
        final Label label = new Label("Aplikazioak");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(false);
        
        TableColumn<Application, String> idCol =
            new TableColumn<>("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
            new PropertyValueFactory<>("id"));
        idCol.setCellFactory(TextFieldTableCell.<Application>forTableColumn());
        idCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Application, String> t) -> {
            ((Application) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setId(t.getNewValue());
            });
        
        TableColumn<Application, String> appNameCol =
            new TableColumn<>("Izena");
        appNameCol.setMinWidth(100);
        appNameCol.setCellValueFactory(
            new PropertyValueFactory<>("Izena"));
        appNameCol.setCellFactory(TextFieldTableCell.<Application>forTableColumn());
        appNameCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Application, String> t) -> {
            ((Application) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setName(t.getNewValue());
            });
        
        TableColumn<Application, String> ownerCol = new TableColumn<>("Owner");
        ownerCol.setMinWidth(200);
        ownerCol.setCellValueFactory(
        new PropertyValueFactory<>("owner"));
        ownerCol.setCellFactory(TextFieldTableCell.<Application>forTableColumn());
        ownerCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Application, String> t) -> {
                ((Application) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setOwner(t.getNewValue());
            });
        TableColumn<Person, String> ageCol = new TableColumn<>("Age");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
        new PropertyValueFactory<>("email"));
        emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        emailCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setEmail(t.getNewValue());
            });
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("izen");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("abizen");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("email");
        final TextField addAge = new TextField();
        addAge.setMaxWidth(ageCol.getPrefWidth());
        addAge.setPromptText("age");
       
        final Button addButton = new Button("Gehitu");        
        addButton.setOnAction((ActionEvent e) -> {
            Person p = new Person(
                addFirstName.getText(),
                addLastName.getText(),
                addEmail.getText(),
                addAge.getText());
            data.add(p);
            
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
        });
        
        final Button removeButton = new Button("Ezabatu");        
        removeButton.setOnAction((ActionEvent e) -> {
            Person person = table.getSelectionModel().getSelectedItem();    
            data.remove(person);
        });
        
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton, removeButton);
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
