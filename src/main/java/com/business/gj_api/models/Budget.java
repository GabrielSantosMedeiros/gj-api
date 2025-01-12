package com.business.gj_api.models;

import org.apache.commons.validator.routines.EmailValidator;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "budgets")
@NoArgsConstructor
public class Budget {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String company;
    private String email;
    private String numberPhone;

    private static EmailValidator emailValidator = EmailValidator.getInstance();
    
    public Long getId() {
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
        if(emailValidator.isValid(email)) {
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
            throw new IllegalArgumentException("número de telefone: " + numberPhone + "inválido.");
        }
    }
}
