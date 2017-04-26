package com.example.android.inclassassignment11_yangy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Item> itemList;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);


        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);

        initItemData();
        adapter=new MyAdapter(itemList,MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    private void initItemData() {
        itemList =new ArrayList<>();

        itemList.add(new Item(getString(R.string.item_one_title),getString(R.string.item_one_desc),R.drawable.image_one));
        itemList.add(new Item(getString(R.string.item_two_title),getString(R.string.item_two_desc),R.drawable.image_two));
        itemList.add(new Item(getString(R.string.item_three_title),getString(R.string.item_three_desc),R.drawable.image_three));
        itemList.add(new Item(getString(R.string.item_four_title),getString(R.string.item_four_desc),R.drawable.image_four));
        itemList.add(new Item(getString(R.string.item_five_title),getString(R.string.item_four_desc),R.drawable.image_five));
        itemList.add(new Item(getString(R.string.item_six_title),getString(R.string.item_six_desc),R.drawable.image_six));
        itemList.add(new Item(getString(R.string.item_seven_title),getString(R.string.item_seven_desc),R.drawable.image_seven));
        itemList.add(new Item(getString(R.string.item_eight_title),getString(R.string.item_eight_desc),R.drawable.image_eight));
        itemList.add(new Item(getString(R.string.item_nine_title),getString(R.string.item_nine_desc),R.drawable.image_nine));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.edit_menu:
                itemList.add(new Item(getString(R.string.item_ten_title),getString(R.string.item_ten_desc),R.drawable.image_ten));
                adapter.notifyItemInserted(itemList.size() - 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
