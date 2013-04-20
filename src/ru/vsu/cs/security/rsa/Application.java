package ru.vsu.cs.security.rsa;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        BigInteger e = BigInteger.valueOf(12371);
        BigInteger n = new BigInteger("517815623413379");
        BigInteger cipher = new BigInteger("12788138155374656626484111508435839351545312207685619856968320863251613810");
        RsaCracker cracker = new RsaCracker(e, n , cipher);
        try {
            BigInteger crackedMessage = cracker.crack();
            System.out.println("The original message in numeric format was: " + crackedMessage + ".");
        } catch (RsaCrackerException ex) {
            ex.printStackTrace();
        }
    }


}
