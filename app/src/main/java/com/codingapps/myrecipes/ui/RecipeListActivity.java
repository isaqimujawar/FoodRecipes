package com.codingapps.myrecipes.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.codingapps.myrecipes.R;
import com.codingapps.myrecipes.model.Recipe;
import com.codingapps.myrecipes.request.RecipeApi;
import com.codingapps.myrecipes.request.ServiceGenerator;
import com.codingapps.myrecipes.request.response.RecipeResponse;
import com.codingapps.myrecipes.request.response.RecipeSearchResponse;
import com.codingapps.myrecipes.viewmodel.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {
    //vars
    private static final String TAG = "RecipeListActivity";
    private RecipeListViewModel mRecipeListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecipeListViewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);
        subscribeObservers();
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {

            }
        });
    }
    public void searchRecipesApi(String query, int pageNumber){
        mRecipeListViewModel.searchRecipesApi(query,pageNumber);
    }
    private void testRetrofitRequest(){
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();
        Call<RecipeResponse> responseCall = recipeApi.getRecipe(
          "41470"
        );
        responseCall.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                if (response.code() == 200){
                    Log.d(TAG, "onResponse1: " + response.body().toString());
                    Recipe recipe = response.body().getRecipe();
                    Log.d(TAG, "onResponse: RETRIEVED RECIPE " + recipe.toString());
                }else {
                try {
                    Log.d(TAG, "onResponse: " + response.errorBody().string());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {

            }
        });
       /*Call<RecipeSearchResponse> responseCall = recipeApi.searchRecipe(
                "chicken",
                "3"
        );
        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse1: " + response.body().toString());
                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
                    for (Recipe recipe : recipes) {
                        Log.d(TAG, "onResponse: " + recipe.getTitle());
                    }
                }else {
                    try {
                        Log.d(TAG, "onResponse: " + response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {

            }
        });*/
    }
}