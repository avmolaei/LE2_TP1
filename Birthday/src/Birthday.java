import java.util.*; //Import de la classe util pour utiliser les Scanners

/**
 * CLASSE Birthday{}
 *<br>
 *
 * Écrire une classe Java nommée Birthday, qui utilise la classe de date fournie (TeacherDate.java),
 * et qui invite l’utilisateur à saisir sa date de naissance, puis elle affiche le jour de la semaine où
 * elle est tombée, un message s’il s’agissait d’une année bissextile et le nombre de jours écoulés
 * depuis sa naissance. Si c’est l’anniversaire de l’utilisateur, vous afficherez un message de joyeux
 * anniversaire indiquant l’âge actuel de l’utilisateur.
 * <br>
 *
 * Ce programme est sous license libre ; vous pouvez le redistribuer et/ou le modifier selon les termes de la license Publique
 * Générale GNU publiée par la Free Software Foundation ; soit avec la version 3 de la license, ou (à votre choix) toute autre version ultérieure
 * <br>
 *
 * @author Avesta MOLAEI, Jules BENKEMOUN
 * @version 1.0
 */
public class Birthday{

    /**
     * main(); point d'entrée du programme principal
     * @param args les arguments de ligne de commande
     */
    public static void main(String [] args ){

        //on créé un scanner et on demande à l'utilisateur sa date de naissance
        Scanner sc = new Scanner(System.in);
        System.out.print("What month, day, and year were you born?  ");

        //on récupère la date, le mois, l'année dans 3 int différents
        int jour = sc.nextInt();
        int mois = sc.nextInt();
        int annee = sc.nextInt();

        //on créé 2 dates: celle de la naissane de l'utilisateur, et la date actuelle
        TeacherDate naissance = new TeacherDate(annee, mois, jour);
        TeacherDate ajdhui = new TeacherDate();

        //Affichage de la Date de naissance de l'utilisateur
        System.out.println("You were born on " + naissance.toString() + ", which was a " + naissance.getDayOfWeek() + ".");

        //Si la date d'ajdhui = la date de naissance de l'utilisateur: on lui affiche un message de célébration
        if (naissance.getDay() == ajdhui.getDay() && naissance.getMonth() == ajdhui.getMonth()){
            System.out.println("Happy Birthday! You are now age " + getAge(naissance, ajdhui));
        }
        //Si l'année de naissance est bisexstile, on l'affiche:
        else if (naissance.isLeapYear()){
            System.out.println(naissance.getYear() + " was a leap year.");
        }

        //Affichage du nombre de jours restants avant le prochain anniversaire
        if (cptJours(naissance, ajdhui) != 365){
            System.out.println("It will be your birthday in " + joursAvantAnniv(naissance, ajdhui) + " days.");
        }
        //afficher l'age de l'utilisateur
        System.out.println("You are " + cptJours(naissance, ajdhui) + " days old.");
    }

    /**
     * getAge(); fonction pour calculer l'age de l'utilisateur
     * @param naissance la date de naissance de l'utilisateur
     * @param ajdhui la date d'aujourd'hui
     * @return
     */
    public static int getAge( TeacherDate naissance, TeacherDate ajdhui ){
        return (ajdhui.getYear() - naissance.getYear()); //on renvoie une bete soustraction pour obtenir l'age
    }

    /**
     * cptJours(); fonction pour calculer le delta (en jours) entre 2 dates
     * @param date1 la première date à évaluer
     * @param date2 la deuxième date à évaluer
     * @return la différence en jours entre les 2 dates
     */
    public static int cptJours(TeacherDate date1, TeacherDate date2){
        int res = 0;
        TeacherDate eval = new TeacherDate(date1.getYear(), date1.getMonth(), date1.getDay());
        //tant que le jour de date1 != au jour de date2, on l'incrémente.
        while (eval.equals(date2) == false) {
            ++res;
            eval.nextDay();
        }

        return res;
    }

    /**
     * joursAvantAnniv(); fonction pour calculer le nombre de jours avant le prochain anniversaire de l'utilisateur
     * @param naissance
     * @param ajdhui
     * @return le nombre de jours
     */
    public static int joursAvantAnniv(TeacherDate naissance, TeacherDate ajdhui){
        //on utilise annivAv si l'anniversaire à déja eu lieu
        TeacherDate annivAv = new TeacherDate(ajdhui.getYear(), naissance.getMonth(), naissance.getDay());

        //on utilise annivAp si l'anniversaire est après la date actuelle
        TeacherDate annivAp = new TeacherDate((ajdhui.getYear() + 1), naissance.getMonth(), naissance.getDay());

        //est ce que l'anniversaire à déja eu lieu cette année?
        if( annivAv.getMonth() <= ajdhui.getMonth() && annivAv.getDay() < ajdhui.getDay()){
            return cptJours(annivAv, ajdhui);
        }
        //est ce que l'anniversaire à lieu plus tard cette année?
        else if (annivAv.getMonth() > ajdhui.getMonth()){
            return cptJours(ajdhui, annivAv);
        }
        //si l'anniversaire de l'utilisateur est l'année prochaine:
        else{
            return cptJours(ajdhui, annivAp);
        }
    }
}
