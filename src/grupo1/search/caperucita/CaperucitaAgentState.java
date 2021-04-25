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
    private ArrayList<int[]> casillerosRecorridos;
    private int vidas;
    
    private Escenario escenario;

    public CaperucitaAgentState(int[][] b, int row, int col,int d, int v, ArrayList<int[]> cr) {
        bosque = b;
        posicionActual = new int[] {row, col};
        posicionInicial = new int[2];
        posicionLobo = new int[2];
        casillerosRecorridos = cr;
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
        casillerosRecorridos = new ArrayList<>();
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

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                newWorld[row][col] = bosque[row][col];
            }
        }

        int[] newPosition = new int[2];
        newPosition[0] = posicionActual[0];
        newPosition[1] = posicionActual[1];
/*
    	System.out.print("CLONE ----- \n");
    	for(int[] c :casillerosRecorridos) {
    		System.out.print(c[0]+" "+c[1]+" - ");
    	}
    	System.out.print("\n");
*/
        CaperucitaAgentState newState = new CaperucitaAgentState(newWorld,
                newPosition[0], newPosition[1],this.cantidadDulces, this.vidas,this.casillerosRecorridos);
        newState.setPosicionLobo(posicionLobo);
        
        return newState;
    }

    /**
     * This method is used to update the Caperucita State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        CaperucitaPerception caperucitaPerception = (CaperucitaPerception) p;
        
        if(caperucitaPerception.isLoboArriba()!=null) {
        	this.posicionLobo[0] = caperucitaPerception.isLoboArriba()[0];
        	this.posicionLobo[1]  = caperucitaPerception.isLoboArriba()[1];
        
        }else if(caperucitaPerception.isLoboAbajo()!=null) {
           	this.posicionLobo[0] = caperucitaPerception.isLoboAbajo()[0];
           	this.posicionLobo[1]  = caperucitaPerception.isLoboAbajo()[1];
       	
        }else if(caperucitaPerception.isLoboDerecha()!=null) {
         	this.posicionLobo[0] = caperucitaPerception.isLoboDerecha()[0];
            this.posicionLobo[1]  = caperucitaPerception.isLoboDerecha()[1];
        
       	}else if(caperucitaPerception.isLoboIzquierda()!=null) {
        	this.posicionLobo[0] = caperucitaPerception.isLoboIzquierda()[0];
           	this.posicionLobo[1]  = caperucitaPerception.isLoboIzquierda()[1];  
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
        this.setPosicionLobo(new int[2]);
        this.agregarCasilleroRecorrido(5, 11);;
        
    }
    
    public ArrayList<int[]> getCasillerosRecorridos() {
		return casillerosRecorridos;
	}

	public void setCasillerosRecorridos(ArrayList<int[]> casillerosRecorridos) {
		this.casillerosRecorridos = casillerosRecorridos;
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

        str = str + " Posición=\"(" + getRowPosition() + "," + "" + getColumnPosition() + ")\"";
        str = str + " Cantidad Dulces=\"" + cantidadDulces + "\"";
        str = str + " Vidas=\"" + vidas + "\"";

        if(posicionLobo==null) str = str + " Posición Lobo=? \n";
        else str = str + " Posición lobo=\"(" + posicionLobo[0] + "," + "" + posicionLobo[1] + ")\"\n\n";
        
        str = str + "BOSQUE=\"[ \n";
        for (int row = 0; row < 9; row++) {
            str = str + "[ ";
            for (int col = 0; col < 14; col++) {
                
            	if (row==posicionLobo[0] && col==posicionLobo[1]) {           			
            		if (posicionLobo[0]!=0 && posicionLobo[1]!=0) {           			
                        str = str + "L ";	
            		}else str = str + bosque[row][col] + " ";
	
                }else if(row==getRowPosition() && col==getColumnPosition()){
                    str = str + "C ";
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

//        int[][] worldObj = ((CaperucitaAgentState) obj).getWorld();
        int[] positionObj = ((CaperucitaAgentState) obj).getPosition();

        /*
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 14; col++) {
                if (bosque[row][col] != worldObj[row][col]) {
                    return false;
                }
            }
        }*/

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
    
	public boolean hayLoboArriba(int fila, int columna) {
		int f = moverArriba(fila,columna);
		
		if(posicionLobo[0]!=0&&posicionLobo[1]!=0) {
			if(posicionLobo[1]==columna) {
			      for(int i=0; i<fila-f;i++){
			            if(posicionLobo[0]==(fila-i)) return true;
			       };
			}return false;
			
		}else return false;
	}
	
	public boolean hayLoboAbajo(int fila, int columna) {
		int f = moverAbajo(fila,columna);
		
		if(posicionLobo!=null) {
			if(posicionLobo[1]==columna) {
			      for(int i=0; i<f-fila;i++){
			            if(posicionLobo[0]==(fila+i)) return true;
			       };
			}return false;	
		}else return false;
	}
	
	public boolean hayLoboDerecha(int fila, int columna) {
		int c = moverDerecha(fila,columna);
		
		if(posicionLobo!=null) {
			if(posicionLobo[0]==fila) {
			      for(int i=0; i<c-columna;i++){
			            if(posicionLobo[1]==(columna+i)) return true;
			       };
			}return false;
				
		}else return false;
	}
	
	public boolean hayLoboIzquierda(int fila, int columna) {
		int c = moverIzquierda(fila,columna);
		
		if(posicionLobo!=null) {
			if(posicionLobo[0]==fila) {
			      for(int i=0; i<columna-c;i++){
			            if(posicionLobo[1]==(columna-i)) return true;
			       };
			}return false;
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
		int menor,valorCelda;
		
		if(posicionAnterior[0]==posicionNueva[0]){
			
			menor=Math.min(posicionNueva[1], posicionAnterior[1]);
			
			for(int i=0;i<=Math.abs(posicionNueva[1]-posicionAnterior[1]);i++){
				
				valorCelda=bosque[posicionAnterior[0]][menor+i];
				
				if(valorCelda==2) listaDulces.add(new int[] {posicionAnterior[0], menor+i});
			}
		}

		if(posicionAnterior[1]==posicionNueva[1]){
			menor=Math.min(posicionNueva[0], posicionAnterior[0]);			

			for(int i=0;i<=Math.abs(posicionNueva[0]-posicionAnterior[0]);i++){
				valorCelda = bosque[menor+i][posicionAnterior[1]];
				
				if(valorCelda==2) {
					listaDulces.add(new int[] {menor+i, posicionNueva[1]});
				}
			}
		}
		
		return listaDulces;
	};
	
	public boolean llegoCampoFlores() {
		int valorCelda =bosque[posicionActual[0]][posicionActual[1]];
		if(valorCelda==3) return true;
		else return false;
	}
	
	public boolean tieneVidas() {
		if(vidas>0) return true;
		else return false;
	}

	public boolean recorriCasillero(int row, int col) {
		
		for(int[] c:this.casillerosRecorridos) if(c[0]==row&&c[1]==col) return true;
		
		return false;
	}

	public void agregarCasilleroRecorrido(int row, int col) {
		this.casillerosRecorridos.add(new int[]{row,col});
	}

	public double getDistancia() {
    	int[] celdaCampoFlores = this.posCampoFlores();
    	double distancia = Math.sqrt(Math.pow(celdaCampoFlores[0]-posicionActual[0],2)+Math.pow(celdaCampoFlores[1]-posicionActual[1],2)); 
        return distancia; 	
    }
	
	public int[] posCampoFlores() {
    	int[] celdaCampoFlores = new int[2];
    	 for (int row = 0; row < 9; row++) {
    		 for (int col = 0; col < 14; col++) {
    			 if (bosque[row][col] == 3){
    				 celdaCampoFlores[0] = row;
    				 celdaCampoFlores[1] = col;
    				 return celdaCampoFlores;
    			 }
             }
    	 }
    	 return celdaCampoFlores;
    }
    	
}

