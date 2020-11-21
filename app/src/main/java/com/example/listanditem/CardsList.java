package com.example.listanditem;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CardsList {

    @SerializedName("cards")
    List<Card> cards;
}
