package Persona;

public class Persona {
    private Integer edad;
    
    public Persona(Integer edad) {
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getInteligencia() {
        if (edad >= 20 && edad <= 40) {
            return 12;
        }
        else {
            return 8;
        }
    }

    public Integer getPotencia() {
        return 20;
    }

    public boolean esDestacado() {
        return 25 == edad || 35 == edad;
    }



}
