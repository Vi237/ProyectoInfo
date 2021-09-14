package com.vi.lavenganza20.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vi.lavenganza20.R;
import com.vi.lavenganza20.adapter.CardViewAdapter;
import com.vi.lavenganza20.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        //toolbar
        showToolBar(getString(R.string.title_home_fragment),false,view);
        //recyclerview
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view);
        //layout manager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //adapter
        CardViewAdapter cardViewAdapter=new CardViewAdapter(buidImages(),R.layout.cardview_image,getActivity());
        recyclerView.setAdapter(cardViewAdapter);
        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }
    //creamos lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image>images=new ArrayList<>();
        images.add(new Image("","Carlos Valdivia","2 dias","1 me gusta"));
        images.add(new Image("","Kim Taehyung","3 dias","2 me gusta"));
        images.add(new Image("","Park jimin","2 dias","3 me gusta"));
        images.add(new Image("","Lee Chae Rin","5 dias","4 me gusta"));
        images.add(new Image("","Wang Yibo","6 dias","5 me gusta"));
        images.add(new Image("","Xiao Zhan","4 dias","6 me gusta"));
        images.add(new Image("","Min Yoon-gi","2 dias","7 me gusta"));
        images.add(new Image("","Jung Ho-seok","2 dias","8 me gusta"));
        images.add(new Image("","Park Shin-hye","6 dias","3 me gusta"));
        images.add(new Image("","Bae Su-ji","9 dias","1 me gusta"));
        return images;
    }
}