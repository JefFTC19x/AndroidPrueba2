package com.JeffTorres.primeraappv1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.JeffTorres.primeraappv1.Entidades.Repository;
import com.JeffTorres.primeraappv1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.NameViewHolder>
{
    private  boolean favorito = true;
    private List<Repository> data;

    public RepositoryAdapter(List<Repository> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name, parent, false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryAdapter.NameViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        TextView anime = holder.itemView.findViewById(R.id.lnombre);
        TextView body = holder.itemView.findViewById(R.id.lcon);
        ImageView img = holder.itemView.findViewById(R.id.careta);

        Repository repo = data.get(position);

        anime.setText(repo.getAnime());
        body.setText(repo.getBody());
        Picasso.get().load(repo.getLink()).into(img);

        ImageButton star = holder.itemView.findViewById(R.id.star); star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favorito){
                    favorito = false;
                    star.setImageResource(R.drawable.star_on);
                    Toast.makeText(context.getApplicationContext(),"Añadido a favoritos", Toast.LENGTH_LONG).show();
                }else
                {
                    favorito = true;
                    star.setImageResource(R.drawable.star_off);
                    Toast.makeText(context.getApplicationContext(),"Eliminado de favoritos", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
