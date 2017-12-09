package com.appstcit.banglawordbook;

/**
 * Created by Bj on 07-12-17.
 */

public class Product {
    private String bangla ;
    private String english;

    public String getBangla() {
        return bangla;
    }

    public void setBangla(String bangla) {
        this.bangla = bangla;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public Product(String bangla, String english) {
        this.bangla = bangla;
        this.english = english;
    }
}
