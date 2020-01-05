package org.junit;

public class Skateboard {

//NONSTATIC VARIABLES
public int speed; //default speed of 10
public double diameter;//default diameter of 3.0
public double margin; //margin of error
public String description; //default description.

//CONSTRUCTORS
		
public Skateboard(){ 
//default skateboard for speed, description, diameter, and margin of error.
	this.speed = 10;
	this.description = "Awesome skateboard";
	this.diameter = 3.0; 
	this.margin = 0.01;
			
}

//NON-STATIC METHODS

public int getSpeed(){
//gets the default speed of 10 and returns it.
	return this.speed;
}


public double getDiameter(){
//gets the default diameter and margin of error and returns it.
	double X = (this.diameter + this.margin);
	return X;
	
}

public double setWheelDiameter(double ND){
//sets the wheel diameter to user input ND(New Diameter) and returns it.
	this.diameter = ND;
	double diameter = getDiameter();
	return diameter;
	
}

public String getDescription(){
//gets the default description and returns it.
	String description = this.description;
	return description;
}

public int setSpeed(int value){
//sets the speed for whatever the input speed is, as long as it's under 100
//mph, otherwise it will keep it at the original default speed.
int originalspeed = 10; 
this.speed = value;
int speed = getSpeed();
if (speed > 100){
	this.speed = 10;
	speed = getSpeed();
	return speed;
}
return speed;
}

public String setDescription(String X){
//sets the description to user defined description X using getDescription
// and returns it.
	this.description = X;
	String description = getDescription();
	return description;
}

public boolean isFast(){
// determines whether the input setSpeed is fast or not and 
//returns a boolean true if it is and false if not.
int boardspeed = setSpeed(speed);
if (boardspeed >= 5){
	return true;
}
return false;
}

}

















