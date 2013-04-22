package ru.vsu.cs.security.rsa;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        BigInteger e = BigInteger.valueOf(12371);
        BigInteger n = new BigInteger("517815623413379");
        BigInteger cipher = new BigInteger("127881381553746");
        RsaCracker cracker = new RsaCracker(e, n , cipher);
        try {
            BigInteger crackedMessage = cracker.crack();
            System.out.println("The original message in numeric format was: " + crackedMessage + ".");
        } catch (RsaCrackerException ex) {
            ex.printStackTrace();
        }
    }


}
