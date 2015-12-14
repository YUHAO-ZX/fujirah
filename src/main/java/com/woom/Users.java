package com.woom;

/**
 * Created by yuhao.zx on 15-10-27.
 */
public class  Users{
    private String code;
    private String name;
    private Integer mustInput;
    private Integer width;
    private Integer height;
    private String pattern;
    private Integer maxLength;
    private Integer minLength;
    public boolean equals(Object obj) {
        if(obj instanceof Users){
            return (this.code.equals(((Users)obj).code));
        }
       return false;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMustInput() {
        return mustInput;
    }

    public void setMustInput(Integer mustInput) {
        this.mustInput = mustInput;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }
}
