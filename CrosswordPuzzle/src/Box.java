
public class Box {

	private char answer;
	private boolean used;
	public char input = ' ';
	
	public Box() {used = false; this.answer = ' ';}
	public Box(char answer) {
		this.answer = answer;
		this.used = true;
	}
	public void changeAnswer(char a) {
		this.used = true;
		this.answer = a;
	}
	public boolean isUsed() {
		return used;
	}
	
	public char getAnswer() {return answer;}
}
