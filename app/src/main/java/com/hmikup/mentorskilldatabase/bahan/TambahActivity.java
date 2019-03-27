package com.hmikup.mentorskilldatabase.bahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hmikup.mentorskilldatabase.R;
import com.hmikup.mentorskilldatabase.bahan.model.MovieRealm;
import com.hmikup.mentorskilldatabase.bahan.realm.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class TambahActivity extends AppCompatActivity {
    EditText ui_title, ui_release_date,ui_overview,ui_vote_count,ui_poster;
    String title, release_date,overview,vote_count,poster_path;
    Integer id;
    Button btn_tambah;
    RealmHelper realmHelper;
    Realm realm;
    MovieRealm data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);
        btn_tambah=findViewById(R.id.ui_tambah);
        ui_title=findViewById(R.id.ui_title);
        ui_release_date=findViewById(R.id.ui_date);
        ui_overview=findViewById(R.id.ui_overview);
        ui_vote_count=findViewById(R.id.ui_vote);
        ui_poster=findViewById(R.id.ui_url);
        data = new MovieRealm();
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setTitle(ui_title.getText().toString());
                data.setPoster_path(ui_poster.getText().toString());
                data.setVote_count(Integer.parseInt(ui_vote_count.getText().toString()));
                data.setOverview(ui_overview.getText().toString());
                data.setRelease_date(ui_release_date.getText().toString());
                realmHelper.save(data);
                Toast.makeText(TambahActivity.this, "data sudah di save", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TambahActivity.this,MainActivity.class));
            }
        });
    }
}
