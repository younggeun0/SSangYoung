package date181128;
// ����1
/**
 * �л��� Oracle, Java, JDBC ���� ������ ó���ϴ� ���α׷�
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
		String[] name = {"������","������",
				"���ü�","������","������","�����"};
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
	

	
	// 1. �� �л��� ����� ���Ͽ� ���(����� �Ҽ����� 1�ڸ������� ���)
	public double getAvg(int[] score) {
		
		return getTotal()/(double)score.length;
	}
	
	// 2. �� ����� ������ ������ ����
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
	
	// 3. �� ����� ��հ� ��ü ���(��ü ����� �Ҽ����� ���ڸ� ���� ���)
	public double getJavaAvg(String[] name) {
		return javaTotal/(double)name.length;
	}
	public double getOracleAvg(String[] name) {
		return oracleTotal/(double)name.length;
	}
	public double getJdbcAvg(String[] name) {
		return jdbcTotal/(double)name.length;
	}
	
	// 4. �� ����� �ְ� ������ ���
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
	
	// 5. �ϵ� �л��� �̸��� ����, ��ȣ
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
	
	// 6. �ڹ������� �������� �����Ͽ� ���
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
		// ���� 1)
		// ��� ���� �մ��� �Ű������� ��ȯ���� ����Ͽ� �޼ҵ� ����,
		// ȣ���Ͽ� ����Ѵ�.
		// 1. �� �л��� ����� ���Ͽ� ���(����� �Ҽ����� 1�ڸ������� ���)

		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
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
		
		// 2. �� ����� ������ ������ ����
		System.out.println("��������---------------------------------------------");
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
		System.out.println("�ڹ� ���� : "+getJavaTotal());
		System.out.println("����Ŭ ���� : "+getOracleTotal());
		System.out.println("JDBC ���� : "+getJdbcTotal());
		System.out.println("������ ���� : "+(getJavaTotal()
				+getOracleTotal()+getJdbcTotal()));
		
		// 3. �� ����� ��հ� ��ü ���(��ü ����� �Ҽ����� ���ڸ� ���� ���)
		System.out.println("�������---------------------------------------------");
		System.out.printf("�ڹ� ��� : %.2f\n",getJavaAvg(name));
		System.out.printf("����Ŭ ��� : %.2f\n",getOracleAvg(name));
		System.out.printf("JDBC ��� : %.2f\n",getJdbcAvg(name));
		System.out.printf("��ü ��� : %.2f\n",
				(getJavaAvg(name)+getOracleAvg(name)+getJdbcAvg(name))/(double)score[0].length);
		
		System.out.println("-----------------------------------------------------");
		
		// 4. �� ����� �ְ� ������ ���
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
		System.out.printf("�ְ����� �ڹ�[%d] ����Ŭ[%d] JDBC[%d]\n", 
				getJavaHighestScore(), getOracleHighestScore(), getJdbcHighestScore());
		
		// 5. �ϵ� �л��� �̸��� ����, ��ȣ
		findTop(name, score);
		System.out.printf("TOP ��ȣ[%d] �̸�[%s] ����[%d]\n", 
				getTopsNum(), getTopName(), getTopsTotal() );
		
		// 6. �ڹ������� �������� �����Ͽ� ���
		// �ڹ������� ��� 1���� �迭 javaScore ����
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
		
		System.out.println("�������� ���ĵ� �ڹ�����-----------------------------");
		for(int val : javaScore) {
			System.out.printf("%4d",val);
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		
		// ó���� ������ �ޱ�
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();
		
		// ó��
		sp2.printScore(name, score);
	}
}
