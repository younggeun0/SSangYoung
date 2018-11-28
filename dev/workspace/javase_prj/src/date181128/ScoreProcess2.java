package date181128;
// 숙제1
/**
 * 학생의 Oracle, Java, JDBC 과목 점수를 처리하는 프로그램
 * @author owner
 */
public class ScoreProcess2 {
	
	private int total;
	
	private int javaTotal;
	private int oracleTotal;
	private int jdbcTotal;
	
	private int javaHighestScore;
	private int oracleHighestScore;
	private int jdbcHighestScore;
	
	private String topName;
	private int topsTotal;
	private int topsNum;
	
	public void addScore(int score) {
		total += score;
	}
	public int getTotal() {
		return total;
	}
	public void resetTotal() {
		total = 0;
	}
	
	public String[] nameData() {
		String[] name = {"김정운","이재현",
				"정택성","노진경","최지우","김건하"};
		return name;
	}
	public int[][] scoreData() {
		int[][] score = {
			{85, 86, 81},
			{95, 91, 100},
			{89, 71, 59},
			{97, 96, 91},
			{78, 74, 77},
			{100, 95, 68},
		};
		return score;
	}
	

	
	// 1. 각 학생의 평균을 구하여 출력(출력은 소수이하 1자리까지만 출력)
	public double getAvg(int[] score) {
		
		return getTotal()/(double)score.length;
	}
	
	// 2. 각 과목당 총점과 총점의 총점
	public void addJavaTotal(int javaScore) {
		javaTotal += javaScore;
	}
	public void addOracleTotal(int oracleScore) {
		oracleTotal += oracleScore;
	}
	public void addJdbcTotal(int jdbcScore) {
		jdbcTotal += jdbcScore;
	}
	
	public int getJavaTotal() {
		return javaTotal;
	}
	public int getOracleTotal() {
		return oracleTotal;
	}
	public int getJdbcTotal() {
		return jdbcTotal;
	}
	
	// 3. 각 과목당 평균과 전체 평균(전체 평균은 소수이하 두자리 까지 출력)
	public double getJavaAvg(String[] name) {
		return javaTotal/(double)name.length;
	}
	public double getOracleAvg(String[] name) {
		return oracleTotal/(double)name.length;
	}
	public double getJdbcAvg(String[] name) {
		return jdbcTotal/(double)name.length;
	}
	
	// 4. 각 과목당 최고 점수를 출력
	public void setJavaHighestScore(int score) {
		javaHighestScore = score;
	}
	public void setOracleHighestScore(int score) {
		oracleHighestScore = score;
	}
	public void setJdbcHighestScore(int score) {
		jdbcHighestScore = score;
	}
	public int getJavaHighestScore() {
		return javaHighestScore;
	}
	public int getOracleHighestScore() {
		return oracleHighestScore;
	}
	public int getJdbcHighestScore() {
		return jdbcHighestScore;
	}
	
	// 5. 일등 학생의 이름과 총점, 번호
	public void findTop(String[] name, int[][] score) {
		int topOfTotal=0;
		
		for(int i=0; i<name.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				addScore(score[i][j]);
			}
			if(getTotal() > topOfTotal) {
				setTopName(name[i]);
				setTopsTotal(getTotal());
				setTopsNum(i+1);
				topOfTotal = getTotal();
			}
			resetTotal();
		}
	}
	
	public String getTopName() {
		return topName;
	}
	public int getTopsTotal() {
		return topsTotal;
	}
	public int getTopsNum() {
		return topsNum;
	}
	
	public void setTopName(String name) {
		topName = name;
	}
	public void setTopsTotal(int total) {
		topsTotal = total;
	}
	public void setTopsNum(int num) {
		topsNum = num;
	}
	
	// 6. 자바점수만 오름차순 정렬하여 출력
	public void setJavaArray(int score) {
		
	}
	
	public int[] sortJavaScore(int[] javaScore) {
		int temp;
		
		for(int i=0; i<javaScore.length-1; i++) {
			for(int j=i+1; j<javaScore.length; j++) {
				if (javaScore[i] > javaScore[j]) {
					temp = javaScore[i];
					javaScore[i] = javaScore[j];
					javaScore[j] = temp;
				}
			}
		}
		
		return javaScore;
	}
	
	public void printScore(String[] name, int[][] score) {
		// 숙제 1)
		// 모들 일은 합당한 매개변수와 반환형을 사용하여 메소드 정의,
		// 호출하여 사용한다.
		// 1. 각 학생의 평균을 구하여 출력(출력은 소수이하 1자리까지만 출력)

		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점\t평균");
		System.out.println("-----------------------------------------------------");
		
		for(int i=0; i<name.length; i++) {
			System.out.printf("%4d\t%s\t",i+1,name[i]);
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("%4d\t",score[i][j]);
				addScore(score[i][j]);
			}
			System.out.printf("%4d\t%.1f\t\n",getTotal(),getAvg(score[i]));
			resetTotal();
		}
		System.out.println("-----------------------------------------------------");
		
		// 2. 각 과목당 총점과 총점의 총점
		System.out.println("과목총점---------------------------------------------");
		for(int i=0; i<name.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				if(j==0) {	// java
					addJavaTotal(score[i][j]);
				} else if(j==1) {	// oracle
					addOracleTotal(score[i][j]);
				} else if(j==2) {	// jdbc
					addJdbcTotal(score[i][j]);
				}
			}
		}
		System.out.println("자바 총점 : "+getJavaTotal());
		System.out.println("오라클 총점 : "+getOracleTotal());
		System.out.println("JDBC 총점 : "+getJdbcTotal());
		System.out.println("모든과목 총점 : "+(getJavaTotal()
				+getOracleTotal()+getJdbcTotal()));
		
		// 3. 각 과목당 평균과 전체 평균(전체 평균은 소수이하 두자리 까지 출력)
		System.out.println("과목평균---------------------------------------------");
		System.out.printf("자바 평균 : %.2f\n",getJavaAvg(name));
		System.out.printf("오라클 평균 : %.2f\n",getOracleAvg(name));
		System.out.printf("JDBC 평균 : %.2f\n",getJdbcAvg(name));
		System.out.printf("전체 평균 : %.2f\n",
				(getJavaAvg(name)+getOracleAvg(name)+getJdbcAvg(name))/(double)score[0].length);
		
		System.out.println("-----------------------------------------------------");
		
		// 4. 각 과목당 최고 점수를 출력
		for(int i=0; i<name.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				if (j==0) {
					if(score[i][j] > javaHighestScore)
						setJavaHighestScore(score[i][j]);
				} else if (j==1) {
					if(score[i][j] > oracleHighestScore)
						setOracleHighestScore(score[i][j]);
				} else if (j==2) {
					if(score[i][j] > jdbcHighestScore)
						setJdbcHighestScore(score[i][j]);
				}
			}
		}
		System.out.printf("최고점수 자바[%d] 오라클[%d] JDBC[%d]\n", 
				getJavaHighestScore(), getOracleHighestScore(), getJdbcHighestScore());
		
		// 5. 일등 학생의 이름과 총점, 번호
		findTop(name, score);
		System.out.printf("TOP 번호[%d] 이름[%s] 총점[%d]\n", 
				getTopsNum(), getTopName(), getTopsTotal() );
		
		// 6. 자바점수만 오름차순 정렬하여 출력
		// 자바점수만 담는 1차원 배열 javaScore 생성
		int[] javaScore = new int[name.length];
		int idx = 0;
		for(int i=0; i<name.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				if(j==0) {
					javaScore[idx] = score[i][j];
					idx++;
				}
			}
		}
		javaScore = sortJavaScore(javaScore);
		
		System.out.println("오름차순 정렬된 자바점수-----------------------------");
		for(int val : javaScore) {
			System.out.printf("%4d",val);
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		
		// 처리할 데이터 받기
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();
		
		// 처리
		sp2.printScore(name, score);
	}
}
