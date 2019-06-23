package com.example.manara.capstone_stage2;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Articles_Adapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>   {

final private ListItemClickListener mOnClickListener;
public ArrayList<Articales> articalesList=new ArrayList<>();
    FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
    DatabaseReference databaseReference=firebaseDatabase.getReference().child("Articles");
    String tit = "";

public interface ListItemClickListener {

    void onListItemClick(int clickedItemIndex);
}
   public Context context;

    public Articles_Adapter(ArrayList<Articales> articalesList, Context context, ListItemClickListener listener) {
        this.context=context;
        this.articalesList=articalesList;
        mOnClickListener = listener;
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.articales_items;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

        return new Articles_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {

        TextView content =holder.itemView.findViewById(R.id.content);
        content.setText(articalesList.get(i).getDescription());
        TextView title =holder.itemView.findViewById(R.id.title);
        title.setText(articalesList.get(i).getTitle());

         ImageView imageView= holder.itemView.findViewById(R.id.image_articles);
        final ImageView imageView2= holder.itemView.findViewById(R.id.favorite1);
        Picasso.with(context)
                .load(articalesList.get(i).getUrlToImage())
                .into(imageView);

        holder.itemView.findViewById(R.id.favorite1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageResource(R.drawable.favorite);
                if (articalesList.get(i).getTitle().contains(".")||articalesList.get(i).getTitle().contains("#")||articalesList.get(i).getTitle().contains("$")
                        ||articalesList.get(i).getTitle().contains("[")||articalesList.get(i).getTitle().contains("]")){
                    for (int i =0;i<10;i++){
                        tit += articalesList.get(i).getTitle().charAt(i);
                    }
                    databaseReference.child(tit).setValue(new Articales(articalesList.get(i).getTitle(),null,articalesList.get(i).getUrlToImage(),articalesList.get(i).getDescription()));

                }
                else
                    databaseReference.child(articalesList.get(i).getTitle()).setValue(new Articales(articalesList.get(i).getTitle(),null,articalesList.get(i).getUrlToImage(),articalesList.get(i).getDescription()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return articalesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public ViewHolder(View view) {

        super(view);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        int pos = getAdapterPosition();


        mOnClickListener.onListItemClick(pos);

    }
}
}