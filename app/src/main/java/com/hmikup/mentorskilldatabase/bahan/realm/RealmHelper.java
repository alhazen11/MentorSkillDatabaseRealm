package com.hmikup.mentorskilldatabase.bahan.realm;
import android.util.Log;

import com.hmikup.mentorskilldatabase.bahan.model.MovieRealm;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final MovieRealm movieModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(MovieRealm.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    movieModel.setId(nextId);
                    MovieRealm model = realm.copyToRealm(movieModel);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<MovieRealm> getMovie(){
        RealmResults<MovieRealm> results = realm.where(MovieRealm.class).findAll();
        return results;
    }

    // untuk meng-update data
    public void update(final MovieRealm data){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MovieRealm model = realm.where(MovieRealm.class)
                        .equalTo("id", data.getId())
                        .findFirst();
                model.setAdult(data.getAdult());
                model.setId(data.getId());
                model.setOriginal_language(data.getOriginal_language());
                model.setOverview(data.getOverview());
                model.setBackdrop_path(data.getBackdrop_path());
                model.setOriginal_title(data.getOriginal_title());
                model.setPopularity(data.getPopularity());
                model.setRelease_date(data.getRelease_date());
                model.setVote_average(data.getVote_average());
                model.setVote_count(data.getVote_count());
                model.setPoster_path(data.getPoster_path());
                model.setTitle(data.getTitle());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    // untuk menghapus data
    public void delete(Integer id){
        final RealmResults<MovieRealm> model = realm.where(MovieRealm.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}
