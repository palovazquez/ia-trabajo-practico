/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros GutiÃ©rrez, Jorge Roa,
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

import java.util.Random;

import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.escenarios.Escenario;

/**
 * This class represents the real world state.
 */
public class CaperucitaEnvironmentState extends EnvironmentState {

    private int[][] bosque;
    private int[] caperucitaPosicion;
    private int[] loboPosicion;
    private int vidas;
    
    private Escenario escenario;

    public CaperucitaEnvironmentState(int[][] b) {
        bosque = b;
    }

    public CaperucitaEnvironmentState(Escenario escenario) {
        bosque = new int[9][14];
        loboPosicion = new int[2];
        caperucitaPosicion = new int[2];
        vidas = 0;
        
        this.escenario=escenario;
        
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    	
    	this.setBosque(escenario.getBosque());
        this.setAgentPosition(escenario.getPosicionInicialCaperucita());
        this.setVidas(escenario.getVidas());
    	this.setLoboPosition(escenario.getPosicionInicialLobo());
    }
    
    public int[] nuevaPosicionLobo() {
    	
    	int[] lobo = new int[2];
    	
    	Random rd = new Random();
    	int f= rd.nextInt(9);
    	int c= rd.nextInt(14);
    	
    	if(bosque[f][c]==CaperucitaPerception.VACIO && !(f==caperucitaPosicion[0]&&c==caperucitaPosicion[1])) {
    		lobo[0]=f;
    		lobo[1]=c;
    		return lobo;
    	}else return nuevaPosicionLobo();
    	
    	
    	//return new int[] {2,5};
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "Posición lobo=\"(" + loboPosicion[0] + "," + "" + loboPosicion[1] + ")\"\n\n";
        
        str = str + "AMBIENTE=\"[ \n";
        
        str = str + "\"[ \n";
        for (int row = 0; row < 9; row++) {
            str = str + "[ ";
            for (int col = 0; col < 14; col++) {
                if (row==loboPosicion[0] && col==loboPosicion[1]) {
                    str = str + "L ";
                }else if(row==caperucitaPosicion[0] && col==caperucitaPosicion[1]){
                    str = str + "C ";                	
                }else {
                    str = str + bosque[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    // The following methods are Caperucita-specific:
    
    public int[] getLoboPosition() {
		return loboPosicion;
	}

	public int[][] getBosque() {
		return bosque;
	}

	public void setBosque(int[][] bosque) {
		this.bosque = bosque;
	}

	public void setLoboPosition(int[] loboPosition) {
		this.loboPosicion = loboPosition;
	}

    public void setWorld(int row, int col, int value) {
        this.bosque[row][col] = value;
    }

    public int[] getAgentPosition() {
        return caperucitaPosicion;
    }

    public void setAgentPosition(int[] agentPosition) {
        this.caperucitaPosicion = agentPosition;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int agentEnergy) {
        this.vidas = agentEnergy;
    }
    
    public int[] getLoboArriba(int row, int col) {
    	
    	int row2= moverArriba(row,col);
    	
    	if(col==this.getLoboPosition()[1]&&(this.getLoboPosition()[0]>=row2&&this.getLoboPosition()[0]<=row)) return this.getLoboPosition();
    	else return null;
    }

    public int[]  getLoboIzquierda(int row, int col) {
    	int col2= moverIzquierda(row,col);

    	if(row==this.getLoboPosition()[0]&&(this.getLoboPosition()[1]>=col2&&this.getLoboPosition()[1]<=col)) return this.getLoboPosition();
    	else return null;
    }

    public int[]  getLoboDerecha(int row, int col) {
    	int col2= moverDerecha(row,col);

    	if(row==this.getLoboPosition()[0]&&(this.getLoboPosition()[1]>=col&&this.getLoboPosition()[1]<=col2)) return this.getLoboPosition();
    	else return null;
    }

    public int[]  getLoboAbajo(int row, int col) {
    	int row2= moverAbajo(row,col);

    	if(col==this.getLoboPosition()[1]&&(this.getLoboPosition()[0]>=row&&this.getLoboPosition()[0]<=row2)) return this.getLoboPosition();
    	else return null;
     }
    
    public int moverArriba(int fila, int columna){
        int f=fila;
           do{
               f=f-1;
           }while (bosque[f][columna]!=1);
           
           return f+1;
       };
       
   public int moverIzquierda(int fila, int columna){
       	int c=columna;
       	do{
       		c=c-1;
       	}while (bosque[fila][c]!=1);
       	        
       	return c+1;
       };
    	    
       public int moverDerecha(int fila, int columna){
       	int c=columna;
       	do{
       		c=c+1;
       		}while (bosque[fila][c]!=1);  
       	return c-1;
       };

       public int moverAbajo(int fila, int columna){
       	int f=fila;
       	do{
       		f=f+1;
       	}while (bosque[f][columna]!=1);
       	
       	return f-1;
       }

    	       
    	       
}
