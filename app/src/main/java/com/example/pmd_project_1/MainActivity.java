package com.example.pmd_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pmd_project_1.classes.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {
	RecyclerViewAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// data to populate the RecyclerView with
		ArrayList<Animal> animalList = new ArrayList<>();
		animalList.add(new Animal("Crocodile", R.drawable.crocodile, "https://en.wikipedia.org/wiki/Crocodile", R.raw.crocodile));
		animalList.add(new Animal("Elephant", R.drawable.elephant, "https://en.wikipedia.org/wiki/Elephant", R.raw.elephant));
		animalList.add(new Animal("Fox", R.drawable.fox, "https://en.wikipedia.org/wiki/Fox", R.raw.fox));
		animalList.add(new Animal("Koala", R.drawable.koala, "https://en.wikipedia.org/wiki/Koala", R.raw.koala));
		animalList.add(new Animal("Owl", R.drawable.owl, "https://en.wikipedia.org/wiki/Owl", R.raw.owl));
		animalList.add(new Animal("Panda", R.drawable.panda, "https://en.wikipedia.org/wiki/Panda", R.raw.panda));
		animalList.add(new Animal("Raccoon", R.drawable.raccoon, "https://en.wikipedia.org/wiki/Raccoon", R.raw.raccoon));
		animalList.add(new Animal("Sloth", R.drawable.sloth, "https://en.wikipedia.org/wiki/Sloth", R.raw.sloth));
		animalList.add(new Animal("Tiger", R.drawable.tiger, "https://en.wikipedia.org/wiki/Tiger", R.raw.tiger));
		animalList.add(new Animal("Gorilla", R.drawable.gorilla, "https://en.wikipedia.org/wiki/Gorilla", R.raw.gorilla));
		// set up the RecyclerView
		RecyclerView recyclerView = findViewById(R.id.rvAnimals);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		adapter = new RecyclerViewAdapter(this, animalList);
		adapter.setClickListener(this);
		recyclerView.setAdapter(adapter);
	}
	@Override
	public void onItemClick(View view, int position) {
		Toast.makeText(this, "Showing information about " + adapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
		Intent detail = new Intent(MainActivity.this, DetailActivity.class);
		detail.putExtra("animalName", adapter.getItem(position).getName());
		detail.putExtra("animalImageID", adapter.getItem(position).getImageId());
		detail.putExtra("wikipediaLink", adapter.getItem(position).getWikipediaLink());
		detail.putExtra("animalSoundID", adapter.getItem(position).getSoundId());
		detail.putExtra("backgroundColor", adapter.getColor(position));
		startActivity(detail);
	}
}