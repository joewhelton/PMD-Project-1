package com.example.pmd_project_1.classes;

public class Animal {
	private String name;
	private int imageId;
	private String wikipediaLink;

	private int soundId;

	public Animal(String name, int imageId, String wikipediaLink, int soundId){
		this.name = name;
		this.imageId = imageId;
		this.wikipediaLink = wikipediaLink;
		this.soundId = soundId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getWikipediaLink() {
		return wikipediaLink;
	}

	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}

	public int getSoundId() {
		return soundId;
	}

	public void setSoundId(int soundId) {
		this.soundId = soundId;
	}
}
