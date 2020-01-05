import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SpampedeBrain - The "View" in MVC
 * 
 * @author CS60 instructors
 */
public class SpampedeDisplay {

	private SpampedeData theData;
	private Graphics theScreen;
	private int width;
	private int height;
	public static Image imageSpam;

	// Constructor
	public SpampedeDisplay(SpampedeData theMazeInput, Graphics theScreenInput,
			int widthInput, int heightInput) {
		this.theScreen = theScreenInput;
		this.theData = theMazeInput;
		this.height = heightInput;
		this.width = widthInput;
	}

	/************************************
	 * Displaying the board
	 ************************************/
	// Draw the visuals other than the buttons!
	void updateGraphics() {
		this.clear(); // Do not remove! Required for graphics!
		this.displayTitle();
		
		
		for (int i = 0; i < Preferences.NUM_CELLS_TALL; i++){
			for (int m = 0; m < Preferences.NUM_CELLS_WIDE; m++){
			
				if (this.theData.getCell(i,m).isWall()==true){
					this.drawSquare(m*10,i*10, Preferences.COLOR_WALL);
				}
				if (this.theData.getCell(i, m).isBody()==true){
					this.drawSquare(m*10,i*10, Preferences.COLOR_BODY);
				}
				if (this.theData.getCell(i, m).isHead()==true){
					this.drawSquare(m*10,i*10, Preferences.COLOR_HEAD);
				}
				 if (this.theData.getCell(i, m).isOpen()==true){
					this.drawSquare(m*10,i*10, Preferences.COLOR_OPEN);
				}
				 if (this.theData.getCell(i, m).isSpam()==true){
					 this.drawSquare(m*10,i*10, Preferences.COLOR_SPAM);
				 }
	
				
		}
	}
	
	
			
		// Draw the board
		// TODO: Add your code here :) 
		// The method drawSquare (below) will likely be helpful :) 
		
		// Example of displaying an image
		if (SpampedeDisplay.imageSpam != null) {
			this.theScreen.drawImage(SpampedeDisplay.imageSpam, 500, 100, null);
		}
		if (this.theData.getGameOver()) {
			this.displayGameOver();
		}

	}

	// Drawing helper method
	public void drawSquare(int x, int y, Color cellColor) {
		this.theScreen.setColor(cellColor);
		this.theScreen.fillRect(x + Preferences.WIDTHVAL, y + Preferences.HEIGHTVAL, Preferences.CELL_SIZE,
				Preferences.CELL_SIZE);
	}

	// Do not modify. Draws the background.
	void clear() {
		this.theScreen.setColor(Preferences.COLOR_BACKGROUND);
		this.theScreen.fillRect(0, 0, this.width, this.height);
		this.theScreen.setColor(Preferences.TITLE_COLOR);
		this.theScreen.drawRect(0, 0, this.width - 1,
				Preferences.GAMEBOARDHEIGHT - 1);
	}

	/************************************
	 * Text Display
	 ************************************/
	// title display
	public void displayTitle() {
		this.theScreen.setFont(Preferences.TITLE_FONT);
		this.theScreen.setColor(Preferences.TITLE_COLOR);
		this.theScreen.drawString(Preferences.TITLE, Preferences.TITLE_X,
				Preferences.TITLE_Y);
	}

	// Game Over display
	public void displayGameOver() {
		this.theScreen.setFont(Preferences.GAME_OVER_FONT);
		this.theScreen.setColor(Preferences.GAME_OVER_COLOR);
		this.theScreen.drawString(Preferences.GAME_OVER_TEXT,
				Preferences.GAME_OVER_X, Preferences.GAME_OVER_Y);
	}

}
