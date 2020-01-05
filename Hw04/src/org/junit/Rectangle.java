package org.junit;

public class Rectangle {
//Rectangle objects should be able to report their area, perimeter,
//and whether or not they overlap with another Rectangle object.
//Rectangle objects can be created by providing a Rectangle constructor 
//a height and width or by providing a Rectangle constructor a height,
//width, and x and y coordinates of the bottom left corner of the rectangle.
//If the x and y coordinates are not provided, the Rectangle's bottom left
//corner should be at (0, 0). You can assume that the top and bottom edges
//of the rectangles are parallel to the x-axis.


//CLASS VARIABLES
public Rectangle coordinates;
//INSTANCE VARIABLES
int height;
int width;
int blxcord;
int blycord;

//RECTANGLE CONSTRUCTORS
public Rectangle(){
	this.height = 5; //default height of 5
	this.width = 10;//default width of 10
	this.blxcord = 0;//default x coordinate of 0
	this.blycord = 5;//default y coordinate of 5
    
	
}

//NON-STATIC METHODS
public int getWidth(){//gets whatever the current width is set at.
	return this.width;
}

public int getHeight(){//gets whatever the current height is set at.
	return this.height;
}

public int getxcord(){//gets whatever the current x coordinate is set at.
	return this.blxcord;
}

public int getycord(){//gets whatever the current y coordinate is set at.
	return this.blycord;
}



public int getArea(){//gets the area based on the current height and width.
return this.height*this.width;
}

public int getPerimeter(){//gets the perimeter based on the current height and width.
return (2*this.height) + (2*this.width);

}

public int setWidth(int widthvalue){//sets the width to a certain value and gets it with getWidth().
	this.width = widthvalue;
	int updatewidth = getWidth();
	return updatewidth;
}


public int setHeight(int heightvalue){//sets the height to a certain value and gets it with getHeight().
	this.height = heightvalue;
	int updateheight = getHeight();
	return updateheight;
}
public boolean checkoverlap(Rectangle r){//checks the overlap of the rectangles based on the x and y coordinates of the lower left corner of the newly created rectangle r.
	if (this.blxcord < r.blxcord && this.blxcord + this.width > r.blxcord);{
		if (this.blycord < r.blycord && this.blycord + this.height > r.blycord){
			return true;
		}
		return false;
	}
}
		

public int setArea(int h, int w){ //sets the area based on a new height and width.
	this.height = h;
	this.width = w;
	int updatedh = getHeight();
	int updatedw = getWidth();
	int updatedarea = updatedh * updatedw;
	return updatedarea;
	
}

public int setPerim(int h, int w){//sets the perimeter based on a new height and width.
	this.height = h;
	this.width = w;
	int updatedh = getHeight();
	int updatedw = getWidth();
	int updatedperim = (2*updatedh) + (2*updatedw);
	return updatedperim;
}




























}