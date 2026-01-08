package ar.edu.unlam.pb1.dominio;

public class Sobre {
   public static Carta[] comprarSobre() {
        Carta[] sobreDe5Cartas = Sobre.obtenerSobre(5);
        return sobreDe5Cartas;
    }

    public static Carta[] obtenerSobreDe3(){
        Carta[] sobreDe3Cartas = Sobre.obtenerSobre(3);
        return sobreDe3Cartas;
    }
    
    private static Carta[] obtenerSobre(int cantidadCartas) {
        Carta[] nuevoSobre = new Carta[cantidadCartas];

        // nuevoSobre => [getCartaAleatoria] [getCartaAleatoria ] [getCartaAleatoria]
        for ( int i = 0 ; i < nuevoSobre.length ; i++ ) {
            nuevoSobre[i] = Carta.getCartaAleatoria();
        }

        return nuevoSobre;
    }
}
