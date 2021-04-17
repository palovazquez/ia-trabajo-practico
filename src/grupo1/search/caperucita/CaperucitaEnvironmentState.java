/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
 * Luis Ignacio Larrateguy y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package grupo1.search.caperucita;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class CaperucitaEnvironmentState extends EnvironmentState {

    private int[][] bosque;
    private int[] agentPosition;
    private int[] loboPosition;
    private int vidas;

    public CaperucitaEnvironmentState(int[][] b) {
        bosque = b;
    }

    public CaperucitaEnvironmentState() {
        bosque = new int[9][14];
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        // Sets all cells as empty
        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                bosque[row][col] = CaperucitaPerception.VACIO;
            }
        }

        /* Sets some cells with foods and enemies. */
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
        bosque[1][3] = CaperucitaPerception.VACIO;
        bosque[1][4] = CaperucitaPerception.VACIO;
        bosque[1][5] = CaperucitaPerception.VACIO;
        bosque[1][6] = CaperucitaPerception.VACIO;
        bosque[1][7] = CaperucitaPerception.ARBOL;
        bosque[1][8] = CaperucitaPerception.VACIO;
        bosque[1][9] = CaperucitaPerception.VACIO;
        bosque[1][10] = CaperucitaPerception.VACIO;
        bosque[1][11] = CaperucitaPerception.ARBOL;
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
        bosque[2][11] = CaperucitaPerception.VACIO;
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
        bosque[5][10] = CaperucitaPerception.VACIO;
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
        bosque[7][7] = CaperucitaPerception.VACIO;
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
        bosque[8][7] = CaperucitaPerception.ARBOL;
        bosque[8][8] = CaperucitaPerception.VACIO;
        bosque[8][9] = CaperucitaPerception.ARBOL;
        bosque[8][10] = CaperucitaPerception.ARBOL;
        bosque[8][11] = CaperucitaPerception.ARBOL;
        bosque[8][12] = CaperucitaPerception.ARBOL;
        bosque[8][13] = CaperucitaPerception.ARBOL;

        this.setAgentPosition(new int[]{5, 11});
        this.setLoboPosition(new int[]{6, 4});
        this.setVidas(3);
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "[ \n";
        for (int row = 0; row < bosque.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < bosque.length; col++) {
                str = str + bosque[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
    }

    // The following methods are Caperucita-specific:

    
    
    
    public int[] getLoboPosition() {
		return loboPosition;
	}

	public int[][] getBosque() {
		return bosque;
	}

	public void setBosque(int[][] bosque) {
		this.bosque = bosque;
	}

	public void setLoboPosition(int[] loboPosition) {
		this.loboPosition = loboPosition;
	}

    public void setWorld(int row, int col, int value) {
        this.bosque[row][col] = value;
    }

    public int[] getAgentPosition() {
        return agentPosition;
    }

    public void setAgentPosition(int[] agentPosition) {
        this.agentPosition = agentPosition;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int agentEnergy) {
        this.vidas = agentEnergy;
    }
    
    public boolean getLoboArriba(int row, int col) {
    	
    	int row2= moverArriba(row,col);

    	if(col==this.getLoboPosition()[1]&&(this.getLoboPosition()[0]>=row2&&this.getLoboPosition()[0]<=row)) return true;
    	else return false;
    }

    public boolean getLoboIzquierda(int row, int col) {
    	int col2= moverIzquierda(row,col);

    	if(row==this.getLoboPosition()[1]&&(this.getLoboPosition()[0]>=col2&&this.getLoboPosition()[0]<=col)) return true;
    	else return false;
    }

    public boolean getLoboDerecha(int row, int col) {
    	int col2= moverAbajo(row,col);

    	if(row==this.getLoboPosition()[1]&&(this.getLoboPosition()[0]>=col&&this.getLoboPosition()[0]<=col2)) return true;
    	else return false;
    }

    public boolean getLoboAbajo(int row, int col) {
    	int row2= moverArriba(row,col);

    	if(col==this.getLoboPosition()[1]&&(this.getLoboPosition()[0]>=row&&this.getLoboPosition()[0]<=row2)) return true;
    	else return false;
     }
    
    public int moverArriba(int fila, int columna){
        int f=fila;
           do{
               f=f-1;
           }while (bosque[f][columna]==0);
           
           return f;
       };
       
    public int moverIzquierda(int fila, int columna){
    	int c=columna;
    	do{
    		c=c-1;
    	}while (bosque[fila][c]==0);
    	        
    	return c;
    };
    	    
    public int moverDerecha(int fila, int columna){
    	int c=columna;
    	do{
    		c=c+1;
    		}while (bosque[fila][c]==0);  
    	return c;
    };

    public int moverAbajo(int fila, int columna){
    	int f=fila;
    	do{
    		f=f+1;
    	}while (bosque[f][columna]==0);
    	
    	return f;
    };

    	       
    	       
}
