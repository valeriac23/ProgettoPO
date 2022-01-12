package it.univpm.openweather.model;

import java.util.Vector;

public class DatiVento extends Citta{
        public double SpeedVento;
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

        public double getVelVento(double SpeedVento) {
                return this.SpeedVento = SpeedVento;
        }

        public double setVelVento(double SpeedVento) {
                return this.SpeedVento = SpeedVento;
        }
}
