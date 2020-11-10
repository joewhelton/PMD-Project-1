package com.example.pmd_project_1.classes;

public class Animal {
	private String name;
	private int imageId;
	private String wikipediaLink;

	public Animal(String name, int imageId, String wikipediaLink){
		this.name = name;
		this.imageId = imageId;
		this.wikipediaLink = wikipediaLink;
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
}
