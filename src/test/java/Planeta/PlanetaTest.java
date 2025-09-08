package Planeta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import Persona.Atleta;
import Persona.Docente;
import Persona.Persona;


public class PlanetaTest {
    Persona julieta = new Persona(42);
    Atleta ana = new Atleta(25);
    Atleta rosa = new Atleta(45, 4, 8);
    Atleta perla = new Atleta(28, 6, 4);
    Docente monica = new Docente(45, 6);
    Docente luisa = new Docente(35, 1);
    List<Persona> habitantes = List.of(julieta, ana, rosa, perla, monica, luisa);
    private void verificarPersona(Persona persona,
            Integer potenciaEsperada, Integer inteligenciaEsperada,
            boolean destacadaEsperada) {
                
        assertEquals(potenciaEsperada, persona.getPotencia());
        assertEquals(inteligenciaEsperada, persona.getInteligencia());
        assertEquals(destacadaEsperada, persona.esDestacado());
    }

    @Test
    public void verificarPersonas() {
        verificarPersona(julieta, 20, 8, false);
        verificarPersona(ana, 28, 12, true);
        verificarPersona(rosa, 52, 8, true);
        verificarPersona(perla, 44, 12, false);
        verificarPersona(monica, 20, 20, true);
        verificarPersona(luisa, 20, 14, false); 
    }   

    @Test
    public void verificarPlaneta() {
        Planeta triton = new Planeta(1, habitantes); // 1 museo → NO culto

        // Delegación: Ana (25), Rosa (>5 técnicas), Mónica (>3 cursos)
        Set<Persona> delegacionEsperada = Set.of(ana, rosa, monica);
        assertEquals(delegacionEsperada, new HashSet<>(triton.getDelegacionDiplomatica()));

        // Defensa: potencia >= 30 → Rosa(52) y Perla(44) → 2
        assertEquals(2, triton.getValorInicialDefensa());

        // No es culto
        assertFalse(triton.esCulto());

        // Potencia total: 184
        assertEquals(184, triton.getPotencia());
    }
    
}
