package practicum6A;

import java.util.Objects;
import java.time.LocalDate;

public class Game {
    private String naam;
    private int releasejaar;
    private double nieuwprijs;

    public Game(String nm, int rj, double nwpr ){
        this.naam = nm;
        this.releasejaar = rj;
        this.nieuwprijs = nwpr;

    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde(){
        int huidigjaar = LocalDate.now().getYear();


        double jaarverschil =  huidigjaar - releasejaar;
        double prijs = this.nieuwprijs * 0.7;



        if (this.nieuwprijs == 0){
            prijs = 0.0;
        }

        if (jaarverschil == 0){
            prijs = this.nieuwprijs;
        }

        for(int x =0; x!=jaarverschil & jaarverschil > 1; x++){
            prijs = this.nieuwprijs *=0.7;
        }

        return prijs;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return releasejaar == game.releasejaar  && Objects.equals(naam, game.naam);
    }

    @Override
    public String toString() {
        return naam + ", uitgegeven in " + releasejaar + "; nieuwprijs: €" +  String.format("%.2f", nieuwprijs) + " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}
