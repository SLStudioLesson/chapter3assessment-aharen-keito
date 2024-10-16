import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            DataHandler dataHandler;
            switch (choice) {
                case "1":
                    dataHandler = new CSVDataHandler();
                    break;
                case "2":
                    dataHandler = new JSONDataHandler();
                    break;
                default:
                    System.out.println("不正な入力です。CSVDataHandlerを選択します。");
                    dataHandler = new CSVDataHandler();
                    break;

            }
            RecipeUI r = new RecipeUI(dataHandler);
            r.displayMenu();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
