package com.masteroflie.Spring.Project.models;

import java.util.Objects;

import org.hibernate.annotations.ManyToAny;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = user.TABLE_NAME)
public class user {

    public interface createUser {
    }
    public interface updateUser {
    }

    public static final String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //? GERA ID COM AUTO IMCREMENTACAO
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull(groups = createUser.class)
    @NotEmpty(groups = createUser.class)
    @Size (groups = createUser.class, min = 2,max = 100)
    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;


    @NotNull(groups = {createUser.class, updateUser.class})
    @NotEmpty(groups = {createUser.class, updateUser.class})
    @Size (groups = {createUser.class, updateUser.class}, max = 100)
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(groups = {createUser.class, updateUser.class})
    @NotEmpty(groups = {createUser.class, updateUser.class})
    @Size (groups = {createUser.class, updateUser.class}, min = 8,max = 50)
    @Column(name = "password", length = 50, nullable = false)
    private String password;

    //@ManyToMany(mappedBy = "user")
    //private List<task> tasks = new ArrayList<task>();


    //public List<task> getTasks() {
    //    return this.tasks;
    //}

    //public void setTasks(List<task> tasks) {
    //    this.tasks = tasks;
    //}


    public user() {
    }

    public user(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof user)) //? VERIFICA SE E UM OBJETO DA CLASSE
            return false;
        user other = (user) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username) && Objects.equals(this.password, other.password);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }
}


