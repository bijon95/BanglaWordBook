package com.appstcit.banglawordbook;

/**
 * Created by Bj on 10-12-17.
 */

public class Productitem {

    private String bangla ;
        private String english;
    private String viewStatus;

        public String getBangla() {
            return bangla;
        }

        public void setBangla(String bangla) {
            this.bangla = bangla;
        }

        public String getEnglish() {
            return english;
        }

    public String getViewStatus() {
        return viewStatus;
    }

    public void setViewStatus(String viewStatus) {
        this.viewStatus = viewStatus;
    }

    public void setEnglish(String english) {
            this.english = english;
        }

    public Productitem(String bangla, String english, String viewStatus) {
        this.bangla = bangla;
        this.english = english;
        this.viewStatus = viewStatus;
    }
}
