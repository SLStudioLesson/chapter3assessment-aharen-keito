package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.ui.Recipe;

public class JSONDataHandler implements DataHandler {

    @Override
    public String getMode() {
        return "JSON";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        System.out.println();
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}
/*
 * JSON形式に対応したクラス
 * com.recipeapp.datahandlerパッケージにDataHandlerインターフェースを実装したJSONDataHandler.
 * javaクラスを作成してください。 メソッドはすべてpublicで定義すること。
 * 
 * メソッド名 説明
 * getMode 文字列JSONを返してください。
 * readData 処理の実装は行わないので定義し、nullをreturnしてください。
 * writeData 処理の実装は行わないので定義のみ行います。
 * searchData 処理の実装は行わないので定義し、nullをreturnしてください。
 */