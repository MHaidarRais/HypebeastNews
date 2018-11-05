package com.rais.haidar.hypebeastnews.main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rais.haidar.hypebeastnews.R;

public class DetailActivity extends AppCompatActivity {

    TextView txtDetailJudul,txtDetailAuthor,txtDetailDeskripsi;
    ImageView imgDetailBerita;
    Button btnReadFull;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetailAuthor = findViewById(R.id.txtDetailAuthor);
        txtDetailJudul = findViewById(R.id.txtDetailJudul);
        txtDetailDeskripsi = findViewById(R.id.txtDetailDeskripsi);
        imgDetailBerita = findViewById(R.id.detailImgBerita);
        btnReadFull = findViewById(R.id.btnReadFull);

        String detailAuthor = getIntent().getStringExtra("detailAuthor");
        String detailJudul = getIntent().getStringExtra("detailTitle");
        String detailDeskripsi = getIntent().getStringExtra("detailDeskripsi");
        String detailGambar = getIntent().getStringExtra("detailGambar");

        txtDetailAuthor.setText(detailAuthor);
        txtDetailJudul.setText(detailJudul);
        txtDetailDeskripsi.setText(detailDeskripsi);
        Glide.with(this)
                .load(detailGambar)
                .into(imgDetailBerita);

        btnReadFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,WebActivity.class);
                final String detailLink = getIntent().getStringExtra("detailLink");
                intent.putExtra("URL",detailLink);
                context.startActivity(intent);
            }
        });

    }
}
