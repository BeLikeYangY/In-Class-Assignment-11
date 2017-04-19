package com.example.android.inclassassignment11_yangy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    private ImageView itemPhoto;
    private TextView itemTitle;
    private TextView itemDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        itemPhoto= (ImageView) findViewById(R.id.item_info_photo);
        itemTitle= (TextView) findViewById(R.id.item_info_title);
        itemDesc= (TextView) findViewById(R.id.item_info_desc);

        Intent intent=getIntent();

        Item item= (Item) intent.getSerializableExtra("Item");
        itemPhoto.setImageResource(item.getPhotoId());
        itemTitle.setText(item.getTitle());
        itemDesc.setText(item.getDesc());

    }
}
