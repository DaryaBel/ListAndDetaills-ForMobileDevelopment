package com.example.listanditem;

import com.google.gson.annotations.SerializedName;

//import org.jetbrains.annotations.NotNull;
//
//import java.text.SimpleDateFormat;
//import java.util.Locale;

public class DetailedCard {
    @SerializedName("imageUrlHiRes")
    String imageUrl;

    @SerializedName("id")
    int id;

    @SerializedName("types")
    String types;

    @SerializedName("name")
    String name;
}
