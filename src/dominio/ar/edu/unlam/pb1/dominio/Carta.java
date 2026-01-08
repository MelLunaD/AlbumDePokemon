package ar.edu.unlam.pb1.dominio;

public class Carta {
	public static final int MINIMO_CODIGO_CARTA_POKEMON = 1;
    public static final int MAXIMO_CODIGO_CARTA_POKEMON = 5;

    private int numeroCarta; // Determina si es la carta 1, 2, 3, 4 o 5 del mismo Pokemon.
	private Pokemon pokemon; // Antes 'nombreJugador'

    private boolean esRara;
    private boolean esHolografica;

    // private String tipo; // Antes 'grupo' // Ahora se obtiene del Pokemon
	// private double rareza; // Antes 'valor' // Ahora se obtiene del Pokemon (+1 si es Rara ó +2 si es Holo)	
	public Carta(Pokemon pokemon, int numeroCarta) {
        this.numeroCarta = numeroCarta;
        this.pokemon = pokemon;

        // Si el numeroCarta es 3 ó 4, la carta es Rara.
        if(numeroCarta >= 3 && numeroCarta <= 4) {
            this.esRara = true;
        } else {
            this.esRara = false;
        }

        // Si el numeroCarta es 5, la carta es Holográfica.
        if(numeroCarta == 5){
            this.esHolografica = true;
        } else {
            this.esHolografica = false;
        }
	}

    public String toString() {
        String cartaEsRara, cartaEsHolografica;

        if (this.esRara) {
            cartaEsRara = "SÍ";
        } else {
            cartaEsRara = "NO";
        }
            
        if (this.esHolografica) {
            cartaEsHolografica = "SÍ";
        } else {
            cartaEsHolografica = "NO";
        }

        // Usar el ToString para mostrar la carta + si es repetida o no
        return  "Carta: " + this.getCodigoCarta() + '\n' +
                "Código de carta: " + this.getNumeroCarta() + '\n' +
                "Es rara: " + cartaEsRara + '\n' +
                "Es holográfica: " + cartaEsHolografica + '\n' +
                "Pokemon base: " + '\n' +
                this.pokemon.toString();
    }

    public static Carta getCartaAleatoria() {
        Pokemon pokemonAleatorio = Pokedex.obtenerPokemonAleatorio();

        int numeroCartaAleatorio = (int)(Math.random() * MAXIMO_CODIGO_CARTA_POKEMON) + MINIMO_CODIGO_CARTA_POKEMON;

        Carta nuevaCarta = new Carta(pokemonAleatorio, numeroCartaAleatorio);

        return nuevaCarta;
    }

    public int getNumeroCarta() {
        return this.numeroCarta;
    }

	public String getCodigoCarta() {
		return pokemon.getNombre() + Integer.toString(this.numeroCarta); // Charmander1 o Charmander2
	}

	public String tipo() {
		return this.pokemon.getTipo();
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

    // (Antes getValor)
    // Obtiene la rareza de la carta
	public double getRareza() {
        // Rareza original del Pokemon
        int rarezaCarta = this.pokemon.getPoder();

        if ( this.esRara ) {
            // Si la carta es Rara, le sumo 1 a la rareza
            rarezaCarta = rarezaCarta + 1;
        } else if (this.esHolografica) {
            // Si la carta es Holográfica, le sumo 2 a la rareza
            rarezaCarta = rarezaCarta + 2;
        }
        
		return rarezaCarta;
	}
}
