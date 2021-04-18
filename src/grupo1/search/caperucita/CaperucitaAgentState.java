/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Guti√©rrez, Jorge Roa,
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

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import grupo1.escenarios.Escenario;

/**
 * Represent the internal state of the Caperucita.
 */
public class CaperucitaAgentState extends SearchBasedAgentState {

    private int[][] bosque;
    private int[] posicionActual;
    private int[] posicionInicial;
    private int[] posicionLobo;
    private int cantidadDulces;
    private int vidas;
    
    private Escenario escenario;

    public CaperucitaAgentState(int[][] b, int row, int col,int d, int v) {
        bosque = b;
        posicionActual = new int[] {row, col};
        posicionInicial = new int[2];
        posicionInicial[0] = row;
        posicionInicial[1] = col;
        cantidadDulces = d;
        vidas = v;
    }

    public CaperucitaAgentState(Escenario escenario) {
        bosque = new int[9][14];
        posicionActual = new int[2];
        posicionInicial = new int[2];
        posicionLobo = new int[2];
        cantidadDulces = 0;
        vidas = 0;
        this.escenario=escenario;
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        int[][] newWorld = new int[9][14];

        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                newWorld[row][col] = bosque[row][col];
            }
        }

        int[] newPosition = new int[2];
        newPosition[0] = posicionActual[0];
        newPosition[1] = posicionActual[1];

        CaperucitaAgentState newState = new CaperucitaAgentState(newWorld,
                this.getRowPosition(), this.getColumnPosition(),this.cantidadDulces, this.vidas);
        
        return newState;
    }

    /**
     * This method is used to update the Caperucita State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        CaperucitaPerception caperucitaPerception = (CaperucitaPerception) p;
        
        if(caperucitaPerception.isLoboArriba()||caperucitaPerception.isLoboAbajo()||caperucitaPerception.isLoboIzquierda()||caperucitaPerception.isLoboDerecha()) {
            int rowLobo = this.getPosicionLobo()[0];
            int colLobo = this.getPosicionLobo()[1];
        	
            bosque[rowLobo][colLobo]=2;
        }
        
        vidas = caperucitaPerception.getVidas();
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {

    	this.setBosque(escenario.getBosque());
        this.setRowPosition(escenario.getPosicionInicialCaperucita()[0]);
        this.setColumnPosition(escenario.getPosicionInicialCaperucita()[1]);
        this.setCantidadDulces(0);
        this.setVidas(escenario.getVidas());
    }
    
    public int[][] getBosque() {
		return bosque;
	}

	public void setBosque(int[][] bosque) {
		this.bosque = bosque;
	}

	/**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        str = str + " position=\"(" + getRowPosition() + "," + "" + getColumnPosition() + ")\"";
        str = str + " energy=\"" + vidas + "\"\n";

        str = str + "world=\"[ \n";
        for (int row = 0; row < bosque.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + bosque[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]\"";

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CaperucitaAgentState))
            return false;

        int[][] worldObj = ((CaperucitaAgentState) obj).getWorld();
        int[] positionObj = ((CaperucitaAgentState) obj).getPosition();

        for (int row = 0; row < bosque.length; row++) {
            for (int col = 0; col < bosque.length; col++) {
                if (bosque[row][col] != worldObj[row][col]) {
                    return false;
                }
            }
        }

        if (posicionActual[0] != positionObj[0] || posicionActual[1] != positionObj[1]) {
            return false;
        }
        
        return true;
    }

    // The following methods are Caperucita-specific:
    
    public int[][] getWorld() {
        return bosque;
    }

    public int getWorldPosition(int row, int col) {
        return bosque[row][col];
    }

    public void setWorldPosition(int row, int col, int value) {
        this.bosque[row][col] = value;
    }

    public int[] getPosition() {
        return posicionActual;
    }

    public void setRowPosition(int value) {
        this.posicionActual[0] = value;
    }

    public void setColumnPosition(int value) {
        this.posicionActual[1] = value;
    }

    public int getRowPosition() {
        return posicionActual[0];
    }

    public int getColumnPosition() {
        return posicionActual[1];
    }
    

   /*
    public int[] getPosicionAnterior() {
		return posicionAnterior;
	}

	public void setPosicionAnterior(int[] posicionAnterior) {
		this.posicionAnterior = posicionAnterior;
	}
*/
    
	public int[] getPosicionLobo() {
		return posicionLobo;
	}

	public void setPosicionLobo(int[] posicionLobo) {
		this.posicionLobo = posicionLobo;
	}

	public int getCantidadDulces() {
		return cantidadDulces;
	}

	public void setCantidadDulces(int cantidadDulces) {
		this.cantidadDulces = cantidadDulces;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
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
    }
    
	public boolean hayLoboArriba(int fila, int columna) {
		int f = moverArriba(fila,columna);
		if(posicionLobo[1]==columna) {
		      for(int i=0; i<fila-f;i++){
		    	  // proxima lÌnea no deberÌa ser fila - 1
		            if(posicionLobo[0]==(fila+i)) return true;
		       };
		       return false;
		}else return false;
	}
	
	
	public boolean hayLoboAbajo(int fila, int columna) {
		int f = moverAbajo(fila,columna);
		if(posicionLobo[1]==columna) {
		      for(int i=0; i<f-fila;i++){
		            if(posicionLobo[0]==(fila+i)) return true;
		       };
		       return false;
		}else return false;
	}
	
	public boolean hayLoboDerecha(int fila, int columna) {
		int c = moverDerecha(fila,columna);
		if(posicionLobo[0]==fila) {
		      for(int i=0; i<c-columna;i++){
		            if(posicionLobo[1]==(columna+i)) return true;
		       };
		       return false;
		}else return false;
	}
	
	public boolean hayLoboIzquierda(int fila, int columna) {
		int c = moverIzquierda(fila,columna);
		if(posicionLobo[0]==fila) {
		      for(int i=0; i<columna-c;i++){
		            if(posicionLobo[1]==(columna-i)) return true;
		       };
		       return false;
		}else return false;
	}
	
	
	
	
	
	
	
	
	
	
/*
	public ArrayList<int[]> pasoPorDulce(){
		ArrayList<int[]> listaDulces = new ArrayList<>();

		if(posicionAnterior[0]==posicionActual[0]){
			for(int i=0;i<Math.abs(posicionActual[1]-posicionAnterior[1]);i++){
				if(bosque[posicionAnterior[0]][Math.min(posicionActual[1], posicionAnterior[1])+i]==2) listaDulces.add(new int[] {posicionAnterior[0], Math.min(posicionActual[1], posicionAnterior[1])+i});
			}
		}

		if(posicionAnterior[1]==posicionActual[1]){
			for(int i=0;i<Math.abs(posicionActual[0]-posicionAnterior[0]);i++){
				if(bosque[Math.min(posicionActual[0], posicionAnterior[0])+i][posicionAnterior[1]]==2) listaDulces.add(new int[] {posicionAnterior[0], Math.min(posicionActual[1], posicionAnterior[1])+i});
			}
		}
		
		return listaDulces;
	};
*/
	public ArrayList<int[]> pasoPorDulce(int nextRow,int nextCol){
		
		
		ArrayList<int[]> listaDulces = new ArrayList<>();
		int[] posicionAnterior = new int[] {posicionActual[0],posicionActual[1]};
		int[] posicionNueva = new int[] {nextRow,nextCol};
		
		
		if(posicionAnterior[0]==posicionNueva[0]){
			for(int i=0;i<Math.abs(posicionNueva[1]-posicionAnterior[1]);i++){
				if(bosque[posicionAnterior[0]][Math.min(posicionNueva[1], posicionAnterior[1])+i]==2) listaDulces.add(new int[] {posicionAnterior[0], Math.min(posicionNueva[1], posicionAnterior[1])+i});
			}
		}

		if(posicionAnterior[1]==posicionNueva[1]){
			for(int i=0;i<Math.abs(posicionNueva[0]-posicionAnterior[0]);i++){
				if(bosque[Math.min(posicionNueva[0], posicionAnterior[0])+i][posicionAnterior[1]]==2) listaDulces.add(new int[] {posicionAnterior[0], Math.min(posicionNueva[1], posicionAnterior[1])+i});
			}
		}
		
		return listaDulces;
	};
	
	public boolean llegoCampoFlores() {
		if(bosque[posicionActual[0]][posicionActual[1]]==3) return true;
		else return false;
	}
	
	public boolean tieneVidas() {
		if(vidas>0) return true;
		else return false;
	}	
}

