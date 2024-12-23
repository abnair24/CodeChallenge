package com.abn.scalar.dsa.day23BitManipulation;

/*
IRCTC most frequent train search.
IRCTC wants to improve how it shows train options to its users
Trains running more frequently should appear higher up in search results
To figure this out they look at a 28 day period to see how often each train runs

 Given a list A of special numbers for different trains, find train that runs the most.

 Eg: [4369, 8738, 349525]

 binary representation of each number

4369:   0000000000000001000100010001
8738:   0000000000000010001000100010
349525: 0000000101010101010101010101
 */
public class FrequencyOfTrains {

    public int solve(int[] trains) {

        int count = 0;
        int max = Integer.MIN_VALUE;
        int maxTrain = 0;

        for(int t : trains) {
            int train = t;

            while ( t > 0) {
                if ((t & 1) > 0) {
                    count++;
                }
                t = t >> 1;
            }

            if(count > max) {
                max = count;
                maxTrain = train;
            }
        }

        return maxTrain;
    }

    public static void main(String[] args) {

        FrequencyOfTrains frequencyOfTrains = new FrequencyOfTrains();
        System.out.println(frequencyOfTrains.solve(new int[] {4369, 8738, 349525}));
    }
}
