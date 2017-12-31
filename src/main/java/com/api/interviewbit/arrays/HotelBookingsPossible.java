package com.api.interviewbit.arrays;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season.
 * His hotel has K rooms. Bookings contain an arrival date and a departure date.
 * He wants to find out whether there are enough rooms in the hotel to satisfy
 * the demand. Write a program that solves this problem in time O(N log N) .

 Input:


 First list for arrival time of booking.
 Second list for departure time of booking.
 Third is K which denotes count of rooms.

 Output:

 A boolean which tells whether its possible to make a booking.
 Return 0/1 for C programs.
 O -> No there are not enough rooms for N booking.
 1 -> Yes there are enough rooms for N booking.
 Example :

 Input :
 Arrivals :   [1 3 5]
 Departures : [2 6 8]
 K : 1

 Return : False / 0

 At day = 5, there are 2 guests in the hotel. But I have only one room.
 */


import java.util.Collections;
import java.util.ArrayList;
public class HotelBookingsPossible {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int len1 = arrive.size();
        int len2 = depart.size();
        if(len1!=len2) return false;
        Collections.sort(arrive);
        Collections.sort(depart);
        int val1=0,val2=0;
        int i=0,j=0;
        while(i<len1 && j<len1){
            val1 = arrive.get(i);
            val2 = depart.get(j);
            if(val1<val2)  i++;
            else if(val1>val2) j++;
            else {
                i++;
                j++;
            }
            if(i-j>K) return false;
        }
        return true;
    }
}
