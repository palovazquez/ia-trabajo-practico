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

public class irArriba extends SearchAction {

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
        
        /* The agent can only go up when the cell is not empty */
        if (!caperucitaState.hayLoboArriba(row,col) && caperucitaState.getBosque()[row-1][col]==0
        		&& listaDulces.size()==0) {
        	
        	caperucitaState.setRowPosition(caperucitaState.moverArriba(row,col));
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
        
        row = caperucitaState.moverArriba(row,col);
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,col);
        
        if (!caperucitaState.hayLoboArriba(row,col) && caperucitaState.getBosque()[row-1][col]==0
        		&& listaDulces.size()==0) {
        	
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
        return "irArriba";
    }
}
