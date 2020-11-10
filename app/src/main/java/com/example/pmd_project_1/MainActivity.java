package com.example.pmd_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {
	RecyclerViewAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
// data to populate the RecyclerView with
		String[] animalNames = {"Crocodile", "Elephant", "Fox", "Gorilla", "Koala", "Owl", "Panda", "Raccoon", "Sloth", "Tiger"};
		int[] images = {R.drawable.crocodile, R.drawable.elephant, R.drawable.fox, R.drawable.gorilla, R.drawable.koala, R.drawable.owl, R.drawable.panda, R.drawable.raccoon, R.drawable.sloth, R.drawable.tiger};
// set up the RecyclerView
		RecyclerView recyclerView = findViewById(R.id.rvAnimals);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		adapter = new RecyclerViewAdapter(this, animalNames, images);
		adapter.setClickListener(this);
		recyclerView.setAdapter(adapter);
	}
	@Override
	public void onItemClick(View view, int position) {
		Toast.makeText(this, "Showing information about " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
		Intent detail = new Intent(MainActivity.this, DetailActivity.class);
		detail.putExtra("animalName", adapter.getItem(position));
		detail.putExtra("animalImageID", adapter.getImage(position));
		detail.putExtra("backgroundColor", adapter.getColor(position));
		startActivity(detail);
	}
}