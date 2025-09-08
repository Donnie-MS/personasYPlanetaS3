package Persona;

public class Docente extends Persona {
    private Integer cantCursosDados;

    public Docente(Integer edad) {
        this(edad, 0);
    }

    public Docente(Integer edad, Integer cantCursosDados) {
        super(edad);
        this.cantCursosDados = cantCursosDados;
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
