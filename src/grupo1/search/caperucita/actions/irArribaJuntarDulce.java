/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa,
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
package grupo1.search.caperucita.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irArribaJuntarDulce extends SearchAction {

    /**
     * See comments in the Eat class.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        int row = caperucitaState.getRowPosition();
        int col = caperucitaState.getColumnPosition();
        int nextRow = caperucitaState.moverArriba(row,col);
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(nextRow,col);
        int [][] bosque = caperucitaState.getBosque();
     
        /* The agent can only go up when the cell is not empty */
        if (!caperucitaState.hayLoboArriba(row,col) && caperucitaState.getBosque()[row-1][col]!=1
        		&& listaDulces.size()>0&&!caperucitaState.recorriCasillero(nextRow,col)) {
        	
        	caperucitaState.setRowPosition(nextRow);
        	
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	
        	caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        	caperucitaState.setBosque(bosque);
        	caperucitaState.setPosicionLobo(new int[2]);
        	//caperucitaState.agregarCasilleroRecorrido(nextRow,col);
        	
        	//Calculo los casilleros recorridos
        	int casillerosRecorridos = Math.abs(row - nextRow);
        	caperucitaState.incrementarDistanciaRecorrida(casillerosRecorridos);
                 	
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

        int nextRow = caperucitaState.moverArriba(row,col);
        
        //Calculo los casilleros recorridos
    	int casillerosRecorridos = Math.abs(row - nextRow);
    	caperucitaState.incrementarDistanciaRecorrida(casillerosRecorridos);
         
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(nextRow,col);
        int [][] bosque = environmentState.getBosque();
      
        	
        for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        environmentState.setBosque(bosque);
        environmentState.setAgentPosition(new int[] {nextRow, col});
        environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());

        caperucitaState.setRowPosition(nextRow);
        caperucitaState.setCantidadDulces(caperucitaState.getCantidadDulces()+listaDulces.size());;
        caperucitaState.setBosque(bosque);
    	caperucitaState.setPosicionLobo(new int[2]);
    	caperucitaState.agregarCasilleroRecorrido(nextRow,col);
        
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
        return "irArribaJuntarDulce";
    }
}
