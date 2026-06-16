package org.example.ExamenPiscina;

public class Niño extends Bañista{
    private String telefono_contacto;

    public Niño(Integer numero, String nombre, int edad, TipoUsuario tipo, String telefono_contacto) {
        super(numero, nombre, edad, tipo);
        this.telefono_contacto = telefono_contacto;
    }

    @Override
    void pagar() {

    }

    public String getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }
}
