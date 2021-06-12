package com.example.application.data.entity;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import com.example.application.data.AbstractEntity;
import com.example.application.data.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User extends AbstractEntity {

    private String username;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @JsonIgnore
    private String hashedPassword;

    @Lob
    private String profilePictureUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

}
