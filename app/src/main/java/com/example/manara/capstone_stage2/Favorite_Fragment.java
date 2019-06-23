package com.example.manara.capstone_stage2;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class Favorite_Fragment extends Fragment implements Articles_Adapter.ListItemClickListener {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ArrayList<Articales> articles= new ArrayList<>();
    Context context;

    public Favorite_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_favorite_, container, false);
        context =this.getContext();
        firebaseDatabase= FirebaseDatabase.getInstance();
        final String[] news = new String[1];
        recyclerView= view.findViewById(R.id.rv_favorite);
        final Favorite_Adapter newsAdapter= new Favorite_Adapter(articles,context,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(newsAdapter);

        databaseReference=firebaseDatabase.getReference().child(getString(R.string.articles));
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                articles.add(dataSnapshot.getValue(Articales.class));
                news[0] =articles.get(0).getDescription();
                addToWidget(news[0]);

                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
    private void addToWidget(String news) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getContext());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this.getContext(), Favorite_Widget.class));
        Favorite_Widget.callUpdateAppWidget(this.getContext(),appWidgetManager,news,appWidgetIds);
    }
}
