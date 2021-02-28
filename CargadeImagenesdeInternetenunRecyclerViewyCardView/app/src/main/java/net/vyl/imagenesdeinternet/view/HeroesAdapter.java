package net.vyl.imagenesdeinternet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import net.vyl.imagenesdeinternet.R;
import net.vyl.imagenesdeinternet.model.Heroes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    ArrayList<Heroes> heroesList;
    private Context contexto;
    private LayoutInflater inflador;
    private static final String TAG = "VollHero";

    public HeroesAdapter(Context contexto, ArrayList<Heroes> heroesList) {
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.heroesList = heroesList;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.heroes_model, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Heroes heroe = heroesList.get(position);
        Picasso.get().load(heroe.getImageurl()).into(holder.hero_image);
        holder.hero_name.setText(heroe.getName());
    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView hero_image;
        public TextView hero_name;

        public ViewHolder(View itemView)
        {
            super(itemView);
            hero_image = (ImageView) itemView.findViewById(R.id.hero_image);
            hero_image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            hero_name = (TextView) itemView.findViewById(R.id.hero_name);
        }
    }

}
