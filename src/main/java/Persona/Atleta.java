package Persona;

import Planeta.Planeta;

public class Atleta extends Persona{
    private Integer masaMuscular;
    private Integer cantTecnicasConocidas;

    public Atleta(Integer edad) {
        this(edad, 4, 2);
    }

    public Atleta(Integer edad, Integer masaMuscular, Integer cantTecnicasConocidas) {
        super(edad);
        this.masaMuscular = masaMuscular;
        this.cantTecnicasConocidas = cantTecnicasConocidas;
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
    @Override
    public void ofrecerTributo(Planeta unPlaneta) {
        unPlaneta.construirMurallas(2);
    }
}
