package com.JeffTorres.primeraappv1.servicios;

import com.JeffTorres.primeraappv1.Entidades.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  BeeCeptor
{
    @GET("/exament3parte2")
    Call<List<Repository>> allRepos();
}
