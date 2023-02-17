package co.manager.dto;

/**
 * @author jguisao
 */
public class CompanyDTO {
    private String companyName;
    private String dataBase;

    public CompanyDTO() {
    }

    public CompanyDTO(String companyName, String dataBase) {
        this.companyName = companyName;
        this.dataBase = dataBase;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyName='" + companyName + '\'' +
                ", dataBase='" + dataBase + '\'' +
                '}';
    }
}