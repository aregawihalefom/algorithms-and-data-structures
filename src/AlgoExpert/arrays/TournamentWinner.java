package AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        Map<String , Integer> table = new HashMap<>();

        String winner = "";
        table.put(winner, 0);

        for(int i = 0 ; i < competitions.size() ; i++){

            int result = results.get(i);

            String homeTeam = competitions.get(i).get(0);
            String awayTeam = competitions.get(i).get(1);

            String gameWinner = (result == 0) ? awayTeam : homeTeam;

            // add the team to the table
            if(!table.containsKey(gameWinner)) table.put(gameWinner , 0);

            // update the score and check it he is the winner so far
            table.put(gameWinner , table.get(gameWinner) + 3);

            // update the current best
            if(table.get(winner) < table.get(gameWinner)) winner = gameWinner;

        }

        // return the winner
        return winner;
    }


    public static void main(String[] args) {

        TournamentWinner tournament = new TournamentWinner();

        ArrayList<String> matche1 = new ArrayList<>();
        matche1.add("HTML" );
        matche1.add("C#" );


        int[] nums = new int[]{2, 3 ,4 ,5, 6};
        System.out.println(Arrays.toString(nums));

        ArrayList<String> matche2 = new ArrayList<>();
        matche2.add("C#" );
        matche2.add("Python" );

        ArrayList<String> match3 = new ArrayList<>();
        match3.add("Python");
        match3.add("HTML");


        ArrayList<ArrayList<String>> competition = new ArrayList<>();
        competition.add(matche1); competition.add(matche2); competition.add(match3);

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0); results.add(0);results.add(1);

        System.out.println(tournament.tournamentWinner(competition, results));

    }

}
