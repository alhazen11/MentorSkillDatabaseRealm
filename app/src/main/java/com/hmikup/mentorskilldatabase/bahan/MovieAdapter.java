package com.hmikup.mentorskilldatabase.bahan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hmikup.mentorskilldatabase.R;
import com.hmikup.mentorskilldatabase.bahan.model.MovieRealm;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<MovieRealm> movieModels;
    Context context;

    public MovieAdapter(Context context, List<MovieRealm> movieModels) {
        this.context = context;
        this.movieModels = movieModels;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {
        final MovieRealm model = movieModels.get(position);
        holder.id.setText(""+model.getId());
        holder.nama.setText(model.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("title", model.getTitle());
                intent.putExtra("release_date", model.getRelease_date());
                intent.putExtra("overview", model.getOverview());
                intent.putExtra("vote_count", model.getVote_count());
                intent.putExtra("poster_path", model.getPoster_path());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, nama;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.ui_id);
            nama = itemView.findViewById(R.id.ui_nama);
        }
    }
}