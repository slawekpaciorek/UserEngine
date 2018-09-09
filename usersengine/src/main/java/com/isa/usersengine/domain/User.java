package com.isa.usersengine.domain;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    Integer id;

    @Column(nullable = false, length = 30)
    String name;

    @Column(nullable = false, length = 30)
    String surname;

    @Column(nullable = false, length = 30, unique = true)
    String login;

    @Column(nullable = false, length = 16)
    String password;

    @Column(nullable = false)
    Integer age;

    @Column
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column
    @Enumerated(EnumType.STRING)
    Status status = Status.W;

    @OneToOne(fetch = FetchType.LAZY ,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private Stats stats;


    //for JPA

    public User(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", status=" + status +
//                ", stats=" + stats +
                '}';
    }
}
