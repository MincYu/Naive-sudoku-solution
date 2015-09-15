import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author ymc
 *
 */
//CB
public class Sudoku {
	int[][] isSure;
	int[][][] just;
	int[][] answer;
	// MB Sudoku
	public Sudoku(File f) {
		isSure = new int[9][9];
		just = new int[9][9][9];
		answer = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				isSure[i][j] = 0;
				answer[i][j] = 0;
				for (int k = 0; k < 9; k++)
					just[i][j][k] = 1;
			}
		}
		getStatistic(f);
	}
	//ME
	// MB getStatistic
	public void getStatistic(File f) {

		String line = null;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] spl = line.split(" ");
				for (int j = 0; j < 9; j++) {
					answer[i][j] = Integer.parseInt(spl[j]);
					if (answer[i][j] != 0)
						isSure[i][j] = 1;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(answer[i][j] + " ");
			System.out.println();
		}
		System.out.println();
		
	}
	//ME
	// MB fill
	public void fill() {
		
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (isSure[i][j] == 0)
					check(i, j);
				else
					continue;
				for (int k = 0; k < 9; k++) {
					if (just[i][j][k] == 1) {
						answer[i][j] = k + 1;
					
						just[i][j][k] = 0;
						break;
					}
				}
				// 值没有变化说明该情况不行，回溯
				if (answer[i][j] == 0) {
			
					int iTem=i;
					int jTem=j;
					i = Integer.parseInt(getBack(iTem, jTem).substring(0, 1));
					j = Integer.parseInt(getBack(iTem, jTem).substring(1, 2));
					answer[i][j] = 0;
					
					j--;
					
				}
				

			}
			
		}
		for (int i1 = 0; i1< 9; i1++) {
			for (int j1 = 0; j1 < 9; j1++)
				System.out.print(answer[i1][j1] + " ");
			System.out.println();
		}
		System.out.println();
		
	}
	//ME
	// MB getBack
	public String getBack(int i, int j) {
		for(int i1=i;i1<9;i1++){
			if(i1==i){
				for(int j1=j;j1<9;j1++){
					for(int i3=0;i3<9;i3++){
						just[i1][j][i3]=1;
					}
				}
			}
			else{	
				for(int i2=1;i2<9;i2++){
					for(int i3=0;i3<9;i3++){
						just[i1][i2][i3]=1;
					}
				}
			}
		}
		
		if (j == 0 && i > 0) {
			for (int j1 = 8; j1 >= 0; j1--) {
				if (isSure[i - 1][j1] == 0)
					return (i - 1) + "" + j1;
			}
		} else if (j > 0 && i > 0) {
			for (int j2 = j - 1; j2 >= 0; j2--) {
				if (isSure[i][j2] == 0)
					return i + "" + j2;

			}
			for (int j1 = 8; j1 >= 0; j1--) {
				if (isSure[i - 1][j1] == 0)
					return (i - 1) + "" + j1;
			}
		} else {
			for (int j2 = j - 1; j2 >= 0; j2--) {
				if (isSure[i][j2] == 0)
					return i + "" + j2;

			}
		}
		return null;
		
	}
	//ME
	// MB check
	public void check(int i, int j) {
		for (int i1 = 0; i1 < 9; i1++) {
			if (answer[i][i1] != 0) {
				just[i][j][answer[i][i1] - 1] = 0;
			} 
			if (answer[i1][j] != 0)
				just[i][j][answer[i1][j] - 1] = 0;

		}

		if (i >= 0 && i < 3) {
			for (int i2 = 0; i2 < 3; i2++)
				checkY(i, j, i2);
		} else if (i >= 3 && i < 6) {
			for (int i2 = 3; i2 < 6; i2++)
				checkY(i, j, i2);
		} else {
			for (int i2 = 6; i2 < 9; i2++)
				checkY(i, j, i2);
		}

	}
	//ME
	// MB checkY
	public void checkY(int i, int j, int i2) {
		if (j >= 0 && j < 3) {
			for (int k = 0; k < 3; k++)
				if (answer[i2][k] != 0)
					just[i][j][answer[i2][k] - 1] = 0;
		} else if (j >= 3 && j < 6) {
			for (int k = 3; k < 6; k++)
				if (answer[i2][k] != 0)
					just[i][j][answer[i2][k] - 1] = 0;
		} else {
			for (int k = 6; k < 9; k++)
				if (answer[i2][k] != 0)
					just[i][j][answer[i2][k] - 1] = 0;
		}

	}
	//ME
	// MB main
	public static void main(String[] args) {
		File f1 = new File("Test1");
		File f2 = new File("Test2");
		File f3 = new File("Test3");
		Sudoku sudoku1 = new Sudoku(f1);
		sudoku1.fill();
//		Sudoku sudoku2 = new Sudoku(f2);
//		sudoku2.fill();
//		Sudoku sudoku3 = new Sudoku(f3);
//		sudoku3.fill();

	}
	//ME

}
//CE
