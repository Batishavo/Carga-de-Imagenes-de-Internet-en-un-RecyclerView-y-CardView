package net.vyl.imagenesdeinternet.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.vyl.imagenesdeinternet.MainActivity;
import net.vyl.imagenesdeinternet.R;
import net.vyl.imagenesdeinternet.model.Heroes;
import net.vyl.imagenesdeinternet.view.HeroesFragment;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HeroRequest {
    RequestQueue requestQueue;
    private static final String TAG = "VollHero";
    Context context;
    MainActivity mainActivity;

    public HeroRequest(Context context) {
        this.context = context;
        if (context instanceof MainActivity){
            mainActivity = (MainActivity) context;
        }
        requestQueue = Volley.newRequestQueue(context);
    }

    public void heroesRequests(){
        String urlHeroes = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
        JsonRequest jsonRequest = new JsonObjectRequest(
                urlHeroes,
                null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("heroes");
                        Type listType = new TypeToken<ArrayList<Heroes>>(){}.getType();
                        Gson gson = new Gson();
                        MainActivity.heroesArrayList = gson.fromJson(jsonArray.toString(), listType);
                        for(Heroes hero: MainActivity.heroesArrayList){
                            Log.d(TAG, "heroesRequests: nombre: " + hero.getName() + ", Imagen: " + hero.getImageurl());
                        }
                        Log.d(TAG, "heroesRequests: Héroes cargados");
                        HeroesFragment selectorFragment = new HeroesFragment();
                        if (mainActivity.findViewById(R.id.main_container) != null && mainActivity.getSupportFragmentManager().findFragmentById(R.id.main_container) == null){
                            mainActivity.getSupportFragmentManager().beginTransaction().add(R.id.main_container, selectorFragment).commit();
                        }
                    } catch (JSONException e) {
                        Log.d(TAG, "heroesRequests: " + e.getMessage());
                    }
                },
                error -> {
                    Log.d(TAG, "heroesRequests: Error: " + error);
                }
        );
        requestQueue.add(jsonRequest);
        Log.d(TAG, "heroesRequests: Pasó request");
    }
}
