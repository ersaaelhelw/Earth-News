package com.example.manara.capstone_stage2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public  class Articles_Fragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<Articales>>,Articles_Adapter.ListItemClickListener {
    ArrayList<Articales>articalesArrayList=new ArrayList<>();
    RecyclerView recyclerView ;
    ImageView imageView;
    Context context=this.getContext();

    public Articles_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_articles_, container, false);
        //noinspection deprecation
        getLoaderManager().initLoader(3, null, this);
        recyclerView = view.findViewById(R.id.rv_articles);
        imageView=view.findViewById(R.id.favorite);
        return view;
    }

   private  void set_recycler() {

       Articles_Adapter adapter = new Articles_Adapter(articalesArrayList,this.getContext(),this);
       LinearLayoutManager manager = new LinearLayoutManager(context);
       manager.setOrientation(LinearLayoutManager.VERTICAL);
       recyclerView.setLayoutManager(manager);
       recyclerView.setAdapter(adapter);
    }


    @NonNull
    @Override
    public Loader<ArrayList<Articales>> onCreateLoader(int i, @Nullable Bundle bundle) {

        return new Articles_Loader(this.getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Articales>> loader, ArrayList<Articales> articales) {


        articalesArrayList=articales;
        set_recycler();

    }


    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
    @Override
    public void onListItemClick(int clickedItemIndex) {




    }
}
