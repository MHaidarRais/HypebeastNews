package com.rais.haidar.hypebeastnews.main.presenter;

import com.rais.haidar.hypebeastnews.Base.BasePresenter;
import com.rais.haidar.hypebeastnews.Network.configNetwork;
import com.rais.haidar.hypebeastnews.main.model.ArticlesItem;
import com.rais.haidar.hypebeastnews.main.model.ResponseHypebeast;
import com.rais.haidar.hypebeastnews.main.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String apikey = "5h30dB4K4Uwuhj4KkmHmFkrBzQHtf2wGPVQSARoCa+HgMHZRk0/vFn0ZKpFDgc1KYy/F7LEE8nAOHhKgru6btQ==";

    public Call<ResponseHypebeast> call() {
        return configNetwork.getInstance().getHypebeast();
    }

    public void getData(){
        call().enqueue(new Callback<ResponseHypebeast>() {
            @Override
            public void onResponse(Call<ResponseHypebeast> call, Response<ResponseHypebeast> response) {
                if (response.body().getStatus().equalsIgnoreCase("ok")){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSuccess(articlesItems);
                }else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseHypebeast> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }
}
