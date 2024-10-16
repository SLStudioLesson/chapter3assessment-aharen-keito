package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;
    private CSVDataHandler cdvDataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                    addNewRecipe();
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {

            List<Recipe> recipes = dataHandler.readData();
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            } else {
                System.out.println("Recipes:");
                System.out.println("-----------------------------------");
                for (Recipe recipe : recipes) {
                    System.out.println("Recipe Name: " + recipe.getName());
                    System.out.println("Main Ingredients: " + recipe.getIngredients());
                    System.out.println("-----------------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void addNewRecipe(){
        try {
            System.out.println("Adding a new recipe.");
            System.out.println("Enter recipe name: ");
            String recipeName = reader.readLine(); // recipe名前入力
            ArrayList<Ingredient> ingre = new ArrayList<>(); // recipe()に使用
            System.out.println("Enter ingredients (type 'done' when finished): ");
            while(true){
            System.out.println("Ingredient: ");
            String ingreName = reader.readLine(); // 材料名前入力
            if(ingreName.equals("done")){ // done入力で終了させる
                break;
            }
            // 取得した材料名を使って新しい Ingredient オブジェクトを作成しそれをリストへ
            ingre.add(new Ingredient(ingreName));
        }
            Recipe r = new Recipe(recipeName, ingre);
            dataHandler.writeData(r);
            System.out.println("Recipe added successfully. ");

        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }
}
