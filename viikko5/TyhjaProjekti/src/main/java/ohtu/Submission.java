package ohtu;

public class Submission {
    private String student_number;
    private int week;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private int hours;
    private int done;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public int getWeek() {
        return this.week;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }
    
    public int getHours() {
        return this.hours;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public boolean getA1() {
        return a1;
    }
    
    public void setA1(boolean a1) {
        this.a1 = a1;
    }
    
    public boolean getA2() {
        return a2;
    }
    
    public void setA2(boolean a2) {
        this.a2 = a2;
    }
    
    public boolean getA3() {
        return a3;
    }
    
    public void setA3(boolean a3) {
        this.a3 = a3;
    }
    
    public boolean getA4() {
        return a4;
    }
    
    public void setA4(boolean a4) {
        this.a4 = a4;
    }
    
    public boolean getA5() {
        return a5;
    }
    
    public void setA5(boolean a1) {
        this.a5 = a5;
    }
    
    public boolean getA6() {
        return a6;
    }
    
    public void setA6(boolean a6) {
        this.a6 = a6;
    }
    
    public boolean getA7() {
        return a7;
    }
    
    public void setA7(boolean a7) {
        this.a7 = a7;
    }
    
    public boolean getA8() {
        return a8;
    }
    
    public void setA8(boolean a8) {
        this.a8 = a8;
    }
    
    public boolean getA9() {
        return a9;
    }
    
    public void setA9(boolean a9) {
        this.a9 = a9;
    }
    
    public boolean getA10() {
        return a10;
    }
    
    public void setA10(boolean a10) {
        this.a10 = a10;
    }
    
    public boolean getA11() {
        return a11;
    }
    
    public void setA11(boolean a11) {
        this.a11 = a11;
    }
    
    public boolean getA12() {
        return a12;
    }
    
    public void setA12(boolean a12) {
        this.a12 = a12;
    }
    
    public void countExercises() {
        if (a1) {
            done++;
        }
        if (a2) {
            done++;
        }
        if (a3) {
            done++;
        }
        if (a4) {
            done++;
        }
        if (a5) {
            done++;
        }
        if (a6) {
            done++;
        }
        if (a7) {
            done++;
        }
        if (a8) {
            done++;
        }
        if (a9) {
            done++;
        }
        if (a10) {
            done++;
        }
        if (a11) {
            done++;
        }
        if (a12) {
            done++;
        }
       
    }
    
    public String a1() {
        if (a1) {
            return "1";
        } 
        return "";
    }
    
    public String a2() {
        if (a2) {
            return "2";
        } 
        return "";
    }
    
    public String a3() {
        if (a3) {
            return "3";
        } 
        return "";
    }
    
    public String a4() {
        if (a4) {
            return "4";
        } 
        return "";
    }
    
    public String a5() {
        if (a5) {
            return "5";
        } 
        return "";
    }
    
    public String a6() {
        if (a6) {
            return "6";
        } 
        return "";
    }
    
    public String a7() {
        if (a7) {
            return "7";
        } 
        return "";
    }
    
    public String a8() {
        if (a8) {
            return "8";
        } 
        return "";
    }
    
        public String a9() {
        if (a9) {
            return "9";
        } 
        return "";
    }
    
    public String a10() {
        if (a10) {
            return "10";
        } 
        return "";
    }
    
    public String a11() {
        if (a11) {
            return "11";
        } 
        return "";
    }
    
    public String a12() {
        if (a12) {
            return "12";
        } 
        return "";
    }
    
    public int getDone() {
        return this.done;
    }    
    
    public void setDone(int done) {
        this.done = done;
    }
    
    @Override
    public String toString() {
        countExercises();
        return "viikko" + this.week + ": tehtyjä tehtäviä yhteensä: " + this.done 
                +  ", aikaa kului " + this.hours + " tuntia, tehdyt tehtävät: " + 
                a1() + " " + a2() +" " + a3() + " " + a4() +" " + a5() + " " 
                + a6() +" " + a7() + " " + a8() +" " + a9() + " " + a10() +" " + a11() 
                + " " + a12();
    }
    
}