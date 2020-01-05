public class ScriptLine {
	
	private String speaker;
	private String text;
	public ScriptLine(String speakerInput, String textInput){
		this.speaker = speakerInput;
		this.text = textInput;
	}
	public String getSpeaker(){
		return this.speaker;
	}
	public String getText(){
		return this.text;
	}
	public void addText(String input){
		this.text = this.text + input;
	}
		public String toString(){
		return this.text;
	}
}