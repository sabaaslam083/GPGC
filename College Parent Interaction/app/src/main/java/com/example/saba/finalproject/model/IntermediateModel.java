package com.example.saba.finalproject.model;

public class IntermediateModel {
    private int id;
   private String year,forms_date,fee_date,classes_date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IntermediateModel(int id, String year, String forms_date, String fee_date, String classes_date) {
        this.id=id;

        this.year = year;
        this.forms_date = forms_date;
        this.fee_date = fee_date;
        this.classes_date = classes_date;

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getForms_date() {
        return forms_date;
    }

    public void setForms_date(String forms_date) {
        this.forms_date = forms_date;
    }

    public String getFee_date() {
        return fee_date;
    }

    public void setFee_date(String fee_date) {
        this.fee_date = fee_date;
    }

    public String getClasses_date() {
        return classes_date;
    }

    public void setClasses_date(String classes_date) {
        this.classes_date = classes_date;
    }
}
