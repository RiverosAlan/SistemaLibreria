/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author hp
 */
public class primos {

    public static void main(String[] args) {
       

    }

    public static void printPrimeNumbers(int n, boolean prime[]) { // Create a boolean array "prime[0..n]" and initialize // all entries it as true. A value in prime[i] will // finally be false if i is Not a prime, else true. boolean prime[] = new boolean[n+1]; for(int i=0;i<n;i++) prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime 
            if (prime[p] == true) {
                // Update all multiples of p greater than or  
                // equal to the square of it 
                // numbers which are multiple of p and are  
                // less than p^2 are already been marked.  
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        System.out.println("Following are the prime numbers");
    }
}
