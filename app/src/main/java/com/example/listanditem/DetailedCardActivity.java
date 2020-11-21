package com.example.listanditem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DetailedCardActivity extends AppCompatActivity {

    TextView detailedCardText;
    TextView detailedCardId;
    ImageView detailedCardImg;
    ApiInterface api;
    private CompositeDisposable disposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_card);
        detailedCardText = findViewById(R.id.detailedCardText);
        detailedCardId = findViewById(R.id.detailedCardId);
        detailedCardImg = findViewById(R.id.detailedCardImg);
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
        if (getIntent().getExtras() != null){
            disposables.add(
                    api.card(getIntent().getStringExtra("cardId"))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    (detailedCard) -> {
                                        detailedCardText.setText("Имя покемона: " + detailedCard.card.name);
                                        detailedCardId.setText("ID покемона: " + detailedCard.card.id);
                                        Glide.with(this).load(detailedCard.card.imageUrl).into(detailedCardImg);
                                    },
                                    (error) -> {
                                        error.printStackTrace();
                                        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    }));
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}