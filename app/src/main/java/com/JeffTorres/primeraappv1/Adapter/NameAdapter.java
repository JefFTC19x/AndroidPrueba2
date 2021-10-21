package com.JeffTorres.primeraappv1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.JeffTorres.primeraappv1.R;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder>
{
    private List<String> animes;
    private List<String> cuerpo;
    private List<String> enlaces;

    public NameAdapter(List<String> animes)
    {
        this.animes = animes;
        this.cuerpo = animes;
        this.enlaces =animes;
    }

    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_name,parent ,false);
        return new NameViewHolder(view);
    }

    public void onBindViewHolder( NameViewHolder holder, int position)
    {
        TextView anime =holder.itemView.findViewById(R.id.lnombre);
        String nom = animes.get(position);
        anime.setText(nom);


        TextView body =holder.itemView.findViewById(R.id.lcon);
        String desc = cuerpo.get(position);
        body.setText(desc);

        ImageView imagen = holder.itemView.findViewById(R.id.careta);
        String enlace = enlaces.get(position);


//        Button star = holder .itemView.findViewById(R.id.star);
//        star.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                star.
//            }
//        } );
    }

    public int getItemCount()
    {
        return animes.size();
    }

    class NameViewHolder extends  RecyclerView.ViewHolder
    {

        public NameViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
