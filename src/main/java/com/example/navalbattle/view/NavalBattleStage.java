package com.example.navalbattle.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Represents the main stage of the Naval Battle game application.
 * This stage displays the game interface to the user.
 */
public class NavalBattleStage extends Stage {
    /**
     * Constructs a new instance of GameNavalBattleStage.
     *
     * @throws IOException if an error occurs while loading the FXML file for the game interface.
     */
    public NavalBattleStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/navalbattle/naval-battle.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Configuring the stage
        setTitle("Batalla naval"); // Sets the title of the stage
        setScene(scene); // Sets the scene for the stage
        setResizable(false); // Disallows resizing of the stage
        show(); // Displays the stage
    }

    /**
     * Closes the instance of GameNavalBattleStage.
     * This method is used to clean up resources when the game stage is no longer needed.
     */
    public static void deleteInstance() {
        NavalBattleStageHolder.INSTANCE.close();
        NavalBattleStageHolder.INSTANCE = null;
    }

    /**
     * Retrieves the singleton instance of GameNavalBattleStage.
     *
     * @return the singleton instance of GameNavalBattleStage.
     * @throws IOException if an error occurs while creating the instance.
     */
    public static NavalBattleStage getInstance() throws IOException {
        return NavalBattleStageHolder.INSTANCE = new NavalBattleStage();
    }

    /**
     * Holder class for the singleton instance of GameNavalBattleStage.
     * This class ensures lazy initialization of the singleton instance.
     */
    private static class NavalBattleStageHolder {
        private static NavalBattleStage INSTANCE;
    }
}
