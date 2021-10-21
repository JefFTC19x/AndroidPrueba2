package com.JeffTorres.primeraappv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.JeffTorres.primeraappv1.Adapter.RepositoryAdapter;
import com.JeffTorres.primeraappv1.Entidades.Repository;
import com.JeffTorres.primeraappv1.servicios.BeeCeptor;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
   //List<Repository> animes = Arrays.asList(new Repository("A","B"));

   //List<String> links = Arrays.asList("One Piece","Naruto","Dragonball Z","Dragonball Super","Bleach","Fairy Tail","Akame Ga Kill","Parasyte","Kuroko no Basket","Attack on Titan");



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.Lista);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //.baseUrl("https://api.github.com/")
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://exament3prueba.free.beeceptor.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BeeCeptor service =retrofit.create(BeeCeptor.class);

        service.allRepos().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {

                if(response.code() == 200) {
                    Log.i("Estado de Conexión",String.valueOf(response.code()));

                    RepositoryAdapter adapter = new RepositoryAdapter(response.body());
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.i("Estado de Conexión",t.toString());
                Log.i("Main_App","Fallo de conexión" );
            }
        });
       // List<Repository> animes = Arrays.asList(new Repository("A","B"));
        //RepositoryAdapter adapter= new RepositoryAdapter(animes);
       // rv.setAdapter(adapter);


    }
}