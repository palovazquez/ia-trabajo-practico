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

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class CaperucitaPerception extends Perception {

    public static int VACIO = 0;
    public static int ARBOL = 1;
    public static int DULCE = 2;
    public static int CAMPOFLORES = 3;

    private int[]  loboIzquierda;
    private int[]  loboArriba;
    private int[]  loboDerecha;
    private int[]  loboAbajo;
    private int vidas;

    public CaperucitaPerception() {
        vidas = 3;
    }

    public CaperucitaPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
//      CaperucitaAgent caperucitaAgent = (CaperucitaAgent) agent;
        CaperucitaEnvironment caperucitaEnvironment = (CaperucitaEnvironment) environment;
        CaperucitaEnvironmentState environmentState =
                caperucitaEnvironment.getEnvironmentState();

        int row = environmentState.getAgentPosition()[0];
        int col = environmentState.getAgentPosition()[1];

        this.setLoboArriba(caperucitaEnvironment.getLoboArriba(row, col));
        this.setLoboIzquierda(caperucitaEnvironment.getLoboIzquierda(row, col));
        this.setLoboDerecha(caperucitaEnvironment.getLoboDerecha(row, col));
        this.setLoboAbajo(caperucitaEnvironment.getLoboAbajo(row, col));
        
   //     if(loboArriba||loboAbajo||loboIzquierda||loboDerecha) this.setPosicionLobo(caperucitaEnvironment.getLoboPosicion());
   //     else this.setPosicionLobo(null);
    }

    // The following methods are Pacman-specific:

    
    public int[]  isLoboIzquierda() {
		return loboIzquierda;
	}

	public void setLoboIzquierda(int[]  loboIzquierda) {
		this.loboIzquierda = loboIzquierda;
	}

	public int[]  isLoboArriba() {
		return loboArriba;
	}

	public void setLoboArriba(int[]  loboArriba) {
		this.loboArriba = loboArriba;
	}
	
	public int[]  isLoboDerecha() {
		return loboDerecha;
	}

	public void setLoboDerecha(int[]  loboDerecha) {
		this.loboDerecha = loboDerecha;
	}

	public int[]  isLoboAbajo() {
		return loboAbajo;
	}

	public void setLoboAbajo(int[]  loboAbajo) {
		this.loboAbajo = loboAbajo;
	}

    public int getVidas() {
        return vidas;
    }
	
	public void setVidas(int energy) {
        this.vidas = energy;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Vidas: " + this.vidas);
        str.append("; ");
        
        str.append("Sensor Izquierda: [" + this.loboIzquierda + ","+this.loboIzquierda+ "]");
        str.append("; ");
        str.append("Sensor Arriba: [" + this.loboArriba + ","+this.loboArriba + "]");
        str.append("; ");
        str.append("Sensor Derecha: [" + this.loboDerecha + ","+this.loboDerecha + "]");
        str.append("; ");
        str.append("Sensor Abajo: " + this.loboAbajo + ","+this.loboAbajo + "]");

        return str.toString();
    }


}
