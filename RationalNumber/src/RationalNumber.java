/**
 * CLASSE RationalNumber{}
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
public class RationalNumber {

    /**
     * ATTRIBUTS
     */
    private int denominator;
    private int numerator;

    /**
     * getDenominator(); Accesseur de denominator
     * @return denominator, la valeur du dénominateur
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * getNumerator(); Accesseur de numerator
     * @return numerator, la valeur du numérateur
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * setDenominator(); Setter de denominator
     * @param p_denominator, la valeur du dénominateur
     */
    public void setDenominator(int p_denominator) {
        this.denominator = p_denominator;
    }

    /**
     * setNumerator(); Setter de numerator
     * @param p_numerator, la valeur du numérateur
     */
    public void setNumerator(int p_numerator) {
        this.numerator = p_numerator;
    }

    /**
     * CONSTRUCTEUR NATUREL
     */
    public RationalNumber(int p_numerator, int p_denominator){
        int result = 0;

        this.numerator = p_numerator; //les valeurs courantes du numérateur et du dénominateur prennent les valeurs des parametres passés par le constructeur
        this.denominator = p_denominator;

        //bloc try-catch: on veut lancer une exception si le dénominateur est nul
        try{
            result = p_numerator / p_denominator;
        }
        catch(ArithmeticException e){
            //NB: ici, l'énnoncé propose de lancer une IllegalArgumentException, mais dans ce cas, l'exception n'est pas lancée; on utilise donc l'ArithmeticException.
            System.out.println("ATTENTION: LE DENOMINATEUR NE PEUT PAS ETRE NUL!");
        }
    }

    /**
     * CONSTRUCTEUR PAR DEFAUT
     */
    public RationalNumber(){
        this(0, 1); //on initialise un nombre rationnel nul, avec un dénominateur non nul (pour éviter la division par 0)
    }

    /**
     * toString(); surchage de la méthode système Java toString()
     * @return renvoie la représentation du nombre rationnel
     */
    @Override
    public String toString(){
        String rationnel = "";

        //on ajoute un "-" en début de String si il est négatif
        if(this.getDenominator() < 0 && this.getNumerator() > 0){
            rationnel += "-";
        }

        //idem, on ajoute un "-" en début de String si il est négatif
        if(this.getDenominator() > 0 && this.getNumerator() < 0){
            rationnel += "-";
        }

        //on retourne uniquement le numérateur si le dénominateur = 1
        if(this.getDenominator() == 1){
            rationnel += getNumerator();
            return rationnel;
        }

        //on concatène alors la valeur absolue du numérateur et du dénominateur
        rationnel += Math.abs(this.getNumerator()) + "/" + Math.abs(this.getDenominator());
        return rationnel;
    }

    /**
     * add(); méthode pour ajouter le nombre rationnel paramètre au nombre rationnel courant
     * @param p_rn le nombre rationnel à ajouter
     * @return la somme du RN courant et du RN paramètre
     */
    public RationalNumber add(final RationalNumber p_rn){
        //ajout de 2 fractions: a/b + c/d = (a.d + c.d)/(b.d)
        this.setNumerator(this.getNumerator() * p_rn.getDenominator() + p_rn.numerator * this.getDenominator());
        this.setDenominator(this.getDenominator() * p_rn.getDenominator());
        return this;
    }

    /**
     * substract(); méthode pour soustraire le nombre rationnel paramètre au nombre rationnel courant
     * @param p_rn le nombre rationnel à soustraire
     * @return la différence du RN courant et du RN paramètre
     */
    public RationalNumber substract(final RationalNumber p_rn){
        //soustraction de 2 fractions: a/b - c/d = (a.d - c.d)/(b.d)
        this.setNumerator(this.getNumerator() * p_rn.getDenominator() - p_rn.numerator * this.getDenominator());
        this.setDenominator(this.getDenominator() * p_rn.getDenominator());
        return this;
    }

    /**
     * multiply(); méthode pour multiplier le nombre rationnel paramètre au nombre rationnel courant
     * @param p_rn le nombre rationnel à multiplier
     * @return le produit du RN courant et du RN paramètre
     */
    public RationalNumber multiply(final RationalNumber p_rn){
        //produit de 2 fractions: a/b * c/d = a.c/b.d
        this.setNumerator(this.getNumerator() * p_rn.getNumerator());
        this.setDenominator(this.getDenominator() * p_rn.getDenominator());
        return this;
    }

    /**
     * divide(); méthode pour diviser le nombre rationnel paramètre au nombre rationnel courant
     * @param p_rn le nombre rationnel à multiplier
     * @return le produit du RN courant et du RN paramètre
     */
    public RationalNumber divide(final RationalNumber p_rn){
        //division de 2 fractions (a/b)/(c/d) =  a.d/b.c
        this.setNumerator(this.getNumerator() * p_rn.getDenominator());
        this.setDenominator(this.getDenominator() * p_rn.getNumerator());
        return this;
    }

    /**
     * gcd(); méthode pour calculer le PGCD de deux nombres (utilisé pour la réduction du RN)
     * @param x le premier nombre à évaluer
     * @param y le deuxième nombre à évaluer
     * @return le PGCD des deux nombres
     */
    private int gcd(int x, int y){

        //x et y prennent la valeur de leurs opposés si <0
        if(x < 0){
            x = -x;
        }

        if(y < 0){
            y = -y;
        }

        //soustractions successives pour le calcul du PGCD
        while(x != 0 && y != 0){
            if(x>y){
                x -= y;
            }
            else{
                y -= x;
            }
        }

        if(x != 0){
            return x;
        }
        return y;
    }

    /**
     * reduce(); méthode pour réduire la fraction représentant le RN
     */
    public void reduce(){
        int pgcdRN = this.gcd(this.getNumerator(), this.getDenominator()); //on fait le calcul du PGCD entre le numérateur et le dénominateur
        this.numerator = this.getNumerator() / pgcdRN; //on divise les numérateurs et les dénominateurs par leur PGCD
        this.denominator = this.getDenominator() / pgcdRN;
    }
}