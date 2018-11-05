package com.rais.haidar.hypebeastnews.main.view;

import com.rais.haidar.hypebeastnews.Base.BaseView;
import com.rais.haidar.hypebeastnews.main.model.ArticlesItem;

import java.util.List;

public interface MainView extends BaseView {
    void onSuccess(List<ArticlesItem> data);
    void onError(String msg);

}
