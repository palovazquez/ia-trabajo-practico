package grupo1.search.caperucita.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irIzquierdaJuntarDulce extends SearchAction {

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
        int [][] bosque = caperucitaState.getBosque();
     
        /* Caperucita s�lo puede ir izquierda cuando se cumplan las condiciones:
         * el lobo no est� izquierda 
         * en la posici�n inmediata de izquierda no se encuentre un �rbol
         * cuando haya dulces en el camino, si no hay dulces deber�a s�lo irIzquierda*/
        if (!caperucitaState.hayLoboIzquierda(row,col) && caperucitaState.getBosque()[row][col-1]!=1
        		&& listaDulces.size()>0) {
        	
        	caperucitaState.setColumnPosition(nextCol);
        	
        	//seteamos en todos los casilleros por que pasa caperucita al desplazarse hacia izquierda que ahora esos casilleros est�n vacios (=O))
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	
        	caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        	caperucitaState.setBosque(bosque);
        	
        	//Borramos la posci�n del lobo que se obtuvo en la percepci�n
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
        int nextCol = caperucitaState.moverIzquierda(row,col);
         
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,col);
        int [][] bosque = environmentState.getBosque();
      
        if (listaDulces.size()>0) {
        	
        	//caperucitaState.setColumnPosition(col);
            environmentState.setAgentPosition(new int[] {row, nextCol});
            
          //seteamos en todos los casilleros por que pasa caperucita al desplazarse hacia izquierda que ahora esos casilleros est�n vacios (=O))
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
        return "irIzquierdaJuntarDulce";
    }
}
