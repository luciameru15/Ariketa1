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
import model.ApplicationClass;

public class MainWindow extends Application {

    private final TableView<ApplicationClass> table = new TableView<>();

    final HBox hb = new HBox();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        ObservableList<ApplicationClass> data = GestionListaEnMemoria.cargarDatos();

        stage.setTitle("Aplikazioen Taula");
        stage.setWidth(850);
        stage.setHeight(550);
        final Label label = new Label("Aplikazioak");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        TableColumn<ApplicationClass, String> idCol = new TableColumn<>("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setCellFactory(TextFieldTableCell.<ApplicationClass>forTableColumn());
        idCol.setOnEditCommit(
                (TableColumn.CellEditEvent<ApplicationClass, String> t) -> {
                    ((ApplicationClass) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setId(t.getNewValue());
                });

        TableColumn<ApplicationClass, String> appNameCol = new TableColumn<>("Izena");
        appNameCol.setMinWidth(100);
        appNameCol.setCellValueFactory(new PropertyValueFactory<>("Izena"));
        appNameCol.setCellFactory(TextFieldTableCell.<ApplicationClass>forTableColumn());
        appNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<ApplicationClass, String> t) -> {
                    ((ApplicationClass) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setName(t.getNewValue());
                });

        TableColumn<ApplicationClass, String> ownerCol = new TableColumn<>("Owner");
        ownerCol.setMinWidth(200);
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        ownerCol.setCellFactory(TextFieldTableCell.<ApplicationClass>forTableColumn());
        ownerCol.setOnEditCommit(
                (TableColumn.CellEditEvent<ApplicationClass, String> t) -> {
                    ((ApplicationClass) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setOwner(t.getNewValue());
                });
        TableColumn<ApplicationClass, String> typeCol = new TableColumn<>("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        typeCol.setCellFactory(TextFieldTableCell.<ApplicationClass>forTableColumn());
        typeCol.setOnEditCommit(
                (TableColumn.CellEditEvent<ApplicationClass, String> t) -> {
                    ((ApplicationClass) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setType(t.getNewValue());
                });
        TableColumn<ApplicationClass, String> sizeCol = new TableColumn<>("Size");
        sizeCol.setMinWidth(200);
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("Size"));
        sizeCol.setCellFactory(TextFieldTableCell.<ApplicationClass>forTableColumn());
        sizeCol.setOnEditCommit(
                (TableColumn.CellEditEvent<ApplicationClass, String> t) -> {
                    ((ApplicationClass) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setSize(t.getNewValue());
                });
        table.setItems(data);
        table.getColumns().addAll(idCol, appNameCol, ownerCol, typeCol, sizeCol);
        final TextField addId = new TextField();
        addId.setPromptText("ID");
        addId.setMaxWidth(idCol.getPrefWidth());
        final TextField addName = new TextField();
        addName.setMaxWidth(appNameCol.getPrefWidth());
        addName.setPromptText("Izena");
        final TextField addOwner = new TextField();
        addOwner.setMaxWidth(ownerCol.getPrefWidth());
        addOwner.setPromptText("Owner");
        final TextField addType = new TextField();
        addType.setMaxWidth(typeCol.getPrefWidth());
        addType.setPromptText("Type");
        final TextField addSize = new TextField();
        addSize.setMaxWidth(sizeCol.getPrefWidth());
        addSize.setPromptText("Size");

        final Button addButton = new Button("Gehitu");
        addButton.setOnAction((ActionEvent e) -> {
            ApplicationClass a = new ApplicationClass(
                    addId.getText(),
                    addName.getText(),
                    addOwner.getText(),
                    addType.getText(),
                    addSize.getText());
            data.add(a);

            addId.clear();
            addName.clear();
            addOwner.clear();
            addType.clear();
            addSize.clear();
        });

        final Button removeButton = new Button("Ezabatu");
        removeButton.setOnAction((ActionEvent e) -> {
            ApplicationClass app = table.getSelectionModel().getSelectedItem();
            data.remove(app);
        });

        hb.getChildren().addAll(addId, addName, addOwner, addType, addSize, addButton, removeButton);
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
