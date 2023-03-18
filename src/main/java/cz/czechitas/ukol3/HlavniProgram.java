package cz.czechitas.ukol3;

import cz.czechitas.ukol3.model.Pocitac;
import cz.czechitas.ukol3.model.Disk;
import cz.czechitas.ukol3.model.Pamet;
import cz.czechitas.ukol3.model.Procesor;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        Pocitac tanaPocitac = new Pocitac();
        System.out.println(tanaPocitac); // Vypise, ze soucasti jsou null
        tanaPocitac.zapniSe();      // Vypise chybu, nema povinne soucasti

        Procesor tanaProcesor = new Procesor();
        tanaProcesor.setRychlost(2_200_000_000_000L);
        tanaProcesor.setVyrobce("Intel");

        Pamet tanaPamet = new Pamet();
        tanaPamet.setKapacita(8_589_934_592L);

        Disk tanaDisk = new Disk();
        tanaDisk.setKapacita(485_015_932_928L);
        tanaDisk.setVyuziteMisto(212_495_249_408L);

        tanaPocitac.setProcesor(tanaProcesor);
        tanaPocitac.setPamet(tanaPamet);
        tanaPocitac.setDisk(tanaDisk);

        System.out.println(tanaPocitac.toString()); // Vypise vse

        tanaPocitac.zapniSe();      // Vypise, ze pocitac je zapnuty
        tanaPocitac.zapniSe();      // Vypise chybu, protoze pocitac uz bezi

        tanaPocitac.vypniSe();      // Vypise, ze pocitac je vypnuty

        tanaPocitac.vypniSe();      // Nevypise chybu, ale nic neprovede,
        tanaPocitac.vypniSe();      // protoze pocitac je uz vypnuty

        tanaPocitac.zapniSe();
        tanaPocitac.jeZapnuty();
        tanaPocitac.vytvorSouborOVelikosti(120_000_000_545L);
        tanaPocitac.vymazSouboryOVelikosti(250_393_223_242L);
    }
}