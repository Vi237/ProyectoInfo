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
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        //toolbar
        showToolBar("",false,view);
        //recyclerview
        RecyclerView recyclerView=view.findViewById(R.id.recycler_view_profile);
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
        Toolbar toolbar=view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }
    //creamos lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image>images=new ArrayList<>();
        images.add(new Image("https://partedeexistencia.com/wp-content/uploads/2017/02/r%C3%ADo-Torotoro-Toro-Toro-Bolivia.jpg","Carlos Valdivia","2 dias","1 me gusta"));
        images.add(new Image("https://boliviamia.net/Images/Tourpics/atop-deathroad-02.jpg","Kim Taehyung","3 dias","2 me gusta"));
        images.add(new Image("https://boliviamia.net/Images/Tourpics/atop-titicaca-04.jpg","Park jimin","2 dias","3 me gusta"));
        images.add(new Image("https://tipsparatuviaje.com/wp-content/uploads/2019/07/parque-nacional-tunari.jpg","Lee Chae Rin","5 dias","4 me gusta"));
        images.add(new Image("https://tipsparatuviaje.com/wp-content/uploads/2019/07/reserva-nacional-eduardo-abaroa.jpg","Wang Yibo","6 dias","5 me gusta"));
        images.add(new Image("https://abarrons.com/wp-content/uploads/2019/11/Jardin-botanico-Barron-rent-a-car.jpg","Xiao Zhan","4 dias","6 me gusta"));
        images.add(new Image("https://abarrons.com/wp-content/uploads/2019/11/Lomas-de-Arena-Barron-rent-a-Car-Destinos-turisticos.jpg","Min Yoon-gi","2 dias","7 me gusta"));
        images.add(new Image("https://boliviamia.net/Images/Tourpics/atop-uyuni-01.jpg","Jung Ho-seok","2 dias","8 me gusta"));
        images.add(new Image("https://javitour.com/wp-content/uploads/2018/08/lugares-m%C3%A1s-emblem%C3%A1ticos-de-Corea-del-Sur_opt-4.jpg","Park Shin-hye","6 dias","3 me gusta"));
        images.add(new Image("https://eng.taiwan.net.tw/att/1/big_scenic_spots/pic_704_11.jpg","Bae Su-ji","9 dias","1 me gusta"));
        return images;
    }
}