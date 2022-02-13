package com.example.studentregistrationform;

public class users {
    String STUD_FNAME, STUD_LNAME, STUD_ID, DATE_OF_BIRTH, GENDER, MOBILE_NO, EMAIL;

    public users(String STUD_FNAME, String STUD_LNAME, String STUD_ID, String DATE_OF_BIRTH, String GENDER, String MOBILE_NO, String EMAIL) {
        this.STUD_FNAME = STUD_FNAME;
        this.STUD_LNAME = STUD_LNAME;
        this.STUD_ID = STUD_ID;
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
        this.GENDER = GENDER;
        this.MOBILE_NO = MOBILE_NO;
        this.EMAIL = EMAIL;
    }

    public String getSTUD_FNAME() {
        return STUD_FNAME;
    }

    public void setSTUD_FNAME(String STUD_FNAME) {
        this.STUD_FNAME = STUD_FNAME;
    }

    public String getSTUD_LNAME() {
        return STUD_LNAME;
    }

    public void setSTUD_LNAME(String STUD_LNAME) {
        this.STUD_LNAME = STUD_LNAME;
    }

    public String getSTUD_ID() {
        return STUD_ID;
    }

    public void setSTUD_ID(String STUD_ID) {
        this.STUD_ID = STUD_ID;
    }

    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }

    public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
