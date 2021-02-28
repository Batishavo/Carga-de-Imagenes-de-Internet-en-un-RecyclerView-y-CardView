package net.vyl.imagenesdeinternet.view;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.vyl.imagenesdeinternet.MainActivity;
import net.vyl.imagenesdeinternet.R;
import net.vyl.imagenesdeinternet.data.HeroRequest;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeroesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeroesFragment extends Fragment {

    private RecyclerView heroRecyclerView;
    private HeroesAdapter adapter;
    private GridLayoutManager layoutManager;
    MainActivity mainActivity;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof MainActivity){
            mainActivity = (MainActivity) context;
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HeroesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeroesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeroesFragment newInstance(String param1, String param2) {
        HeroesFragment fragment = new HeroesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_heroes, container, false);
        heroRecyclerView = v.findViewById(R.id.hero_recyclerView);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        adapter = new HeroesAdapter(getActivity(), MainActivity.heroesArrayList);
        heroRecyclerView.setLayoutManager(layoutManager);
        heroRecyclerView.setAdapter(adapter);
        return v;
    }
}