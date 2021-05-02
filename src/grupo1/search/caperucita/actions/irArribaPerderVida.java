package grupo1.search.caperucita.actions;

import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irArribaPerderVida extends SearchAction {

    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

        int row = caperucitaState.getRowPosition();
        int col = caperucitaState.getColumnPosition();
        
        int nextRow = caperucitaState.moverArriba(row,col);
        
        
        //Va siguiente linea?????
        //ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(nextRow,col);
        
        boolean recorri = caperucitaState.recorriCasillero(nextRow,col);
        
        if (caperucitaState.hayLoboArriba(row,col) && caperucitaState.getBosque()[row-1][col]!=CaperucitaPerception.ARBOL
        		&&!recorri && caperucitaState.getVidas()>0) {
        	
        	//Caperucita vuelve a posición de inicio
        	int filaInicialCaperucita = CaperucitaAgentState.getPosicionInicial()[0];
        	int columnaInicialCaperucita = CaperucitaAgentState.getPosicionInicial()[1];
        	caperucitaState.setRowPosition(filaInicialCaperucita);
        	caperucitaState.setColumnPosition(columnaInicialCaperucita);
        	
        	//Vacío lista de casilleros ya recorridos
        	ArrayList<int[]> listaCasillerosRecorridosVacia = new ArrayList<>();
        	caperucitaState.setCasillerosRecorridos(listaCasillerosRecorridosVacia);
        	
        	caperucitaState.agregarCasilleroRecorrido(filaInicialCaperucita, columnaInicialCaperucita);
        	
        	//Borramos la posción del lobo que se obtuvo en la percepción
        	caperucitaState.setPosicionLobo(new int[2]);
	        
	        //Reseteo a 0 la distancia Recorrida
	        caperucitaState.resetearDistanciaRecorrida();
	        
	        //Caperucita pierde los dulces Recolectados
	        caperucitaState.setCantidadDulces(0);
            
	        //Caperucita pierde una Vida
	        caperucitaState.setVidas(caperucitaState.getVidas()-1);
	        
	        //Lobo quieto
	        int[] loboQuieto = new int[2];
	        loboQuieto[0]=0;
	        loboQuieto[1]=0;
	        caperucitaState.setPosicionLobo(loboQuieto);
	        
	        //System.out.println("Sólo puedo moverme en la dirección del Lobo");
	        
        	return caperucitaState;
        }
        
        return null;
    }
    
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
    	CaperucitaEnvironmentState environmentState = (CaperucitaEnvironmentState) est;
        CaperucitaAgentState caperucitaState = ((CaperucitaAgentState) ast);

        //int row = environmentState.getAgentPosition()[0];
        //int col = environmentState.getAgentPosition()[1];
        
       // int nextRow = caperucitaState.moverArriba(row, col);
        
        //Reseteo a 0 la distancia Recorrida
        caperucitaState.resetearDistanciaRecorrida();

        //Caperucita vuelve a posición de inicio
    	int filaInicialCaperucita = CaperucitaAgentState.getPosicionInicial()[0];
    	int columnaInicialCaperucita = CaperucitaAgentState.getPosicionInicial()[1];
    	caperucitaState.setRowPosition(filaInicialCaperucita);
    	caperucitaState.setColumnPosition(columnaInicialCaperucita);
    	//seteamos la posición inicial de caperucita en el ambiente
    	environmentState.setAgentPosition(new int[] {filaInicialCaperucita, columnaInicialCaperucita});
    	
    	
    	//Vacío lista de casilleros ya recorridos
    	ArrayList<int[]> listaCasillerosRecorridosVacia = new ArrayList<>();
    	caperucitaState.setCasillerosRecorridos(listaCasillerosRecorridosVacia);
    	
    	caperucitaState.agregarCasilleroRecorrido(filaInicialCaperucita, columnaInicialCaperucita);
    	
    	//Caperucita pierde una Vida
        caperucitaState.setVidas(caperucitaState.getVidas()-1);
        environmentState.setVidas(caperucitaState.getVidas());
        
        //Reseteo a 0 la distancia Recorrida
        caperucitaState.resetearDistanciaRecorrida();
        
        //Caperucita pierde los dulces Recolectados
        caperucitaState.setCantidadDulces(0);
        environmentState.setCantidadDulces(0);
    	
        //El lobo se mueve
        caperucitaState.setPosicionLobo(new int[2]);
        environmentState.setLoboPosition(environmentState.nuevaPosicionLobo()); 
	
        return environmentState;
    }

   
    @Override
    public Double getCost() {
        return 0.0;
    }

    
    @Override
    public String toString() {
        return "IrArribaPerderVida - me come el lobo";
    }
}
