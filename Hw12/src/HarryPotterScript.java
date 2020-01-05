import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
//login(s): eu6
public class HarryPotterScript {
	private ArrayList<ScriptLine> script = new ArrayList<ScriptLine>();

	public static void main(String[] args) {
		HarryPotterScript s = new HarryPotterScript();
		DirectedWeightedGraph<String,ArrayList<String>> graph = new EdgeList<String, ArrayList<String>>();
		Iterator<ScriptLine> currentLines = s.script.iterator();
		Iterator<ScriptLine> nextLines = s.script.iterator();
		nextLines.next(); // Advance nextLines by 1.
		while (nextLines.hasNext()) {
			// get the current line (speaker)
			ScriptLine lineK = currentLines.next();
			String speaker1 = lineK.getSpeaker();
			String text = lineK.getText();
			int textLength = text.length();

			// get the next line (speaker)
			ScriptLine lineKplus1 = nextLines.next();
			String speaker2 = lineKplus1.getSpeaker();

			// remove the edge if it exists
			ArrayList<String> currentEdge = graph.removeEdge(speaker1, speaker2);
			// update the value in the edge (to 1 if a new edge or +1 otherwise)
			if (currentEdge == null) {
				ArrayList<String> tempEdge = new ArrayList<String>();
				tempEdge.add(text);
				currentEdge = tempEdge;
			} else {
				currentEdge.add(text);
			}
			// add the updated edge back into the graph!
			graph.addEdge(speaker1, speaker2, currentEdge);

		}
		// Note: We lose the last line b/c there isn't a next speaker
		ScriptLine lastLine = currentLines.next();
		System.out.println(lastLine.getSpeaker() + ": " + lastLine.getText());
		
		System.out.println("Hermione to Ron: " + graph.getEdge("Hermione", "Ron"));
		System.out.println("Hermione to Harry: " + graph.getEdge("Hermione", "Harry"));
	}

	public HarryPotterScript() {
		BufferedReader br = null;
		try {
			URL path = HarryPotterScript.class
					.getResource("HarryPotter_PhilosophersStone.txt");
			File myFile = new File(path.getFile().replaceAll("%20", " "));
			br = new BufferedReader(new FileReader(myFile));
			br.readLine(); // ignore the first line
			String line = br.readLine();
			while (line != null) {
				String[] splitLine = line.split(":");
				switch (splitLine.length) {
				case 0: // no text (i.e., spacing between lines)
				case 1: // no speaker (i.e., non-spoken description)
					break;
				case 2: // regular spoken text
					this.addLine(new ScriptLine(splitLine[0], splitLine[1]));
					break;
				default:
					// error (this shouldn't happen)
					System.exit(1);
				}

				line = br.readLine();
			}

		} catch (FileNotFoundException e) { // Error handling
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close(); // Close the file if it was opened
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void addLine(ScriptLine newLine) {
		int lastIndex = this.script.size() - 1;
		if (lastIndex >= 0) {
			ScriptLine lastLine = this.script.get(lastIndex);
			if (lastLine.getSpeaker().equals(newLine.getSpeaker())) {
				lastLine.addText(newLine.getText());
				return;
			}
		}
		this.script.add(newLine);
	}
}