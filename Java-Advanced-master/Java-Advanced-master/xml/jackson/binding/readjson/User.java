package com.zetcode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private Long id;

    @JsonProperty(value = "firstname")
    private String firstName;

    @JsonProperty(value = "lastname")
    private String lastName;

    private String occupation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {

        final var sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", occupation='").append(occupation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
