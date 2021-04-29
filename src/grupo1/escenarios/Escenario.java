package grupo1.escenarios;

import grupo1.search.caperucita.CaperucitaPerception;

public class Escenario {
	private int[][] bosque;
	private int[] posicionInicialCaperucita;
	private int[] posicionInicialLobo;
	private int vidas;
	
	public Escenario(int[][] bosque, int[] posicionInicialCaperucita, int[] posicionInicialLobo, int vidas) {
		super();
		this.bosque = bosque;
		this.posicionInicialCaperucita = posicionInicialCaperucita;
		this.posicionInicialLobo = posicionInicialLobo;
		this.vidas = vidas;
	}
	
	public Escenario() {
		super();
	}

	public int[][] getBosque() {
		return bosque;
	}
	public void setBosque(int[][] bosque) {
		this.bosque = bosque;
	}
	public int[] getPosicionInicialCaperucita() {
		return posicionInicialCaperucita;
	}
	public void setPosicionInicialCaperucita(int[] posicionInicialCaperucita) {
		this.posicionInicialCaperucita = posicionInicialCaperucita;
	}
	public int[] getPosicionInicialLobo() {
		return posicionInicialLobo;
	}
	public void setPosicionInicialLobo(int[] posicionInicialLobo) {
		this.posicionInicialLobo = posicionInicialLobo;
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public int[][] retornarBosque1 (){
		
    	int[][] bosque = new int[9][14];
        bosque[0][0] = CaperucitaPerception.ARBOL;
        bosque[0][1] = CaperucitaPerception.ARBOL;
        bosque[0][2] = CaperucitaPerception.ARBOL;
        bosque[0][3] = CaperucitaPerception.ARBOL;
        bosque[0][4] = CaperucitaPerception.ARBOL;
        bosque[0][5] = CaperucitaPerception.ARBOL;
        bosque[0][6] = CaperucitaPerception.ARBOL;
        bosque[0][7] = CaperucitaPerception.ARBOL;
        bosque[0][8] = CaperucitaPerception.ARBOL;
        bosque[0][9] = CaperucitaPerception.ARBOL;
        bosque[0][10] = CaperucitaPerception.ARBOL;
        bosque[0][11] = CaperucitaPerception.ARBOL;
        bosque[0][12] = CaperucitaPerception.ARBOL;
        bosque[0][13] = CaperucitaPerception.ARBOL;

        bosque[1][0] = CaperucitaPerception.ARBOL;
        bosque[1][1] = CaperucitaPerception.ARBOL;
        bosque[1][2] = CaperucitaPerception.ARBOL;
        bosque[1][3] = CaperucitaPerception.DULCE;
        bosque[1][4] = CaperucitaPerception.VACIO;
        bosque[1][5] = CaperucitaPerception.CAMPOFLORES;
        bosque[1][6] = CaperucitaPerception.VACIO;
        bosque[1][7] = CaperucitaPerception.ARBOL;
        bosque[1][8] = CaperucitaPerception.VACIO;
        bosque[1][9] = CaperucitaPerception.VACIO;
        bosque[1][10] = CaperucitaPerception.DULCE;
        bosque[1][11] = CaperucitaPerception.CAMPOFLORES;
        bosque[1][12] = CaperucitaPerception.ARBOL;
        bosque[1][13] = CaperucitaPerception.ARBOL;

        bosque[2][0] = CaperucitaPerception.ARBOL;
        bosque[2][1] = CaperucitaPerception.ARBOL;
        bosque[2][2] = CaperucitaPerception.ARBOL;
        bosque[2][3] = CaperucitaPerception.VACIO;
        bosque[2][4] = CaperucitaPerception.ARBOL;
        bosque[2][5] = CaperucitaPerception.VACIO;
        bosque[2][6] = CaperucitaPerception.VACIO;
        bosque[2][7] = CaperucitaPerception.VACIO;
        bosque[2][8] = CaperucitaPerception.VACIO;
        bosque[2][9] = CaperucitaPerception.VACIO;
        bosque[2][10] = CaperucitaPerception.VACIO;
        bosque[2][11] = CaperucitaPerception.DULCE;
        bosque[2][12] = CaperucitaPerception.ARBOL;
        bosque[2][13] = CaperucitaPerception.ARBOL;
        
        bosque[3][0] = CaperucitaPerception.ARBOL;
        bosque[3][1] = CaperucitaPerception.ARBOL;
        bosque[3][2] = CaperucitaPerception.ARBOL;
        bosque[3][3] = CaperucitaPerception.VACIO;
        bosque[3][4] = CaperucitaPerception.VACIO;
        bosque[3][5] = CaperucitaPerception.CAMPOFLORES;
        bosque[3][6] = CaperucitaPerception.VACIO;
        bosque[3][7] = CaperucitaPerception.VACIO;
        bosque[3][8] = CaperucitaPerception.VACIO;
        bosque[3][9] = CaperucitaPerception.ARBOL;
        bosque[3][10] = CaperucitaPerception.VACIO;
        bosque[3][11] = CaperucitaPerception.VACIO;
        bosque[3][12] = CaperucitaPerception.ARBOL;
        bosque[3][13] = CaperucitaPerception.ARBOL;

        bosque[4][0] = CaperucitaPerception.ARBOL;
        bosque[4][1] = CaperucitaPerception.ARBOL;
        bosque[4][2] = CaperucitaPerception.ARBOL;
        bosque[4][3] = CaperucitaPerception.ARBOL;
        bosque[4][4] = CaperucitaPerception.ARBOL;
        bosque[4][5] = CaperucitaPerception.VACIO;
        bosque[4][6] = CaperucitaPerception.VACIO;
        bosque[4][7] = CaperucitaPerception.VACIO;
        bosque[4][8] = CaperucitaPerception.ARBOL;
        bosque[4][9] = CaperucitaPerception.VACIO;
        bosque[4][10] = CaperucitaPerception.VACIO;
        bosque[4][11] = CaperucitaPerception.VACIO;
        bosque[4][12] = CaperucitaPerception.ARBOL;
        bosque[4][13] = CaperucitaPerception.ARBOL;

        bosque[5][0] = CaperucitaPerception.ARBOL;
        bosque[5][1] = CaperucitaPerception.ARBOL;
        bosque[5][2] = CaperucitaPerception.ARBOL;
        bosque[5][3] = CaperucitaPerception.VACIO;
        bosque[5][4] = CaperucitaPerception.ARBOL;
        bosque[5][5] = CaperucitaPerception.ARBOL;
        bosque[5][6] = CaperucitaPerception.VACIO;
        bosque[5][7] = CaperucitaPerception.VACIO;
        bosque[5][8] = CaperucitaPerception.VACIO;
        bosque[5][9] = CaperucitaPerception.VACIO;
        bosque[5][10] = CaperucitaPerception.ARBOL;
        bosque[5][11] = CaperucitaPerception.VACIO;
        bosque[5][12] = CaperucitaPerception.ARBOL;
        bosque[5][13] = CaperucitaPerception.ARBOL;
        
        bosque[6][0] = CaperucitaPerception.ARBOL;
        bosque[6][1] = CaperucitaPerception.ARBOL;
        bosque[6][2] = CaperucitaPerception.ARBOL;
        bosque[6][3] = CaperucitaPerception.VACIO;
        bosque[6][4] = CaperucitaPerception.VACIO;
        bosque[6][5] = CaperucitaPerception.ARBOL;
        bosque[6][6] = CaperucitaPerception.ARBOL;
        bosque[6][7] = CaperucitaPerception.ARBOL;
        bosque[6][8] = CaperucitaPerception.VACIO;
        bosque[6][9] = CaperucitaPerception.ARBOL;
        bosque[6][10] = CaperucitaPerception.VACIO;
        bosque[6][11] = CaperucitaPerception.ARBOL;
        bosque[6][12] = CaperucitaPerception.ARBOL;
        bosque[6][13] = CaperucitaPerception.ARBOL;

        bosque[7][0] = CaperucitaPerception.ARBOL;
        bosque[7][1] = CaperucitaPerception.ARBOL;
        bosque[7][2] = CaperucitaPerception.ARBOL;
        bosque[7][3] = CaperucitaPerception.VACIO;
        bosque[7][4] = CaperucitaPerception.VACIO;
        bosque[7][5] = CaperucitaPerception.VACIO;
        bosque[7][6] = CaperucitaPerception.ARBOL;
        bosque[7][7] = CaperucitaPerception.CAMPOFLORES;
        bosque[7][8] = CaperucitaPerception.VACIO;
        bosque[7][9] = CaperucitaPerception.VACIO;
        bosque[7][10] = CaperucitaPerception.VACIO;
        bosque[7][11] = CaperucitaPerception.ARBOL;
        bosque[7][12] = CaperucitaPerception.ARBOL;
        bosque[7][13] = CaperucitaPerception.ARBOL;

        bosque[8][0] = CaperucitaPerception.ARBOL;
        bosque[8][1] = CaperucitaPerception.ARBOL;
        bosque[8][2] = CaperucitaPerception.ARBOL;
        bosque[8][3] = CaperucitaPerception.ARBOL;
        bosque[8][4] = CaperucitaPerception.ARBOL;
        bosque[8][5] = CaperucitaPerception.ARBOL;
        bosque[8][6] = CaperucitaPerception.ARBOL;
        bosque[8][7] = CaperucitaPerception.CAMPOFLORES;
        bosque[8][8] = CaperucitaPerception.ARBOL;
        bosque[8][9] = CaperucitaPerception.ARBOL;
        bosque[8][10] = CaperucitaPerception.ARBOL;
        bosque[8][11] = CaperucitaPerception.ARBOL;
        bosque[8][12] = CaperucitaPerception.ARBOL;
        bosque[8][13] = CaperucitaPerception.ARBOL;
        
		return bosque;
	}

	
	public int[][] retornarBosque2 (){
		
    	int[][] bosque = new int[9][14];
        bosque[0][0] = CaperucitaPerception.ARBOL;
        bosque[0][1] = CaperucitaPerception.ARBOL;
        bosque[0][2] = CaperucitaPerception.ARBOL;
        bosque[0][3] = CaperucitaPerception.ARBOL;
        bosque[0][4] = CaperucitaPerception.ARBOL;
        bosque[0][5] = CaperucitaPerception.ARBOL;
        bosque[0][6] = CaperucitaPerception.ARBOL;
        bosque[0][7] = CaperucitaPerception.ARBOL;
        bosque[0][8] = CaperucitaPerception.ARBOL;
        bosque[0][9] = CaperucitaPerception.ARBOL;
        bosque[0][10] = CaperucitaPerception.ARBOL;
        bosque[0][11] = CaperucitaPerception.ARBOL;
        bosque[0][12] = CaperucitaPerception.ARBOL;
        bosque[0][13] = CaperucitaPerception.ARBOL;

        bosque[1][0] = CaperucitaPerception.ARBOL;
        bosque[1][1] = CaperucitaPerception.ARBOL;
        bosque[1][2] = CaperucitaPerception.ARBOL;
        bosque[1][3] = CaperucitaPerception.ARBOL;
        bosque[1][4] = CaperucitaPerception.ARBOL;
        bosque[1][5] = CaperucitaPerception.DULCE;
        bosque[1][6] = CaperucitaPerception.VACIO;
        bosque[1][7] = CaperucitaPerception.ARBOL;
        bosque[1][8] = CaperucitaPerception.ARBOL;
        bosque[1][9] = CaperucitaPerception.ARBOL;
        bosque[1][10] = CaperucitaPerception.ARBOL;
        bosque[1][11] = CaperucitaPerception.ARBOL;
        bosque[1][12] = CaperucitaPerception.ARBOL;
        bosque[1][13] = CaperucitaPerception.ARBOL;

        bosque[2][0] = CaperucitaPerception.ARBOL;
        bosque[2][1] = CaperucitaPerception.ARBOL;
        bosque[2][2] = CaperucitaPerception.ARBOL;
        bosque[2][3] = CaperucitaPerception.ARBOL;
        bosque[2][4] = CaperucitaPerception.VACIO;
        bosque[2][5] = CaperucitaPerception.VACIO;
        bosque[2][6] = CaperucitaPerception.VACIO;
        bosque[2][7] = CaperucitaPerception.ARBOL;
        bosque[2][8] = CaperucitaPerception.ARBOL;
        bosque[2][9] = CaperucitaPerception.VACIO;
        bosque[2][10] = CaperucitaPerception.ARBOL;
        bosque[2][11] = CaperucitaPerception.ARBOL;
        bosque[2][12] = CaperucitaPerception.ARBOL;
        bosque[2][13] = CaperucitaPerception.ARBOL;
        
        bosque[3][0] = CaperucitaPerception.ARBOL;
        bosque[3][1] = CaperucitaPerception.ARBOL;
        bosque[3][2] = CaperucitaPerception.ARBOL;
        bosque[3][3] = CaperucitaPerception.ARBOL;
        bosque[3][4] = CaperucitaPerception.ARBOL;
        bosque[3][5] = CaperucitaPerception.VACIO;
        bosque[3][6] = CaperucitaPerception.VACIO;
        bosque[3][7] = CaperucitaPerception.VACIO;
        bosque[3][8] = CaperucitaPerception.DULCE;
        bosque[3][9] = CaperucitaPerception.VACIO;
        bosque[3][10] = CaperucitaPerception.VACIO;
        bosque[3][11] = CaperucitaPerception.ARBOL;
        bosque[3][12] = CaperucitaPerception.ARBOL;
        bosque[3][13] = CaperucitaPerception.ARBOL;

        bosque[4][0] = CaperucitaPerception.ARBOL;
        bosque[4][1] = CaperucitaPerception.ARBOL;
        bosque[4][2] = CaperucitaPerception.ARBOL;
        bosque[4][3] = CaperucitaPerception.VACIO;
        bosque[4][4] = CaperucitaPerception.ARBOL;
        bosque[4][5] = CaperucitaPerception.ARBOL;
        bosque[4][6] = CaperucitaPerception.VACIO;
        bosque[4][7] = CaperucitaPerception.ARBOL;
        bosque[4][8] = CaperucitaPerception.VACIO;
        bosque[4][9] = CaperucitaPerception.ARBOL;
        bosque[4][10] = CaperucitaPerception.DULCE;
        bosque[4][11] = CaperucitaPerception.ARBOL;
        bosque[4][12] = CaperucitaPerception.ARBOL;
        bosque[4][13] = CaperucitaPerception.ARBOL;

        bosque[5][0] = CaperucitaPerception.ARBOL;
        bosque[5][1] = CaperucitaPerception.ARBOL;
        bosque[5][2] = CaperucitaPerception.ARBOL;
        bosque[5][3] = CaperucitaPerception.VACIO;
        bosque[5][4] = CaperucitaPerception.VACIO;
        bosque[5][5] = CaperucitaPerception.ARBOL;
        bosque[5][6] = CaperucitaPerception.VACIO;
        bosque[5][7] = CaperucitaPerception.ARBOL;
        bosque[5][8] = CaperucitaPerception.VACIO;
        bosque[5][9] = CaperucitaPerception.ARBOL;
        bosque[5][10] = CaperucitaPerception.VACIO;
        bosque[5][11] = CaperucitaPerception.ARBOL;
        bosque[5][12] = CaperucitaPerception.ARBOL;
        bosque[5][13] = CaperucitaPerception.ARBOL;
        
        bosque[6][0] = CaperucitaPerception.ARBOL;
        bosque[6][1] = CaperucitaPerception.ARBOL;
        bosque[6][2] = CaperucitaPerception.ARBOL;
        bosque[6][3] = CaperucitaPerception.VACIO;
        bosque[6][4] = CaperucitaPerception.VACIO;
        bosque[6][5] = CaperucitaPerception.VACIO;
        bosque[6][6] = CaperucitaPerception.VACIO;
        bosque[6][7] = CaperucitaPerception.VACIO;
        bosque[6][8] = CaperucitaPerception.VACIO;
        bosque[6][9] = CaperucitaPerception.ARBOL;
        bosque[6][10] = CaperucitaPerception.VACIO;
        bosque[6][11] = CaperucitaPerception.ARBOL;
        bosque[6][12] = CaperucitaPerception.ARBOL;
        bosque[6][13] = CaperucitaPerception.ARBOL;

        bosque[7][0] = CaperucitaPerception.ARBOL;
        bosque[7][1] = CaperucitaPerception.ARBOL;
        bosque[7][2] = CaperucitaPerception.ARBOL;
        bosque[7][3] = CaperucitaPerception.ARBOL;
        bosque[7][4] = CaperucitaPerception.ARBOL;
        bosque[7][5] = CaperucitaPerception.ARBOL;
        bosque[7][6] = CaperucitaPerception.CAMPOFLORES;
        bosque[7][7] = CaperucitaPerception.ARBOL;
        bosque[7][8] = CaperucitaPerception.VACIO;
        bosque[7][9] = CaperucitaPerception.VACIO;
        bosque[7][10] = CaperucitaPerception.VACIO;
        bosque[7][11] = CaperucitaPerception.ARBOL;
        bosque[7][12] = CaperucitaPerception.ARBOL;
        bosque[7][13] = CaperucitaPerception.ARBOL;

        bosque[8][0] = CaperucitaPerception.ARBOL;
        bosque[8][1] = CaperucitaPerception.ARBOL;
        bosque[8][2] = CaperucitaPerception.ARBOL;
        bosque[8][3] = CaperucitaPerception.ARBOL;
        bosque[8][4] = CaperucitaPerception.ARBOL;
        bosque[8][5] = CaperucitaPerception.ARBOL;
        bosque[8][6] = CaperucitaPerception.CAMPOFLORES;
        bosque[8][7] = CaperucitaPerception.ARBOL;
        bosque[8][8] = CaperucitaPerception.VACIO;
        bosque[8][9] = CaperucitaPerception.ARBOL;
        bosque[8][10] = CaperucitaPerception.ARBOL;
        bosque[8][11] = CaperucitaPerception.ARBOL;
        bosque[8][12] = CaperucitaPerception.ARBOL;
        bosque[8][13] = CaperucitaPerception.ARBOL;
        
		return bosque;
	}

	public int[][] retornarBosque3 (){
		
    	int[][] bosque = new int[9][14];
        bosque[0][0] = CaperucitaPerception.ARBOL;
        bosque[0][1] = CaperucitaPerception.ARBOL;
        bosque[0][2] = CaperucitaPerception.ARBOL;
        bosque[0][3] = CaperucitaPerception.CAMPOFLORES;
        bosque[0][4] = CaperucitaPerception.ARBOL;
        bosque[0][5] = CaperucitaPerception.ARBOL;
        bosque[0][6] = CaperucitaPerception.ARBOL;
        bosque[0][7] = CaperucitaPerception.ARBOL;
        bosque[0][8] = CaperucitaPerception.ARBOL;
        bosque[0][9] = CaperucitaPerception.ARBOL;
        bosque[0][10] = CaperucitaPerception.ARBOL;
        bosque[0][11] = CaperucitaPerception.ARBOL;
        bosque[0][12] = CaperucitaPerception.ARBOL;
        bosque[0][13] = CaperucitaPerception.ARBOL;

        bosque[1][0] = CaperucitaPerception.ARBOL;
        bosque[1][1] = CaperucitaPerception.ARBOL;
        bosque[1][2] = CaperucitaPerception.ARBOL;
        bosque[1][3] = CaperucitaPerception.CAMPOFLORES;
        bosque[1][4] = CaperucitaPerception.ARBOL;
        bosque[1][5] = CaperucitaPerception.VACIO;
        bosque[1][6] = CaperucitaPerception.VACIO;
        bosque[1][7] = CaperucitaPerception.VACIO;
        bosque[1][8] = CaperucitaPerception.ARBOL;
        bosque[1][9] = CaperucitaPerception.ARBOL;
        bosque[1][10] = CaperucitaPerception.ARBOL;
        bosque[1][11] = CaperucitaPerception.ARBOL;
        bosque[1][12] = CaperucitaPerception.ARBOL;
        bosque[1][13] = CaperucitaPerception.ARBOL;

        bosque[2][0] = CaperucitaPerception.ARBOL;
        bosque[2][1] = CaperucitaPerception.ARBOL;
        bosque[2][2] = CaperucitaPerception.ARBOL;
        bosque[2][3] = CaperucitaPerception.VACIO;
        bosque[2][4] = CaperucitaPerception.ARBOL;
        bosque[2][5] = CaperucitaPerception.VACIO;
        bosque[2][6] = CaperucitaPerception.ARBOL;
        bosque[2][7] = CaperucitaPerception.DULCE;
        bosque[2][8] = CaperucitaPerception.ARBOL;
        bosque[2][9] = CaperucitaPerception.ARBOL;
        bosque[2][10] = CaperucitaPerception.ARBOL;
        bosque[2][11] = CaperucitaPerception.ARBOL;
        bosque[2][12] = CaperucitaPerception.ARBOL;
        bosque[2][13] = CaperucitaPerception.ARBOL;
        
        bosque[3][0] = CaperucitaPerception.ARBOL;
        bosque[3][1] = CaperucitaPerception.ARBOL;
        bosque[3][2] = CaperucitaPerception.ARBOL;
        bosque[3][3] = CaperucitaPerception.VACIO;
        bosque[3][4] = CaperucitaPerception.VACIO;
        bosque[3][5] = CaperucitaPerception.VACIO;
        bosque[3][6] = CaperucitaPerception.VACIO;
        bosque[3][7] = CaperucitaPerception.VACIO;
        bosque[3][8] = CaperucitaPerception.VACIO;
        bosque[3][9] = CaperucitaPerception.ARBOL;
        bosque[3][10] = CaperucitaPerception.VACIO;
        bosque[3][11] = CaperucitaPerception.ARBOL;
        bosque[3][12] = CaperucitaPerception.ARBOL;
        bosque[3][13] = CaperucitaPerception.ARBOL;

        bosque[4][0] = CaperucitaPerception.ARBOL;
        bosque[4][1] = CaperucitaPerception.ARBOL;
        bosque[4][2] = CaperucitaPerception.ARBOL;
        bosque[4][3] = CaperucitaPerception.ARBOL;
        bosque[4][4] = CaperucitaPerception.ARBOL;
        bosque[4][5] = CaperucitaPerception.VACIO;
        bosque[4][6] = CaperucitaPerception.VACIO;
        bosque[4][7] = CaperucitaPerception.VACIO;
        bosque[4][8] = CaperucitaPerception.VACIO;
        bosque[4][9] = CaperucitaPerception.VACIO;
        bosque[4][10] = CaperucitaPerception.VACIO;
        bosque[4][11] = CaperucitaPerception.VACIO;
        bosque[4][12] = CaperucitaPerception.ARBOL;
        bosque[4][13] = CaperucitaPerception.ARBOL;

        bosque[5][0] = CaperucitaPerception.ARBOL;
        bosque[5][1] = CaperucitaPerception.ARBOL;
        bosque[5][2] = CaperucitaPerception.ARBOL;
        bosque[5][3] = CaperucitaPerception.VACIO;
        bosque[5][4] = CaperucitaPerception.VACIO;
        bosque[5][5] = CaperucitaPerception.VACIO;
        bosque[5][6] = CaperucitaPerception.VACIO;
        bosque[5][7] = CaperucitaPerception.ARBOL;
        bosque[5][8] = CaperucitaPerception.VACIO;
        bosque[5][9] = CaperucitaPerception.ARBOL;
        bosque[5][10] = CaperucitaPerception.VACIO;
        bosque[5][11] = CaperucitaPerception.VACIO;
        bosque[5][12] = CaperucitaPerception.ARBOL;
        bosque[5][13] = CaperucitaPerception.ARBOL;
        
        bosque[6][0] = CaperucitaPerception.ARBOL;
        bosque[6][1] = CaperucitaPerception.ARBOL;
        bosque[6][2] = CaperucitaPerception.ARBOL;
        bosque[6][3] = CaperucitaPerception.VACIO;
        bosque[6][4] = CaperucitaPerception.DULCE;
        bosque[6][5] = CaperucitaPerception.VACIO;
        bosque[6][6] = CaperucitaPerception.VACIO;
        bosque[6][7] = CaperucitaPerception.ARBOL;
        bosque[6][8] = CaperucitaPerception.DULCE;
        bosque[6][9] = CaperucitaPerception.VACIO;
        bosque[6][10] = CaperucitaPerception.ARBOL;
        bosque[6][11] = CaperucitaPerception.VACIO;
        bosque[6][12] = CaperucitaPerception.ARBOL;
        bosque[6][13] = CaperucitaPerception.ARBOL;

        bosque[7][0] = CaperucitaPerception.ARBOL;
        bosque[7][1] = CaperucitaPerception.ARBOL;
        bosque[7][2] = CaperucitaPerception.ARBOL;
        bosque[7][3] = CaperucitaPerception.ARBOL;
        bosque[7][4] = CaperucitaPerception.ARBOL;
        bosque[7][5] = CaperucitaPerception.ARBOL;
        bosque[7][6] = CaperucitaPerception.VACIO;
        bosque[7][7] = CaperucitaPerception.VACIO;
        bosque[7][8] = CaperucitaPerception.VACIO;
        bosque[7][9] = CaperucitaPerception.ARBOL;
        bosque[7][10] = CaperucitaPerception.ARBOL;
        bosque[7][11] = CaperucitaPerception.ARBOL;
        bosque[7][12] = CaperucitaPerception.ARBOL;
        bosque[7][13] = CaperucitaPerception.ARBOL;

        bosque[8][0] = CaperucitaPerception.ARBOL;
        bosque[8][1] = CaperucitaPerception.ARBOL;
        bosque[8][2] = CaperucitaPerception.ARBOL;
        bosque[8][3] = CaperucitaPerception.ARBOL;
        bosque[8][4] = CaperucitaPerception.ARBOL;
        bosque[8][5] = CaperucitaPerception.ARBOL;
        bosque[8][6] = CaperucitaPerception.ARBOL;
        bosque[8][7] = CaperucitaPerception.ARBOL;
        bosque[8][8] = CaperucitaPerception.ARBOL;
        bosque[8][9] = CaperucitaPerception.ARBOL;
        bosque[8][10] = CaperucitaPerception.ARBOL;
        bosque[8][11] = CaperucitaPerception.ARBOL;
        bosque[8][12] = CaperucitaPerception.ARBOL;
        bosque[8][13] = CaperucitaPerception.ARBOL;
        
		return bosque;
	}

	
}
