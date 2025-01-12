package com.business.gj_api.models;

import org.apache.commons.validator.routines.EmailValidator;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

public class Budget {
    
    
    private String id;
    private String name;
    private String company;
    private String email;
    private String numberPhone;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) throws Exception {
        if(EmailValidator.getInstance().isValid(email)) {
            this.email = email;
        } else {
            throw new Exception("O email: " + email + " não é válido.");
        }
    }
    public String getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(String numberPhone) {
        if(PhoneNumberUtil.getInstance().isPossibleNumber(numberPhone, "BR")) {
            this.numberPhone = numberPhone;
        } else {
            throw new IllegalArgumentException("número de telefone: " + numberPhone + " inválido.");
        }
    }
}
