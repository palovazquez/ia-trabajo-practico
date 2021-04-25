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
package grupo1.search.caperucita;

import frsf.cidisi.faia.agent.Perception;
import java.util.Vector;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import grupo1.escenarios.Escenario;
import grupo1.search.caperucita.actions.irAbajo;
import grupo1.search.caperucita.actions.irAbajoJuntarDulce;
import grupo1.search.caperucita.actions.irIzquierda;
import grupo1.search.caperucita.actions.irIzquierdaJuntarDulce;
import grupo1.search.caperucita.actions.irDerecha;
import grupo1.search.caperucita.actions.irDerechaJuntarDulce;
import grupo1.search.caperucita.actions.irArriba;
import grupo1.search.caperucita.actions.irArribaJuntarDulce;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CaperucitaAgent extends SearchBasedAgent {

    public CaperucitaAgent(Escenario escenario) {
//
        // The Caperucita Goal
        CaperucitaGoal goal = new CaperucitaGoal();

        // The Caperucita Agent State
        CaperucitaAgentState caperucitaState = new CaperucitaAgentState(escenario);
        this.setAgentState(caperucitaState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        operators.addElement(new irArribaJuntarDulce());
        operators.addElement(new irArriba());
        operators.addElement(new irDerechaJuntarDulce());
        operators.addElement(new irDerecha());
        operators.addElement(new irAbajoJuntarDulce());
        operators.addElement(new irAbajo());
        operators.addElement(new irIzquierdaJuntarDulce());        
        operators.addElement(new irIzquierda());

        // Create the Problem which the Caperucita will resolve
        Problem problem = new Problem(goal, caperucitaState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
        //DepthFirstSearch strategy = new DepthFirstSearch();
    	//BreathFirstSearch strategy = new BreathFirstSearch();
        /**
         * Another search strategy examples:
         * 
         * Depth First Search:
         * DepthFirstSearch strategy = new DepthFirstSearch();
         * 
         * Breath First Search:
         * BreathFirstSearch strategy = new BreathFirstSearch();
         * 
         * Uniform Cost:*/
          //IStepCostFunction costFunction = new CostFunction();
          //UniformCostSearch strategy = new UniformCostSearch(costFunction);
         
         // A Star Search:
          IStepCostFunction cost = new CostFunction();
          IEstimatedCostFunction heuristic = new Heuristic();
          AStarSearch strategy = new AStarSearch(cost, heuristic);
         /* 
         * Greedy Search:
         * IEstimatedCostFunction heuristic = new Heuristic();
         * GreedySearch strategy = new GreedySearch(heuristic);
         */

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(CaperucitaAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
