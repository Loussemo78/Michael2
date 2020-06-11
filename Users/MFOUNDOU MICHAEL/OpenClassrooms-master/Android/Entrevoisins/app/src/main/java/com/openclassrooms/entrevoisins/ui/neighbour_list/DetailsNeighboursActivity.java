package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class DetailsNeighboursActivity extends AppCompatActivity {

    private NeighbourApiService mApiService;
    ImageView imgNeighbour;
    TextView txtNeighbour;
    TextView txtTitre;
    TextView txtAdress;
    TextView txtTel;
    TextView txtEmail;
    ImageView ButtonReturn;
    FloatingActionButton FavButton;
    Neighbour neighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_neighbours);



        imgNeighbour = (ImageView)findViewById(R.id.imgNeighbour);
        txtNeighbour = (TextView)findViewById(R.id.txtNeighbour);
        txtTitre = (TextView)findViewById(R.id.txtTitre);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtAdress = (TextView) findViewById(R.id.txtAdress);
        txtTel = (TextView) findViewById(R.id.txtTel);

        mApiService = DI.getNeighbourApiService();
        neighbour = (Neighbour) getIntent().getSerializableExtra("detail");
        Glide.with(this).load(neighbour.getAvatarUrl()).into(imgNeighbour);

        txtNeighbour.setText(neighbour.getName());
        txtTitre.setText(neighbour.getName());
        txtEmail.setText(txtEmail.getText());

        ButtonReturn = (ImageView)findViewById(R.id.ButtonReturn);
        ButtonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        FavButton = (FloatingActionButton)findViewById(R.id.FavButton);
        if(neighbour.isFavoris()==false){
            FavButton.setImageResource(R.drawable.ic_stars_black_24dp);
        }else FavButton.setImageResource(R.drawable.ic_stars_yellow_24dp);


        FavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (neighbour.isFavoris()==false){
                    mApiService.changeFavorites(neighbour);
                    FavButton.setImageResource(R.drawable.ic_stars_yellow_24dp);
                }
                else if (neighbour.isFavoris()==true){
                   mApiService.changeFavorites(neighbour);
                   FavButton.setImageResource(R.drawable.ic_stars_black_24dp);
                }
            }
        });
    }

    }
