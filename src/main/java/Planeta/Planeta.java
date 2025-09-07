package Planeta;

import java.util.ArrayList;
import java.util.List;
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
}
