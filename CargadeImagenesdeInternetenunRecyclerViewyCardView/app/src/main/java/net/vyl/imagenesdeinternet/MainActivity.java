package net.vyl.imagenesdeinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.vyl.imagenesdeinternet.data.HeroRequest;
import net.vyl.imagenesdeinternet.model.Heroes;
import net.vyl.imagenesdeinternet.view.HeroesFragment;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Heroes> heroesArrayList;
    HeroRequest heroRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroRequest = new HeroRequest(this);
        heroRequest.heroesRequests();
    }

}