package cz.czechitas.ukol3;

import cz.czechitas.ukol3.Disk;

import java.util.Objects;

public class Pocitac {

    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    @Override
    public String toString() {
        return "Pocitac{" +
                "cpu=" + cpu +
                ", ram=" + ram +
                ", pevnyDisk=" + pevnyDisk +
                '}';
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (jeZapnuty) {
            System.err.println("Pocitac uz bezi.");
        } else if (pevnyDisk != null || ram != null || cpu != null) {
            jeZapnuty = true;
            System.out.println("Pocitac je zapnuty.");
        } else {
            System.err.println("Pocitac se nezapne, nema vsechny soucasti.");
        }
    }

    public void vypniSe() {
        jeZapnuty = false;
        System.out.println("Pocitac je vypnuty.");
    }

    public void vytvorSouborOVelikosti(long velikost){
        jeZapnuty = true;
        if (velikost > (pevnyDisk.kapacita - pevnyDisk.vyuziteMisto)) {
            System.err.println("Neni misto.");
        }
        else {
            System.out.println("Soubor se zmenil.");
        }
    }
    public void vymazSouboryOVelikosti(long velikost){
        jeZapnuty = true;
        if ((pevnyDisk.vyuziteMisto - velikost) >= 0) {
            System.out.println("Soubor je vymazan.");
        }
        else {
            System.err.println("Nemuzeme smazat soubor.");
        }
    }
}




