package com.example.pmd_project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		ConstraintLayout layout = findViewById(R.id.clDetail);
		TextView name = findViewById(R.id.detailName);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String animalName = extras.getString("animalName");
			name.setText(animalName);
			String bgColor = extras.getString("backgroundColor");
			layout.setBackgroundColor(Color.parseColor(bgColor));
		}
	}
}