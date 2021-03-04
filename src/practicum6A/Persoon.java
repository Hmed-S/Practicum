package practicum6A;

import java.util.ArrayList;

public class Persoon<persoon> {
    private String naam;
    private double budget;
    private ArrayList<Game> gamelijst= new ArrayList<Game>();

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;

    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
        boolean gekocht = false;
        if ((this.budget >= g.huidigeWaarde()) & !(gamelijst.contains(g))) {
            gekocht = true;
            this.budget -= g.huidigeWaarde();
            this.gamelijst.add(g);
        }

        return gekocht;

    }

    public boolean verkoop(Game g, Persoon p){
        boolean verkocht = false;
        if( (this.gamelijst.contains(g)) & (p.getBudget() >= g.huidigeWaarde()) & !(p.gamelijst.contains(g))   ){
            this.budget += g.huidigeWaarde();
            p.budget -= g.huidigeWaarde();
            this.gamelijst.remove(g);
            p.gamelijst.add(g);
            verkocht = true;
        }
        return verkocht;

    }

    @Override
    public String toString() {
        StringBuilder games = new StringBuilder();
        for (Game game:gamelijst) {
            games.append("\n");
            games.append(game);
        }

        return naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:" + games;
    }
}

