package com.example.listanditem;

import com.google.gson.annotations.SerializedName;

//import org.jetbrains.annotations.NotNull;
//
//import java.text.SimpleDateFormat;
//import java.util.Locale;

public class Card {

    @SerializedName("imageUrl")
    String imageUrl;

    @SerializedName("id")
    Integer id;

}
