package com.example.pmd_project_1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmd_project_1.classes.Animal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
	private ArrayList<Animal> animalList;
	private LayoutInflater mInflater;
	private ItemClickListener mClickListener;
	private String[] colorList = {"#a8e6cfff", "#dcedc1ff", "#ffd3b6ff", "#ffaaa5ff"};
	private ArrayList<String> backgroundColorMap;
	private int color = 0;

	RecyclerViewAdapter(Context context, ArrayList<Animal> animalList) {
		this.mInflater = LayoutInflater.from(context);
		this.animalList = animalList;
		this.backgroundColorMap = new ArrayList<String>();
	}
	// inflates the row layout from xml when needed
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view =	mInflater.inflate(R.layout.recyclerview_row, parent,false);
		view.setBackgroundColor(Color.parseColor(colorList[color]));
		backgroundColorMap.add(colorList[color]);
		color = ((color + 1) % colorList.length);
		return new ViewHolder(view);
	}
	// binds the data to the TextView in each row
	@Override
	public void onBindViewHolder(ViewHolder holder, int	position) {
		holder.myTextView.setText(animalList.get(position).getName());
		holder.myImage.setImageResource(animalList.get(position).getImageId());
	}
	// total number of rows
	@Override
	public int getItemCount() {
		return animalList.size();
	}

	// stores and recycles views as they are scrolled off screen
	public class ViewHolder extends	RecyclerView.ViewHolder implements View.OnClickListener {
		TextView myTextView;
		ImageView myImage;
		ViewHolder(View itemView) {
			super(itemView);
			myTextView = itemView.findViewById(R.id.tvAnimalName);
			myImage = itemView.findViewById(R.id.imgAnimal);
			itemView.setOnClickListener(this);
		}
		@Override
		public void onClick(View view) {
			if (mClickListener != null)
				mClickListener.onItemClick(view, getAdapterPosition());
		}
	}
// convenience method for getting data at click	position
	Animal getItem(int id) {
		return animalList.get(id);
	}

	String getColor(int id){
		return backgroundColorMap.get(id);
	}
	// allows clicks events to be caught
	void setClickListener(ItemClickListener itemClickListener) {
		this.mClickListener = itemClickListener;
	}
	// parent activity will implement this method to respond to click events
	public interface ItemClickListener {
		void onItemClick(View view, int position);
	}
}