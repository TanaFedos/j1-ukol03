package cz.czechitas.ukol3;

import java.util.Objects;

    public class Disk {

        public long kapacita;
        public long vyuziteMisto;

        public long getKapacita() {
            return kapacita;
        }

        public void setKapacita(long kapacita) {
            this.kapacita = kapacita;
        }

        public long getVyuziteMisto() {
            return vyuziteMisto;
        }

        public void setVyuziteMisto(long vyuziteMisto) {
            this.vyuziteMisto = vyuziteMisto;
        }

        @Override
        public String toString() {
            return "Disk{" +
                    "kapacita=" + kapacita +
                    ", vyuziteMisto=" + vyuziteMisto +
                    '}';
        }
    }
