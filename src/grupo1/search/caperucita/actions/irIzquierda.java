package grupo1.search.caperucita.actions;


import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irIzquierda extends SearchAction {


	    /**
	     * See comments in the Eat class.
	     */
	    @Override
	    public SearchBasedAgentState execute(SearchBasedAgentState s) {

	        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

	        int row = caperucitaState.getRowPosition();
	        int col = caperucitaState.getColumnPosition();
	        int nextCol = caperucitaState.moverIzquierda(row,col);
	        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,nextCol);
	        boolean recorri=caperucitaState.recorriCasillero(row,nextCol);
    
	        /* The agent can only go down when the cell is not empty */
	        /* Caperucita sólo puede ir izquierda cuando se cumplan las condiciones:
	         * el lobo no esté izquierda 
	         * en la posición inmediata de izquierda no se encuentre un árbol
	         * cuando no haya duslces en el camino, si hay dulces debería irIzquierdaYJuyntqarDulces*/
	        /*!!!!!!! Ver el == 0 en irArriba*/
	        if (!caperucitaState.hayLoboIzquierda(row,col) && caperucitaState.getBosque()[row][col-1]!=1
	        		&& listaDulces.size()==0&&!recorri && caperucitaState.getVidas()>0) {
	        	
	        	caperucitaState.setColumnPosition(caperucitaState.moverIzquierda(row,col));
	        	caperucitaState.setPosicionLobo(new int[2]);
	        	//caperucitaState.agregarCasilleroRecorrido(row,nextCol);
	        	
	        	//Calculo los casilleros recorridos
		    	int casillerosRecorridos = Math.abs(col - nextCol);
		    	caperucitaState.incrementarDistanciaRecorrida(casillerosRecorridos);
		    	
		    	//Lobo quieto
		        int[] loboQuieto = new int[2];
		        loboQuieto[0]=0;
		        loboQuieto[1]=0;
		        caperucitaState.setPosicionLobo(loboQuieto);
    	
	        	return caperucitaState;
	        }
	        
	        return null;
	    }
	    

	    /**
	     * See comments in the Eat class.
	     */
	    @Override
	    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

	        CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
	        CaperucitaAgentState caperucitaState = ((CaperucitaAgentState) ast);

	        int row = environmentState.getAgentPosition()[0];
	        int col = environmentState.getAgentPosition()[1];
	        
	        int nextCol= caperucitaState.moverIzquierda(row,col);
	        
	        //Calculo los casilleros recorridos
	    	int casillerosRecorridos = Math.abs(col - nextCol);
	    	caperucitaState.incrementarDistanciaRecorrida(casillerosRecorridos);
	        
	        caperucitaState.setColumnPosition(nextCol);
        	caperucitaState.setPosicionLobo(new int[2]);
        	caperucitaState.agregarCasilleroRecorrido(row,nextCol);
  
        	environmentState.setAgentPosition(new int[] {row, nextCol});
	        environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());

	        return environmentState;
	    }

	    /**
	     * See comments in the Eat class.
	     */
	    @Override
	    public Double getCost() {
	        return 0.0;
	    }

	    /**
	     * See comments in the Eat class.
	     */
	    @Override
	    public String toString() {
	        return "irIzquierda";
	    }
	}