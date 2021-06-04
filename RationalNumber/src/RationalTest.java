/**
 * CLASSE RationalTest{}
 *<br>
 *
 * PROBLEME 1: Ce problème vous demande d’écrire une classe appelée RationalNumber qui représente une
 * fraction avec un numérateur et un dénominateur entiers.
 * <br>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * <br>
 *
 * @author Avesta MOLAEI
 * @version 1.0
 */
public class RationalTest {

    /**
     * main(); point d'entrée principal du programme
     * Fonction pour tester la classe RationalNumber.java
     * @param args les arguments de ligne de commande
     */
    public static void main(String[] args){

        //PREMIER TEST: réduction de RN
        System.out.println("\nTEST 1: réduction\n");
        RationalNumber RN1 = new RationalNumber();
        RN1.setNumerator(42);
        RN1.setDenominator(7);
        System.out.print("RN1 = " + RN1.toString());
        RationalNumber RN1dec = new RationalNumber();
        RN1.reduce();
        System.out.println("\nRN1 réduit = " + RN1.toString());
        System.out.println("\n-----------------------------\n");

        //DEUXIEME TEST: addition de RN
        System.out.println("TEST 2: addition\n");
        RationalNumber RNa = new RationalNumber();
        RNa.setNumerator(6);
        RNa.setDenominator(9);
        RationalNumber RNb = new RationalNumber();
        RNb.setNumerator(4);
        RNb.setDenominator(2);
        System.out.print("RNa = "+ RNa.toString()+"\nRNb = " + RNb.toString()+"\n");
        RationalNumber res;
        res = RNa.add(RNb);
        System.out.print("RNa + RNb = " + res.toString());
        res.reduce();
        System.out.println(" = " + res.toString());
        System.out.println("\n-----------------------------\n");

        //TROISIEME TEST: soustraction de RN
        System.out.println("TEST 3: soustraction\n");
        RationalNumber RNc = new RationalNumber();
        RNc.setNumerator(1337);
        RNc.setDenominator(3);
        RationalNumber RNd = new RationalNumber();
        RNd.setNumerator(420);
        RNd.setDenominator(69);
        System.out.print("RNc = "+ RNc.toString()+"\nRNd = " + RNd.toString()+"\n");
        RationalNumber resSus;
        resSus = RNc.substract(RNd);
        System.out.print("RNc - RNd = " + resSus.toString());
        resSus.reduce();
        System.out.println(" = " + resSus.toString());
        System.out.println("\n-----------------------------\n");

        //QUATRIEME TEST: multiplication de RN
        System.out.println("TEST 4: multiplication\n");
        RationalNumber RNe = new RationalNumber();
        RNe.setNumerator(7);
        RNe.setDenominator(14);
        RationalNumber RNf = new RationalNumber();
        RNf.setNumerator(3);
        RNf.setDenominator(125);
        System.out.print("RNe = "+ RNe.toString()+"\nRNf = " + RNf.toString()+"\n");
        RationalNumber resMul;
        resMul = RNe.substract(RNf);
        System.out.print("RNe x RNf = " + resMul.toString());
        resMul.reduce();
        System.out.println(" = " + resMul.toString());
        System.out.println("\n-----------------------------\n");

        //d'autres tests peuvent etre faits!

    }
}