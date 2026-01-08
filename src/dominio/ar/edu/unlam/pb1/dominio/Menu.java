package ar.edu.unlam.pb1.dominio;

public enum Menu {
	
	ACTUALIZAR_DATOS_CARTA ("1 - Actualizar datos de la carta"),
    COMPRAR_SOBRE ("2 - Comprar nuevo sobre"),
    VISUALIZAR_CARTAS_ACTUALES ("3 - Visualizar mi colección actual"),
    CALCULAR_PORCENTAJE_DE_COMPLETADO  ("4 - Calcular el porcentaje de colección completada"),
    INTERCAMBIAR_CARTA  ("5 - Intercambiar carta"),
    SALIR  ("6 - Salir del sistema");
    
    private String mensaje;
    
    Menu (String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String toString () {
        
        return this.mensaje;
    }
}
