package com.hmikup.mentorskilldatabase.bahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hmikup.mentorskilldatabase.R;
import com.hmikup.mentorskilldatabase.bahan.model.MovieRealm;
import com.hmikup.mentorskilldatabase.bahan.realm.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    List<MovieRealm> movieModels;
    Button ui_tambah,ui_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        recyclerView = findViewById(R.id.ui_list_movie);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        realmHelper = new RealmHelper(realm);
        movieModels = new ArrayList<>();
        movieModels = realmHelper.getMovie();
        ui_tambah=findViewById(R.id.ui_tambah);
        ui_update=findViewById(R.id.ui_update);
        if(realmHelper.getMovie().size()!=0){
            show();
        }
        Log.d("test",""+realmHelper.getMovie().size());
        ui_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TambahActivity.class));
            }
        });
        ui_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UpdateActivity.class));
            }
        });
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        if(realmHelper.getMovie().size()!=0){
            movieAdapter.notifyDataSetChanged();
            show();
        }
    }

    public void show(){
        movieAdapter = new MovieAdapter(this, movieModels);
        recyclerView.setAdapter(movieAdapter);
    }
}
