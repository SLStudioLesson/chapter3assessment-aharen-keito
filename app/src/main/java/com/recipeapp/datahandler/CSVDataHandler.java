package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.ui.Recipe;

public class CSVDataHandler implements DataHandler {
    private String filePath;

    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode(){
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData()throws IOException{
        String filePath = "app/src/main/resources/recipes.txt";
        ArrayList<Recipe> array = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrayss = line.split(",");
                if (arrayss.length >= 2){ // レシピと材料
                    for(String aray : arrayss){
                        System.out.println(aray);
                    }
                }
                line.split(",");
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return array;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException{

    }
    
    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException{
        return null;
    }

   


}
/*
 * RecipeUIのdisplayRecipesメソッドのアクセス修飾子はprivateで定義してください。

src/main/java/com/recipeapp/datahandler/CSVDataHandler.java

メソッド名	戻り値の型	引数	送信される例外	説明
readData	ArrayList<Recipe>	なし	IOException	recipes.csvからレシピデータを読み込み、それをリスト形式で返します。
src/main/java/com/recipeapp/ui/RecipeUI.java

メソッド名	戻り値の型	引数	送信される例外	説明
displayRecipes	void	なし	なし	- DataHandlerから読み込んだレシピデータを整形してコンソールに表示します。
- IOExceptionを受け取った場合はError reading file: 例外のメッセージとコンソールに表示します
- 表示形式は以下の出力例を再現してください。
 * 
 */