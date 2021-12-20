package it.univpm.openweather.model;

import java.util.Vector;

public class Vento extends DatiVento {
    private Vector<DatiVento> speedVento;
    private String nameVento;

    public Vento(Vector<DatiVento> speedVento, String nameVento) {
        this.speedVento = speedVento;
        this.nameVento = nameVento;

    }

    public Vector<DatiVento> getSpeedVento() {
        return speedVento;
    }

    public void setSpeedVento(Vector<DatiVento> speedVento) {
        this.speedVento = speedVento;
    }

    public String getNameVento() {
        return nameVento;
    }

    public void setNameVento(String nameVento) {
        this.nameVento = nameVento;
    }
}

