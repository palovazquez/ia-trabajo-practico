package grupo1.search.caperucita.actions;


import java.util.ArrayList;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import grupo1.search.caperucita.*;

public class irIzquierdaPerderVida extends SearchAction {


	    public SearchBasedAgentState execute(SearchBasedAgentState s) {

	        CaperucitaAgentState caperucitaState = (CaperucitaAgentState) s;

	        int row = caperucitaState.getRowPosition();
	        int col = caperucitaState.getColumnPosition();
	        //va siquiente linea?
	        int nextCol = caperucitaState.moverIzquierda(row,col);
	        
	        //va siquiente linea?
	        //ArrayList<int[]> listaDulces =caperucitaState.pasoPorDulce(row,nextCol);
	        boolean recorri=caperucitaState.recorriCasillero(row,nextCol);
    
	        /*  */
	        
	        if (caperucitaState.hayLoboIzquierda(row,col) && caperucitaState.getBosque()[row][col-1]!=1 &&!recorri) {
	        	int filaInicialCaperucita = CaperucitaAgentState.getPosicionInicial()[0];
	        	int columnaInicialCaperucita = CaperucitaAgentState.getPosicionInicial()[1];
	        	caperucitaState.setRowPosition(filaInicialCaperucita);
	        	caperucitaState.setColumnPosition(columnaInicialCaperucita);
	        	
	        	//Vacío lista de casilleros ya recorridos
	        	ArrayList<int[]> listaCasillerosRecorridosVacia = new ArrayList<>();
	        	caperucitaState.setCasillerosRecorridos(listaCasillerosRecorridosVacia);
	        	
	        	caperucitaState.agregarCasilleroRecorrido(filaInicialCaperucita, columnaInicialCaperucita);
	        	
		        
		        //Reseteo a 0 la distancia Recorrida
		        caperucitaState.resetearDistanciaRecorrida();
		        
		        //Caperucita pierde los dulces Recolectados
		        caperucitaState.setCantidadDulces(0);
		        
		        //Caperucita pierde una Vida
		        caperucitaState.setVidas(caperucitaState.getVidas()-1);

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

	        //int row = environmentState.getAgentPosition()[0];
	        //int col = environmentState.getAgentPosition()[1];
	        
	        //int nextCol= caperucitaState.moverIzquierda(row,col);
	        
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
	        
	        //El lobo se mueve
	        caperucitaState.setPosicionLobo(new int[2]);
	        environmentState.setLoboPosition(environmentState.nuevaPosicionLobo());

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
	        return "Pierdo vida, lobo a la izquierda o estoy acorralada";
	    }
	}