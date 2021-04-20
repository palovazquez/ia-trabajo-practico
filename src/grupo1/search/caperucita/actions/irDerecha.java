package grupo1.search.caperucita.actions;


import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irDerecha extends SearchAction {


	    /**
	     * See comments in the Eat class.
	     */
	    @Override
	    public SearchBasedAgentState execute(SearchBasedAgentState s) {

	        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

	        int row = caperucitaState.getRowPosition();
	        int col = caperucitaState.getColumnPosition();
	        int nextCol = caperucitaState.moverDerecha(row,col);
	        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,nextCol);
	        
	        /* The agent can only go down when the cell is not empty */
	        /* Caperucita sólo puede ir derecha cuando se cumplan las condiciones:
	         * el lobo no esté derecha 
	         * en la posición inmediata de derecha no se encuentre un árbol
	         * cuando no haya duslces en el camino, si hay dulces debería irDerechaYJuyntqarDulces*/
	        /*!!!!!!! Ver el == 0 en irArriba*/
	        if (!caperucitaState.hayLoboDerecha(row,col) && caperucitaState.getBosque()[row][col+1]!=1
	        		&& listaDulces.size()==0) {
	        	caperucitaState.setColumnPosition(caperucitaState.moverDerecha(row,col));
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
	        
	        int nextCol = caperucitaState.moverDerecha(row,col);
	        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,col);
	        /* Caperucita sólo puede ir derecha cuando se cumplan las condiciones:
	         * el lobo no esté derecha 
	         * en la posición inmediata de derecha no se encuentre un árbol
	         * cuando no haya duslces en el camino, si hay dulces debería irDerechaYJuyntqarDulces*/
	        
	        if (!caperucitaState.hayLoboDerecha(row,col) && caperucitaState.getBosque()[row][col+1]!=1
	        		&& listaDulces.size()==0) {
	        	
	        	/*Consultar siguiente linea, ¿no debería modificar sólo el agente en la línea 69?*/
	            //caperucitaState.setColumnPosition(nextCol);
	            environmentState.setAgentPosition(new int[] {row, nextCol});
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
	        return "irDerecha";
	    }
	}