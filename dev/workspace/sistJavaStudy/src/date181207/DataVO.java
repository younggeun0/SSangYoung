package date181207;

public class DataVO {

	private String name;
	private int score;
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	// getter
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	public DataVO() {
		this.name = "¹«¸í";
		this.score = 0;
	}
	
	public DataVO(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
