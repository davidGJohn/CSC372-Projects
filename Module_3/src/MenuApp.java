import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.paint.Color;

public class MenuApp extends Application {
    private TextArea textArea;
    private VBox root;

    @Override
    public void start(Stage primaryStage) {
        root = new VBox();
        MenuBar menuBar = createMenuBar();

        textArea = new TextArea();
        textArea.setEditable(true);
        textArea.setPrefHeight(300);
        
        root.getChildren().addAll(menuBar, textArea);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu mainMenu = new Menu("Options");
        
        // First menu item - Show Date and Time
        MenuItem dateTimeItem = new MenuItem("Show Date/Time");
        dateTimeItem.setOnAction(e -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            textArea.setText(now.format(formatter));
        });
        
        // Second menu item - Write to Log File
        MenuItem writeLogItem = new MenuItem("Write to Log");
        writeLogItem.setOnAction(e -> {
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(textArea.getText());
                textArea.setText("Content written to log.txt");
            } catch (IOException ex) {
                textArea.setText("Error writing to file: " + ex.getMessage());
            }
        });
        
        // Third menu item - Change Background Color
        MenuItem changeColorItem = new MenuItem("Change Background");
        changeColorItem.setOnAction(e -> {
            double greenHue = Math.random() * 120;
            Color randomGreenColor = Color.hsb(greenHue, 0.5, 0.8);
            root.setStyle("-fx-background-color: " + 
                toRGBCode(randomGreenColor) + ";");
        });
        
        // Fourth menu item - Exit
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> System.exit(0));
        
        // Add menu items to menu
        mainMenu.getItems().addAll(dateTimeItem, writeLogItem, changeColorItem, exitItem);
        menuBar.getMenus().add(mainMenu);
        
        return menuBar;
    }
    
    private String toRGBCode(Color color) {
        return String.format("#%02X%02X%02X",
            (int)(color.getRed() * 255),
            (int)(color.getGreen() * 255),
            (int)(color.getBlue() * 255));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}