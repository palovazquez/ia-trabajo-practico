/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Guti√©rrez, Jorge Roa,
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

import frsf.cidisi.faia.agent.*;
import frsf.cidisi.faia.environment.Environment;
import grupo1.escenarios.Escenario;

public class CaperucitaEnvironment extends Environment {

    public CaperucitaEnvironment(Escenario escenario) {
        // Create the environment state
        this.environmentState = new CaperucitaEnvironmentState(escenario);
    }

    @Override
    public CaperucitaEnvironmentState getEnvironmentState() {
        return (CaperucitaEnvironmentState) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public Perception getPercept() {
        // Create a new perception to return
        CaperucitaPerception perception = new CaperucitaPerception();
        
        // Get the actual position of the agent to be able to create the
        // perception
        int row = this.getEnvironmentState().getAgentPosition()[0];
        int col = this.getEnvironmentState().getAgentPosition()[1];

        // Set the perception sensors
        perception.setLoboArriba(this.getLoboArriba(row, col));
        perception.setLoboIzquierda(this.getLoboIzquierda(row, col));
        perception.setLoboDerecha(this.getLoboDerecha(row, col));
        perception.setLoboAbajo(this.getLoboAbajo(row, col));
        
        // Return the perception
        return perception;
    }

    @Override
    public String toString() {
        return environmentState.toString();
    }

    @Override
    public boolean agentFailed(Action actionReturned) {

        CaperucitaEnvironmentState caperucitaEnvironmentState =
                this.getEnvironmentState();

        int caperucitaVidas = caperucitaEnvironmentState.getVidas();

        // FIXME: The caperucita agent always has the same energy
        // If the agent has no energy, he failed
        if (caperucitaVidas <= 0) {
        	System.out.println("GAME OVER, ME QUED… SIN VIDAS");
            return true;
        }
        else {
        	return false;	
        }
        
    }

    // The following methods are Caperucita-specific:
    
    public int[] getLoboArriba(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getLoboArriba(row, col);
    }

    public int[] getLoboIzquierda(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getLoboIzquierda(row, col);
    }

    public int[] getLoboDerecha(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getLoboDerecha(row, col);
    }

    public int[] getLoboAbajo(int row, int col) {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getLoboAbajo(row, col);
    }
    
    public int[] getLoboPosicion() {
        return ((CaperucitaEnvironmentState) this.environmentState)
                .getLoboPosition();
    }
    
}
