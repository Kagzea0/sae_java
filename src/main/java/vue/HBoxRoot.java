package vue;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import modele.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HBoxRoot extends HBox {

    public HBoxRoot() throws IOException {
        GridPaneAPLI gridPaneAPLI = new GridPaneAPLI();
        this.getChildren().add(gridPaneAPLI);
        TextAreaScenario0 textAreaScenario0 = new TextAreaScenario0();
        TextAreaScenario1 textAreaScenario1 = new TextAreaScenario1();
        TextAreaScenario2 textAreaScenario2 = new TextAreaScenario2();
        TextAreaScenario21 textAreaScenario21 = new TextAreaScenario21();
        TextAreaScenario22 textAreaScenario22 = new TextAreaScenario22();


        Node [] components = new Node [5] ;
        components [0] = textAreaScenario0;
        components [1] = textAreaScenario1;
        components [2] = textAreaScenario2;
        components [3] = textAreaScenario21;
        components [4] = textAreaScenario22;

        StackPane stackPane = new StackPane(components);
        stackPane.getChildren().get(0).toFront();

        for (int i = 0; i < NomItem.NOM_ITEM_MENU.length; i++){
            MenuItem menuItem = new MenuItem(NomItem.NOM_ITEM_MENU[i]);
            menuItem.setUserData(i);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    int data=(int)((MenuItem)actionEvent.getSource()).getUserData();
                    if (data == 0){
                        getChildren().remove(0);
                        getChildren().add(textAreaScenario0);
                        textAreaScenario0.bouton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                getChildren().remove(0);
                                getChildren().add(gridPaneAPLI);
                            }
                        });

                    }
                    if (data == 1){
                        getChildren().remove(0);
                        getChildren().add(textAreaScenario1);
                        textAreaScenario1.bouton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                getChildren().remove(0);
                                getChildren().add(gridPaneAPLI);
                            }
                        });
                    }

                    if (data == 2){
                        getChildren().remove(0);
                        getChildren().add(textAreaScenario2);
                        textAreaScenario2.bouton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                getChildren().remove(0);
                                getChildren().add(gridPaneAPLI);
                            }
                        });
                    }

                    if (data == 3){
                        getChildren().remove(0);
                        getChildren().add(textAreaScenario21);
                        textAreaScenario21.bouton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                getChildren().remove(0);
                                getChildren().add(gridPaneAPLI);
                            }
                        });
                    }

                    if (data == 4){
                        getChildren().remove(0);
                        getChildren().add(textAreaScenario22);
                        textAreaScenario22.bouton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                getChildren().remove(0);
                                getChildren().add(gridPaneAPLI);
                            }
                        });
                    }
                    System.out.println(data);


                }
            });
            gridPaneAPLI.menu.getItems().add(menuItem);
        }





    }
}
