package Persona;

public class Docente extends Persona {
    private Integer cantCursosDados = 0;

    public Docente(Integer edad) {
        super(edad);
    }

    @Override
    public Integer getInteligencia() {
        return super.getInteligencia() + (cantCursosDados * 2);
    }
    @Override
    public boolean esDestacado() {
        return cantCursosDados > 3;
    }
}
