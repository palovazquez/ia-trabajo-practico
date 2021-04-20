package grupo1.search.caperucita.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irAbajoJuntarDulce extends SearchAction {

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
        int [][] bosque = caperucitaState.getBosque();
     
        /* Caperucita sólo puede ir abajo cuando se cumplan las condiciones:
         * el lobo no esté abajo 
         * en la posición inmediata de abajo no se encuentre un árbol
         * cuando haya dulces en el camino, si no hay dulces debería sólo irAbajo*/
        if (!caperucitaState.hayLoboAbajo(row,col) && caperucitaState.getBosque()[row+1][col]!=1
        		&& listaDulces.size()>0) {
        	
        	caperucitaState.setRowPosition(nextRow);
        	
        	//seteamos en todos los casilleros por que pasa caperucita al desplazarse hacia abajo que ahora esos casilleros están vacios (=O))
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	
        	caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        	caperucitaState.setBosque(bosque);
        	
        	//Borramos la posción del lobo que se obtuvo en la percepción
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
        int nextRow = caperucitaState.moverAbajo(row,col);
         
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,col);
        int [][] bosque = environmentState.getBosque();
      
        if (listaDulces.size()>0) {
        	
        	//caperucitaState.setRowPosition(row);
            environmentState.setAgentPosition(new int[] {nextRow, col});
            
          //seteamos en todos los casilleros por que pasa caperucita al desplazarse hacia abajo que ahora esos casilleros están vacios (=O))
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	environmentState.setBosque(bosque);
            environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());

        	//caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        	//caperucitaState.setBosque(bosque);
        	
        	
        	return environmentState;
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
        return "irAbajoJuntarDulce";
    }
}
