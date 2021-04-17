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
import grupo1.search.caperucita.CaperucitaAgentState;
import grupo1.search.caperucita.CaperucitaEnvironmentState;

public class juntarDulce extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        /* The 'Eat' action can be selected only if there is food in the current
         * position. Otherwise return 'null'. */
        
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce();
        int [][] bosque = caperucitaState.getBosque();
        
        if (listaDulces.size()>0) {
        	
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	caperucitaState.setBosque(bosque);
        	
        	return caperucitaState;
        }
        
        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
        CaperucitaAgentState caperucitaState = ((CaperucitaAgentState) ast);

        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];

        
        ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce();
        int [][] bosque = environmentState.getBosque();
        
        if (listaDulces.size()>0) {
        	
        	for(int[] dulce:listaDulces) bosque[dulce[0]][dulce[1]]=0;
        	environmentState.setBosque(bosque);
        	caperucitaState.setBosque(bosque);
        	
        	return environmentState;
        }
        
        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "Eat";
    }
}
