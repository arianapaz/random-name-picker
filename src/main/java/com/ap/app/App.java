package com.ap.app;

import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class App extends Application
{
	private RandomNameGenerator generator;

	public static void main(String[] args) throws URISyntaxException
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		// setup data
		generator = new RandomNameGenerator();

		// set page name
		primaryStage.setTitle("Random Name Generator");

		// setup grid
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);

		Text randomName = new Text();
		randomName.setTextAlignment(TextAlignment.CENTER);
		grid.add(randomName, 1, 1);

		// setup button		
		Button btn = new Button();
		btn.setText("Get Name");
		btn.setTextAlignment(TextAlignment.CENTER);
		btn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				randomName.setText(generator.getNextName());
				randomName.setTextAlignment(TextAlignment.CENTER);
			}
		});
		grid.add(btn, 1, 2);

		StackPane root = new StackPane();
		root.getChildren().add(grid);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
}
