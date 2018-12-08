package date181208;

public class DataVO {
	private String name;
	private int score;
	
	public DataVO() { }
	
	public DataVO(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
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
}
