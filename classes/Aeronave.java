package classes;

public class Aeronave {
    public Aeronave(String modelo, String numeroSerie, Piloto piloto) {
        
    }
    public Aeronave() {
    }
    private String modelo;
    private String numeroSerie;
    private Piloto piloto;
    
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public Piloto getPiloto() {
        return piloto;
    }
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

}
