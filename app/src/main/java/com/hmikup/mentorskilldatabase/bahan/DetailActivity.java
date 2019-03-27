package com.hmikup.mentorskilldatabase.bahan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hmikup.mentorskilldatabase.R;
import com.hmikup.mentorskilldatabase.bahan.realm.RealmHelper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DetailActivity extends AppCompatActivity {
    TextView ui_title, ui_release_date,ui_overview,ui_vote_count;
    ImageView ui_poster;
    String title, release_date,overview,vote_count,poster_path;
    Integer id;
    Button btn_delete;
    RealmHelper realmHelper;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);
        id = getIntent().getIntExtra("id",0);
        title = getIntent().getStringExtra("title");
        release_date = getIntent().getStringExtra("release_date");
        overview = getIntent().getStringExtra("overview");
        vote_count = getIntent().getStringExtra("vote_count");
        poster_path = getIntent().getStringExtra("poster_path");
        Log.d("titil",""+title);
        btn_delete=findViewById(R.id.ui_delete);
        ui_title=(TextView) findViewById(R.id.ui_title);
        ui_release_date=(TextView) findViewById(R.id.ui_date);
        ui_overview=(TextView) findViewById(R.id.ui_overview);
        ui_vote_count=(TextView) findViewById(R.id.ui_vote);
        ui_poster=(ImageView) findViewById(R.id.ui_poster);
        ui_title.setText("Nama :"+title);
        ui_release_date.setText("Date :"+release_date);
        ui_overview.setText("Overview :"+overview);
        ui_vote_count.setText("Vote :"+vote_count);
        Glide.with(this)
                .load(poster_path)
                .into(ui_poster);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realmHelper.delete(id);
                Toast.makeText(DetailActivity.this, "data sudah di hapus", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailActivity.this,MainActivity.class));
            }
        });
    }
}
