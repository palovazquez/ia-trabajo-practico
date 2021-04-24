package grupo1.search.caperucita.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irDerechaJuntarDulce extends SearchAction {

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
        int [][] bosque = caperucitaState.getBosque();
     
        /* Caperucita sólo puede ir derecha cuando se cumplan las condiciones:
         * el lobo no esté derecha 
         * en la posición inmediata de derecha no se encuentre un árbol
         * cuando haya dulces en el camino, si no hay dulces debería sólo irDerecha*/
        if (!caperucitaState.hayLoboDerecha(row,col) && caperucitaState.getBosque()[row][col+1]!=1
        		&& listaDulces.size()>0&&!caperucitaState.recorriCasillero(row,nextCol)) {
        	
        	caperucitaState.setColumnPosition(nextCol);
        	
        	//seteamos en todos los casilleros por que pasa caperucita al desplazarse hacia derecha que ahora esos casilleros están vacios (=O))
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	
        	caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        	caperucitaState.setBosque(bosque);
        	caperucitaState.agregarCasilleroRecorrido(row,nextCol);
	
        	//Borramos la posción del lobo que se obtuvo en la percepción
        	caperucitaState.setPosicionLobo(new int[2]);
   	
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
        int [][] bosque = environmentState.getBosque();

            
        //seteamos en todos los casilleros por que pasa caperucita al desplazarse hacia derecha que ahora esos casilleros están vacios (=O))
        for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        environmentState.setBosque(bosque);
        environmentState.setAgentPosition(new int[] {row, nextCol});
        environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());

        caperucitaState.setColumnPosition(nextCol);
        caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        caperucitaState.setBosque(bosque);
    	caperucitaState.setPosicionLobo(new int[2]);
    	caperucitaState.agregarCasilleroRecorrido(row,nextCol);

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
        return "irDerechaJuntarDulce";
    }
}
