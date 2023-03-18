package cz.czechitas.ukol3.model;

public class Pocitac {

    private boolean jeZapnuty;
    private Procesor procesor;
    private Pamet pamet;
    private Disk disk;


    public Procesor getProcesor() {
        return procesor;
    }

    public void setProcesor(Procesor procesor) {
        this.procesor = procesor;
    }

    public Pamet getPamet() {
        return pamet;
    }

    public void setPamet(Pamet pamet) {
        this.pamet = pamet;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Pocitac:" + procesor + pamet + disk;
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (!jeZapnuty) {
            zkontrolujSoucastiASpustSe();
        } else {
            System.err.println("Pocitac uz bezi.");
        }
    }

    private void zkontrolujSoucastiASpustSe() {
        if (disk != null || pamet != null || procesor != null) {
            jeZapnuty = true;
            System.out.println("Pocitac se zapnul.");
        } else {
            System.err.println("Pocitac se nezapne, nema vsechny soucasti.");
            nahlasChybejiciSoucasti();
        }
    }

    private void nahlasChybejiciSoucasti() {
        if (disk == null) {
            System.err.println("Chybi disk!");
        }
        if (pamet == null) {
            System.err.println("Chybi pamet!");
        }
        if (procesor == null) {
            System.err.println("Chybi procesor!");
        }
    }

    public void vypniSe() {
        if (jeZapnuty()) {
            jeZapnuty = false;
            System.out.println("Pocitac se vypnul.");
        }
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long vyuziteMisto = disk.getVyuziteMisto();
            long kapacita = disk.getKapacita();
            long zbyvajiciMisto = kapacita - vyuziteMisto - velikost;
            if (zbyvajiciMisto >= 0) {
                disk.setVyuziteMisto(vyuziteMisto + velikost);
                System.out.println("Na disku se zbylo: " + zbyvajiciMisto);
            } else {
                System.err.println("Na disku neni misto.");
            }
        } else {
            System.err.println("Pocitac je vypnuty.");
        }
    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (jeZapnuty) {
            long vyuziteMisto = disk.getVyuziteMisto();
            long kapacita = disk.getKapacita();
            long zbyvajiciMisto = kapacita - vyuziteMisto + velikost;
            if (velikost < vyuziteMisto) {
                disk.setVyuziteMisto(vyuziteMisto + velikost);
            } else {
                disk.setVyuziteMisto(0);
            }
            System.out.println("Na disku se zbylo: " + zbyvajiciMisto);
        } else {
            System.err.println("Pocitac je vypnuty");
        }
    }
}


