package grupo1.search.caperucita.actions;


import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irAbajo extends SearchAction {


	    /**
	     * See comments in the Eat class.
	     */
	    @Override
	    public SearchBasedAgentState execute(SearchBasedAgentState s) {

	        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

	        int row = caperucitaState.getRowPosition();
	        int col = caperucitaState.getColumnPosition();
	        int nextRow = caperucitaState.moverAbajo(row,col);
	        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(nextRow,col);
	        
	        /* The agent can only go down when the cell is not empty */
	        /* Caperucita sólo puede ir abajo cuando se cumplan las condiciones:
	         * el lobo no esté abajo 
	         * en la posición inmediata de abajo no se encuentre un árbol
	         * cuando no haya duslces en el camino, si hay dulces debería irAbajoYJuyntqarDulces*/
	        /*!!!!!!! Ver el == 0 en irArriba*/
	        if (!caperucitaState.hayLoboAbajo(row,col) && caperucitaState.getBosque()[row+1][col]!=1
	        		&& listaDulces.size()==0) {
	        	caperucitaState.setRowPosition(caperucitaState.moverAbajo(row,col));
	        	caperucitaState.setPosicionLobo(null);
	        	
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
	        
	        row = caperucitaState.moverAbajo(row,col);
	        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,col);
	        /* Caperucita sólo puede ir abajo cuando se cumplan las condiciones:
	         * el lobo no esté abajo 
	         * en la posición inmediata de abajo no se encuentre un árbol
	         * cuando no haya duslces en el camino, si hay dulces debería irAbajoYJuyntqarDulces*/
	        
	        if (!caperucitaState.hayLoboAbajo(row,col) && caperucitaState.getBosque()[row+1][col]!=1
	        		&& listaDulces.size()==0) {
	        	
	        	/*Consultar siguiente linea, ¿no debería modificar sólo el agente en la línea 69?*/
	            caperucitaState.setRowPosition(row);
	            environmentState.setAgentPosition(new int[] {row, col});
	            environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());
	        }
	  
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
	        return "irAbajo";
	    }
	}