package Data;

public enum Categories {
    LIVING_ROOMS("Гостинные"),
    BEDROOMS("Спальни"),
    CHILDRENS_ROOMS("Детские");

    private String ruName;

    Categories(String ru) {
        ruName = ru;
    }

    public String getRuName(){
        return ruName;
    }

}
