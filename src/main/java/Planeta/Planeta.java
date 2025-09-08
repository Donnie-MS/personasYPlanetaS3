package Planeta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import java.util.stream.Collectors;

import Persona.Persona;

public class Planeta {
    private List<Persona> habitantes = new ArrayList<>();
    private Integer cantMuseos;
    private Integer longitudMurallas;

    public Planeta(Integer cantMuseos) {
        this(cantMuseos, new ArrayList<>());
    }

    public Planeta(Integer cantMuseos, List<Persona> habitantes) {
        this.cantMuseos = cantMuseos;
        this.habitantes.addAll(habitantes);
    }

    public List<Persona> getDelegacionDiplomatica() {
        return habitantes.stream()
            .filter(habitante -> habitante.esDestacado())
            .collect(Collectors.toList());
    }
    
    public void fundarMuseo() {
        cantMuseos += 1;
    }

    public Integer potenciaAparente() {
        if (habitanteConMasPotencia() == null) {
            return 0;
        }
        return this.habitanteConMasPotencia().getPotencia() * habitantes.size();
    }

    private Persona habitanteConMasPotencia() {
        return habitantes.stream()
            .max(Comparator.comparing(habitante -> habitante.getPotencia()))// or Persona::getPotencia
            .orElse(null);

    }

    public void recibirTributos() {
        habitantes.forEach(habitante -> habitante.ofrecerTributo(this));
    }

    public boolean necesitaReforzar() {
        return (this.potenciaAparente() * 2) >= this.getPotencia();
    }

    public void construirMurallas(Integer unaCantidad) {
        longitudMurallas += unaCantidad;
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
