package Planeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Persona.Persona;

public abstract class Planeta {
    private List<Persona> habitantes = new ArrayList<>();
    private Integer cantMuseos;

    public Planeta(Integer cantMuseos) {
        this.cantMuseos = cantMuseos;
    }

    public List<Persona> getDelegacionDiplomatica() {
        return habitantes.stream()
            .filter(habitante -> habitante.esDestacado())
            .collect(Collectors.toList());
    }

    public Integer getValorInicialDefensa() {
        return (int) habitantes.stream()
            .filter(habitante -> habitante.getPotencia() >= 30)
            .count();
    }

    public Integer getPotencia() {
        return habitantes.stream().mapToInt(habitante -> habitante.getPotencia())
            .sum();
    }

    public boolean esCulto() {
        return cantMuseos > 2 && todosLosHabitantesTienenAlmenos(10, Persona::getInteligencia);
    }

    private boolean todosLosHabitantesTienenAlmenos(Integer umbral, 
            Function<Persona, Integer> getter) {
        return habitantes.stream()
                .allMatch(habitante -> getter.apply(habitante) >= umbral);
    }
}
