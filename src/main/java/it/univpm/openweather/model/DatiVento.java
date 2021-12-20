package it.univpm.openweather.model;

import java.util.Vector;

public class DatiVento extends Citta{
        public Vector<DatiVento> SpeedVento;
        public String dataora;

        public DatiVento(){
                super();
                this.SpeedVento = SpeedVento;
                this.dataora = dataora;

        }

        public String getDataora(){
                return dataora;
        }
        public void setDataora(){
                this.dataora= dataora;
        }
        public Vector<DatiVento> getVelVento() {
                return SpeedVento;
        }

        public void setVelVento() {
                this.SpeedVento = SpeedVento;
        }
}
