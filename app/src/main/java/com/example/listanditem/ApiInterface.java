package com.example.listanditem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("cards/{cardId}")
    Observable<DetailedCard> card(@Path("cardId") String cardId);

    @GET("cards?supertype=Pokemon")
    Observable<CardsList> cards();
}
