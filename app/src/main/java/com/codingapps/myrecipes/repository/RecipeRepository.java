package com.codingapps.myrecipes.repository;

import androidx.lifecycle.LiveData;

import com.codingapps.myrecipes.model.Recipe;
import com.codingapps.myrecipes.request.RecipeApiClient;

import java.util.List;

public class RecipeRepository {
    //vars
    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

    private RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public static RecipeRepository getInstance() {
        if (instance == null) {
            instance = new RecipeRepository();
        }
        return instance;
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipeApiClient.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber){
        if (pageNumber == 0){
            pageNumber = 1;
        }
        mRecipeApiClient.searchRecipesApi(query,pageNumber);
    }
}
