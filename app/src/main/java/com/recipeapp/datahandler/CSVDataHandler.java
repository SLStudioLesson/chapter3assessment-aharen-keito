package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.ui.Ingredient;
import com.recipeapp.ui.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "C:\\Users\\user\\Documents\\アセスメント\\chapter3assessment-aharen-keito\\app\\src\\main\\resources\\recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        // 絶対パス？を指定
        String filePath = "C:\\Users\\user\\Documents\\アセスメント\\chapter3assessment-aharen-keito\\app\\src\\main\\resources\\recipes.csv";
        ArrayList<Recipe> array = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) { // レシピ名と材料がある場合
                    String recipeName = parts[0]; // 最初をレシピ名
                    ArrayList<Ingredient> ingredients = new ArrayList<>();
                    for (int i = 1; i < parts.length; i++) {
                        // 各材料をIngredientオブジェクトとしてリストに追加する
                        ingredients.add(new Ingredient(parts[i].trim())); // trrim()は空白除去
                    }
                    Recipe recipe = new Recipe(recipeName, ingredients);
                    array.add(recipe);

                }else{
                    System.out.println("No recipes available.");
                }
            }
        } catch (IOException e) {
            System.out.println("No recipes available." + e.getMessage());
        }
        return array;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        String filePath = "C:\\Users\\user\\Documents\\アセスメント\\chapter3assessment-aharen-keito\\app\\src\\main\\resources\\recipes.csv";
        String add = recipe.getName();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            // recipe オブジェクトから材料リストを取得し、その中の各 Ingredient をループ　
            for (Ingredient ingredient : recipe.getIngredients()) {
                add += "," + ingredient.getName(); // 材料をカンマ区切り
            writer.write(add);
            writer.newLine(); // 改行
        } }catch (IOException e) {
          System.out.println("Recipe not added successfully.");
        }
    
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}
/*
 * RecipeUIのdisplayRecipesメソッドのアクセス修飾子はprivateで定義してください。
 * 
 * src/main/java/com/recipeapp/datahandler/CSVDataHandler.java
 * 
 * メソッド名 戻り値の型 引数 送信される例外 説明
 * readData ArrayList<Recipe> なし IOException
 * recipes.csvからレシピデータを読み込み、それをリスト形式で返します。
 * src/main/java/com/recipeapp/ui/RecipeUI.java
 * 
 * メソッド名 戻り値の型 引数 送信される例外 説明
 * displayRecipes void なし なし - DataHandlerから読み込んだレシピデータを整形してコンソールに表示します。
 * - IOExceptionを受け取った場合はError reading file: 例外のメッセージとコンソールに表示します
 * - 表示形式は以下の出力例を再現してください。
 * 
 */