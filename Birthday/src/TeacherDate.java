//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
// édité et commenté par MOLAEI Avesta et BENKEMOUN Jules

import java.util.TimeZone; //on importe le module TimeZone

/**
 * CLASSE TeacherDate{}
 *
 */

public class TeacherDate {

    /**
     * INITIALISATION ATTRIBUTS
     */
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int DECEMBER = 12;
    private static final int START_YEAR = 1753;
    private static final int DAYS_PER_WEEK = 7;
    private static final String[] DAY_NAMES = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_PER_MONTH = new int[]{-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year;
    private int month;
    private int day;

    /**
     * getDaysSinceEpoch(): nombre de jours
     * @return Le nombre de jours depuis le 1er janvier 1970
     */
    public static int getDaysSinceEpoch() {
        return (int)((System.currentTimeMillis() + (long)TimeZone.getDefault().getRawOffset()) / 1000L / 60L / 60L / 24L);
    }

    /**
     * CONSTRUCTEUR NATUREL
     */
    public TeacherDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        if (year < 1753) {
            throw new IllegalArgumentException(this + " year too small: " + year); //exception si l'année est trop lointaine
        } else if (month >= 1 && month <= 12) {
            if (day < 1 || day > this.getDaysInMonth()) {
                throw new IllegalArgumentException(this + " day out of range: " + day); //exception si le jour n'existe pas
            }
        } else {
            throw new IllegalArgumentException(this + " month out of range: " + month); //exception si le mois n'existe pas
        }
    }

    /**
     * CONSTRUCTEUR PAR DEFAUT
     **/
    public TeacherDate() {
        this(1970, 1, 1);
        int daysSinceEpoch = getDaysSinceEpoch();

        for(int i = 0; i < daysSinceEpoch; ++i) {
            this.nextDay();
        }

    }

    /**
     * equals(): verifie l'égalité avec l'objet passé en paramètre
     * @param o un objet castable en TeacherDate
     * @return true si les mois, le jour et l'année sont identiques
     * @return false sinon
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof TeacherDate) {
            TeacherDate other = (TeacherDate)o; //on caste l'objet passé en param en TeacherDate
            return this.day == other.day && this.month == other.month && this.year == other.year;
        } else {
            return false;
        }
    }

    /**
     * getDay(): accesseur de l'attribut day
     * @return day, le jour de l'objet courant
     */
    public int getDay() {
        return this.day;
    }

    /**
     * getMonth(): accesseur de l'attribut month
     * @return month, le mois de l'objet courant
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * getYear(): accesseur de l'attribut year
     * @return year, l'année de l'objet courant
     */
    public int getYear() {
        return this.year;
    }

    /**
     * getDayOfWeek(): va chercher le jour de la semaine correspondant
     * @return DAY_NAMES[dayIndex], une chaine de caractère contenant le jour de la semaine
     */
    public String getDayOfWeek() {
        int dayIndex = 1;

        for(TeacherDate temp = new TeacherDate(1753, 1, 1); !temp.equals(this); dayIndex = (dayIndex + 1) % 7) {
            temp.nextDay(); //on parcourt les jours jusqu'a tomber sur le bon
        }

        return DAY_NAMES[dayIndex]; //on renvoie
    }

    /**
     * isLeapYear(): permet de savoir si l'année est bissextile
     * @return true si l'année est bissextile
     */
    public boolean isLeapYear() {
        return this.year % 400 == 0 || this.year % 4 == 0 && this.year % 100 != 0;
    }

    /**
     * nextDay(): une procédure qui permet de basculer au lendemain de la journée courante stockée dans 
     * les attributs
     */
    public void nextDay() {
        ++this.day; //on augmente le jour de 1
        if (this.day > this.getDaysInMonth()) {
            ++this.month; //on augmente le mois si on dépasse le nombre de jours du mois
            this.day = 1; //et on formate le jour correctement
            if (this.month > 12) {
                ++this.year; //on augmente l'année si on dépasse le 31 décembre
                this.month = 1; //et on reformate le jour
            }
        }

    }

    /**
     * redéfinition de toString(): pour obtenir la date courant au format Année/Mois/Jour
     * @return "AAAA/MM/JJ"
     */
    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    /**
     * getDaysInMonth(): récupère ne nombre de jours dans le mois courant
     * en fonction du mois
     * @return result le nombre de jours dans le mois
     */
    private int getDaysInMonth() {
        int result = DAYS_PER_MONTH[this.month]; //on sélectionne le mois courant
        if (this.month == 2 && this.isLeapYear()) {
            ++result; //on ajuste le nombre de jours dans le mois de février si l'année est bissextile
        }
        return result;
    }
}
