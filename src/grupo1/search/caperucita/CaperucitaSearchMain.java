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

import java.util.Random;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import grupo1.escenarios.Escenario;

public class CaperucitaSearchMain {
    
    public static void main(String[] args) throws PrologConnectorException {
        
    	Escenario[] escenarios = obtenerEscenarios();
    	
    	Random rd = new Random();
    	int e= rd.nextInt(3);
    	
    	CaperucitaAgent caperucitaAgent = new CaperucitaAgent(escenarios[0]);
        
        CaperucitaEnvironment caperucitaEnvironment = new CaperucitaEnvironment(escenarios[0]);
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(caperucitaEnvironment, caperucitaAgent);
        
        simulator.start();
    }
    
    public static Escenario[] obtenerEscenarios() {
    	
    	Escenario[] escenarios = new Escenario[3];
    	
    	escenarios[0] = new Escenario((new Escenario()).retornarBosque1(),new int[]{5,11},new int[]{6,4},3);
    	escenarios[1] = new Escenario((new Escenario()).retornarBosque2(),new int[]{5,11},new int[]{6,4},3);
    	escenarios[2] = new Escenario((new Escenario()).retornarBosque3(),new int[]{5,11},new int[]{6,4},3);
    	    	
    	return escenarios;
    }
     
}
