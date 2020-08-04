package com.codingapps.myrecipes.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codingapps.myrecipes.model.Recipe;
import com.codingapps.myrecipes.repository.RecipeRepository;

import java.util.List;

public class RecipeListViewModel extends ViewModel {
    //Vars
    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes() {
        return mRecipeRepository.getRecipes();
    }
    public void searchRecipesApi(String query, int pageNumber){
        mRecipeRepository.searchRecipesApi(query,pageNumber);
    }

}
