package com.example.manara.capstone_stage2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Articles_Loader extends AsyncTaskLoader {


    public Articles_Loader(@NonNull Context context) {
        super(context);
    }



    //open the connection by using GetTrailer Class
    @Nullable
    @Override
    public ArrayList<Articales> loadInBackground() {

        ArrayList<Articales> articalesArrayList=new ArrayList<>();
        Get_Data getTrailer=new Get_Data();
        try {
            articalesArrayList=getTrailer.getArticles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articalesArrayList;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
