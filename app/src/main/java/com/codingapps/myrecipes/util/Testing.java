package com.codingapps.myrecipes.util;

import android.util.Log;

import com.codingapps.myrecipes.model.Recipe;

import java.util.List;

public class Testing {
    public static void printRecipes(List<Recipe> list, String tag){
        for (Recipe recipe : list) {
            Log.d(tag, "onChanged: " + recipe.getTitle());
        }
    }
}
