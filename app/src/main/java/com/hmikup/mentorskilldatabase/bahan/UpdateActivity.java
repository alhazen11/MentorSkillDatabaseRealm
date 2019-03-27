package com.hmikup.mentorskilldatabase.bahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hmikup.mentorskilldatabase.R;
import com.hmikup.mentorskilldatabase.bahan.model.MovieRealm;
import com.hmikup.mentorskilldatabase.bahan.realm.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class UpdateActivity extends AppCompatActivity {
    EditText ui_title, ui_release_date,ui_overview,ui_vote_count,ui_poster,ui_id;
    Button btn_tambah;
    RealmHelper realmHelper;
    Realm realm;
    MovieRealm data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);
        btn_tambah=findViewById(R.id.ui_tambah);
        ui_id=findViewById(R.id.ui_id);
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
                realmHelper.update(data);
                Toast.makeText(UpdateActivity.this, "data sudah di update", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this,MainActivity.class));
            }
        });
    }
}
