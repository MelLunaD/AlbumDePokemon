package ar.edu.unlam.pb1.dominio;

public class Pokemon {
    private String nombre, tipo;
    private int codigo;
    private int poder;

    public Pokemon(int codigo, String nombre, String tipo, int poder){
        this.nombre = nombre;
        this.tipo = tipo;
        this.codigo = codigo;
        this.poder = poder;
    }

    public String toString(){
        return  '\t' + "Pokemon #" + this.codigo + '\n' +
        		'\t' + "Tipo: " + this.tipo + '\n' + 
                '\t' + "Nombre: " + this.nombre + '\n' +
                '\t' + "Poder: " + this.poder;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPoder() {
        return this.poder;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getTipo() {
        return this.tipo;
    }
    
    public void setPoder(int poder){
        this.poder = poder;
    }
	
}
