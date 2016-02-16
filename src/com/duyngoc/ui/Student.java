package com.duyngoc.ui;

import java.util.List;

import javax.swing.JTable;

public class Student {
	
	private static final int MAX = 10;
	private int firstName;

	public int getFirstName() {
		return firstName;
	}

	public void setFirstName(int firstName) {
		this.firstName = firstName;
	}

	public int getLastName() {
		return lastName;
	}

	public void setLastName(int lastName) {
		this.lastName = lastName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public static int getMax() {
		return MAX;
	}

	private int lastName;
	private int ID;
	private String email;
	private String Address;
	private boolean goodStudent;
	private String name;
	private String street;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

	private double math;
	private double english;

	public Student() {

	}

	public Student(int id, String name, double math, double english, String street, String city) {
		/*
		 * this.firstName = ran; this.lastName = ran; this.ID = ran; if (ran
		 * <=50){ this.Address = "a"; this.email = "a";
		 * this.setGoodStudent(true); } else{ this.Address ="b"; this.email =
		 * "b"; this.setGoodStudent(false); }
		 */
		this.street = street;
		this.city = city;
		this.ID = id;
		this.name = name;
		this.math = math;
		this.english = english;

	}

	public boolean isGoodStudent() {
		return goodStudent;
	}

	public void setGoodStudent(boolean goodStudent) {
		this.goodStudent = goodStudent;
	}
}