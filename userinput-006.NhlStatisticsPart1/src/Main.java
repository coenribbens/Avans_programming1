
import nhlstats.NHLStatistics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Top 10 players based on goals");
        NHLStatistics.sortByGoals();
        NHLStatistics.top(10);

        System.out.println("Top 25 based on penalty amounts");
        NHLStatistics.sortByPenalties();
        NHLStatistics.top(25);

        System.out.println("Statistics for Sidney Crosby");
        NHLStatistics.searchByPlayer("Sidney Crosby");
        NHLStatistics.top(1);

        System.out.println("Statistics for Philadelphia Flyers");
        NHLStatistics.teamStatistics("PHI");
        NHLStatistics.sortByPoints();


        System.out.println("Players in Anaheim Ducks ordered by points");
        NHLStatistics.teamStatistics("ANA");
        NHLStatistics.sortByPoints();




    }
}
