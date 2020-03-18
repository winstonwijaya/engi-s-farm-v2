/*! File: Matriks.java */

import engisjava.src.renderable.cell.Cell;

class Matriks {
	private final int N = 11;
	private final int M = 11;
	private Cell[][] Mat;
	
	public Matriks() {
		Mat = new Cell[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Mat[i][j] = new Cell(i, j, false);
			}
		}
	}
	
	public int getBrs() {
		return N;
	}
	
	public int getKol() {
		return M;
	}
	
	public char getData(int b, int k) {
		return Mat[b][k].render();
	}
	
	public Cell getCell(int b, int k) {
		return Mat[b][k];
	}

	public void setData(int b, int k, Cell x) {
		Mat[b][k] = x;
	}
}
