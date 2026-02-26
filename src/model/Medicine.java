package model;

public  class Medicine {

    private String name;
    private String dose;
    private String dailyUse; //Günde 3 kez gibi
    private int usagePeriod; //Kaç gün kullanılacağı bilgisi


    public Medicine() {

    }

    public Medicine(String name, String dose, String dailyUse, int usagePeriod) {
        this.name = name;
        this.dose = dose;
        this.dailyUse = dailyUse;
        this.usagePeriod = usagePeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDailyUse() {
        return dailyUse;
    }

    public void setDailyUse(String dailyUse) {
        this.dailyUse = dailyUse;
    }

    public int getUsagePeriod() {
        return usagePeriod;
    }

    public void setUsagePeriod(int usagePeriod) {
        this.usagePeriod = usagePeriod;
    }


}
