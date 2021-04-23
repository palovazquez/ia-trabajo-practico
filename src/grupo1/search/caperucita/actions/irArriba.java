package grupo1.search.caperucita.actions;

import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irArriba extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        int row = caperucitaState.getRowPosition();
        int col = caperucitaState.getColumnPosition();
        int nextRow = caperucitaState.moverArriba(row,col);
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(nextRow,col);
        
        /* The agent can only go up when the cell is not empty */
        if (!caperucitaState.hayLoboArriba(row,col) && caperucitaState.getBosque()[row-1][col]!=CaperucitaPerception.ARBOL
        		&& listaDulces.size()==0) {
        	
        	caperucitaState.setRowPosition(caperucitaState.moverArriba(row,col));
        	caperucitaState.setPosicionLobo(null);
        	
        	return caperucitaState;
        }
        
        return null;
    }
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
        CaperucitaAgentState caperucitaState = ((CaperucitaAgentState) ast);

        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];
        
        int nextRow = caperucitaState.moverArriba(row, col);
        /*ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,col);
        
        if (!caperucitaState.hayLoboArriba(row,col) && caperucitaState.getBosque()[row-1][col]==0
        		&& listaDulces.size()==0) {
        /*	
        caperucitaState.setRowPosition(row);*/

        caperucitaState.setRowPosition(nextRow);
        environmentState.setAgentPosition(new int[] {nextRow, col});
        environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());
        //}*/
  
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
        return "irArriba";
    }
}
