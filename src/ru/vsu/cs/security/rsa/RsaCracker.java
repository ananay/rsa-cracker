package ru.vsu.cs.security.rsa;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class RsaCracker {
    private BigInteger e;
    private BigInteger n;
    private BigInteger cipher;
    private BigInteger p;
    private BigInteger q;
    private BigInteger d;


    public RsaCracker(BigInteger e, BigInteger n, BigInteger cipher) {
        this.e = e;
        this.n = n;
        this.cipher = cipher;
    }

    public BigInteger crack() throws RsaCrackerException {
        List<BigInteger> factors = factorize(n);
        if (factors.size() != 2) {
            throw new RsaCrackerException("Can't determine factors p and q. Try to call factorize and set them manually.");
        }
        this.p = factors.get(0);
        this.q = factors.get(1);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        this.d = e.modInverse(phi);
        return cipher.modPow(d, n);
    }

    // code of this method was taken from this article:
    // http://programmingpraxis.files.wordpress.com/2012/09/primenumbers.pdf
    public List<BigInteger> factorize(BigInteger n)
    {
        BigInteger two = BigInteger.valueOf(2);
        List<BigInteger> factorList = new LinkedList<BigInteger>();

        if (n.compareTo(two) < 0)
        {
            throw new IllegalArgumentException("must be greater than one");
        }

        while (n.mod(two).equals(BigInteger.ZERO))
        {
            factorList.add(two);
            n = n.divide(two);
        }

        if (n.compareTo(BigInteger.ONE) > 0)
        {
            BigInteger factor = BigInteger.valueOf(3);
            while (factor.multiply(factor).compareTo(n) <= 0)
            {
                if (n.mod(factor).equals(BigInteger.ZERO))
                {
                    factorList.add(factor);
                    n = n.divide(factor);
                }
                else
                {
                    factor = factor.add(two);
                }
            }
            factorList.add(n);
        }

        return factorList;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getCipher() {
        return cipher;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getD() {
        return d;
    }
}
