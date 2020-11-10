package com.example.pmd_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
	private String wikipediaLink;
	private MediaPlayer animalSoundPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		ConstraintLayout layout = findViewById(R.id.clDetail);
		TextView name = findViewById(R.id.detailName);
		ImageView image = findViewById(R.id.detailImage);
		TextView funFact = findViewById(R.id.funFact);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String animalName = extras.getString("animalName");
			name.setText(animalName);
			String bgColor = extras.getString("backgroundColor");
			layout.setBackgroundColor(Color.parseColor(bgColor));
			int imageId = extras.getInt("animalImageID");
			image.setImageResource(imageId);
			wikipediaLink = extras.getString("wikipediaLink");
			int factId = getStringIdentifier(animalName);
			if (factId != 0) {
				funFact.setText(getText(factId));
			}
			int soundId = extras.getInt("animalSoundID");
			animalSoundPlayer = MediaPlayer.create(this, soundId);
		}

		Button wikiButton = findViewById(R.id.wikipediaButton);
		wikiButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Uri url = Uri.parse(wikipediaLink);
				Intent webIntent = new Intent(Intent.ACTION_VIEW, url);
				startActivity(webIntent);
			}
		});

		ImageButton soundButton = findViewById(R.id.soundButton);
		soundButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				animalSoundPlayer.start();
			}
		});
	}

	private int getStringIdentifier(String animalName){
		String resourceName = "funfact_" + animalName;
		return getResources().getIdentifier(resourceName, "string", getPackageName());
	}
}