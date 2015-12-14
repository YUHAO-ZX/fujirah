package web.entity;

/**
 * Created by yuhao.zx on 15-9-14.
 */
public class StockCodes {
    private long id;
    private String code;
    private String symbol;
    private String name;
    private Integer status;
    private Integer baseType;
    private String baseIndustryCode;
    private String baseIndustryName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    public String getBaseIndustryCode() {
        return baseIndustryCode;
    }

    public void setBaseIndustryCode(String baseIndustryCode) {
        this.baseIndustryCode = baseIndustryCode;
    }

    public String getBaseIndustryName() {
        return baseIndustryName;
    }

    public void setBaseIndustryName(String baseIndustryName) {
        this.baseIndustryName = baseIndustryName;
    }
}
