package com.dxc.bookstore.api.bookstoreservice.dto;

import java.time.LocalDate;

public class AuthorRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private LocalDate birthday;
}
