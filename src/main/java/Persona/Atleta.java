package Persona;

public class Atleta extends Persona{
    private Integer masaMuscular = 4;
    private Integer cantTecnicasConocidas = 2;

    public Atleta(Integer edad) {
        super(edad);
    }

    public Integer getMasaMuscular() {
        return masaMuscular;
    }
    
    @Override
    public Integer getPotencia() {
        return super.getPotencia() + (masaMuscular * cantTecnicasConocidas);
    }

    @Override
    public boolean esDestacado() {
        return super.esDestacado() || cantTecnicasConocidas > 5;
    }

    public void entrenar(Integer dias) {
        masaMuscular += dias / 5;
    }
    
    public void aprenderTecnica() {
        cantTecnicasConocidas += 1;
    }
}
