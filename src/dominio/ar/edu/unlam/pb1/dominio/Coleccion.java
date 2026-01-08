package ar.edu.unlam.pb1.dominio;

public class Coleccion {
	// La cantidad total de cartas es la cantidad de Pokémon * 5 (cantidad de cartas distintas por Pokémon)
    // CANTIDAD_TOTAL_CARTAS => 151 * 5 => 755
    public static final int CANTIDAD_TOTAL_CARTAS = Pokedex.CANTIDAD_TOTAL_POKEMON * Carta.MAXIMO_CODIGO_CARTA_POKEMON;
    public static final int CANTIDAD_TOTAL_REPETIDAS = 5000;
    private Carta[] coleccionActual;
    private Carta[] coleccionDeRepetidas;
    private int cantidadActualCartasUnicas;

    public Coleccion(){
        this.cantidadActualCartasUnicas = 0;
        this.coleccionActual = new Carta[Coleccion.CANTIDAD_TOTAL_CARTAS];
        this.coleccionDeRepetidas = new Carta[CANTIDAD_TOTAL_REPETIDAS];
    }
    
	public String toString() {
		return "[Cantidad actual de cartas únicas: " + cantidadActualCartasUnicas + "]";
	}

	public Carta[] getArrayColeccionActual(){
        return coleccionActual;
    }

    public String visualizarDatosDeColeccion(){
        String textoFinal = "";
        if ( coleccionActual[0] == null ) {
           return "Aún no tenes cartas en tu colección";
        }

        for ( int i = 0; i < coleccionActual.length; i++) {
            if( coleccionActual[i] != null) {
                textoFinal = textoFinal + coleccionActual[i].toString() + "\n\n";
            }
        }

        return textoFinal;
    }

    public boolean esRepetida(Carta carta){
        for ( int i = 0; i < coleccionActual.length; i++){
            if (
                coleccionActual[i] != null
                && coleccionActual[i].getCodigoCarta().equals(carta.getCodigoCarta())
            ){
                return true;
            }
        }
        return false;
    }

    public void agregarCarta(Carta carta){
        if ( esRepetida(carta) ) {
            agregarCartaRepetida(carta);
        } else {
            agregarCartaAColeccion(carta);
            cantidadActualCartasUnicas++;
        }
    }

    private void agregarCartaAColeccion(Carta carta) {
        for ( int i = 0 ; i < this.coleccionActual.length ; i++ ){
            if ( this.coleccionActual[i] == null ) {
                this.coleccionActual[i] = carta;
                return;
            }
        }
    }

    private void agregarCartaRepetida(Carta carta) {
        for ( int i = 0 ; i < this.coleccionDeRepetidas.length ; i++ ){
            if ( this.coleccionDeRepetidas[i] == null ) {
                this.coleccionDeRepetidas[i] = carta;
                return;
            }
        }
    }

    public void ordenarColeccion() {
        Carta auxiliar;
        for( int i = 0 ; i < this.coleccionActual.length - 1 ; i++ ) {
            for( int j = 0 ; j < this.coleccionActual.length - 1 ; j++ ) {
                if (
                    this.coleccionActual[j] != null && this.coleccionActual[j+1] != null && (
                        this.coleccionActual[j].getPokemon().getCodigo() > this.coleccionActual[j+1].getPokemon().getCodigo()
                        ||  (
                            this.coleccionActual[j].getPokemon().getCodigo() == this.coleccionActual[j+1].getPokemon().getCodigo()
                            && this.coleccionActual[j].getNumeroCarta() > this.coleccionActual[j+1].getNumeroCarta()
                        )
                    )
                ) {
                    auxiliar = this.coleccionActual[j];
                    this.coleccionActual[j] = this.coleccionActual[j + 1];
                    this.coleccionActual[j + 1] = auxiliar;
                }
            }
        }
    }
    
    public boolean laColeccionEstaCompleta() {
        for(int i = 0 ; i < coleccionActual.length ; i++ ) {
            if ( coleccionActual[i] == null ) {
                return false;
            }
        }  

        return true;
    }

    public String calcularPorcentajeCompletado(){
    	double porcentaje = 0.0;
    	String valorPorcentaje = null;
    	
        if(this.cantidadActualCartasUnicas == 0) {
            return null;
        }
        porcentaje = (this.cantidadActualCartasUnicas*100.0 /Coleccion.CANTIDAD_TOTAL_CARTAS );
        valorPorcentaje = String.format("%.2f", porcentaje);
        
        return valorPorcentaje;
    }

	public Carta[] coleccionDeRepetidas() {
		return coleccionDeRepetidas;
	}

	public void eliminarCartaRepetida(int i) {
	    if (i >= 0 && i < coleccionDeRepetidas.length) {
	        coleccionDeRepetidas[i] = null;
	    }
	}

}
