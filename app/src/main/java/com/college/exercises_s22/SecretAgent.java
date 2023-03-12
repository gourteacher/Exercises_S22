package com.college.exercises_s22;

import androidx.annotation.NonNull;

public class SecretAgent {
    private String name = null;
    private int age = 0;
    private String secretIdentity = null;

    public SecretAgent()
    {
        this(null, 0, null);
    }

    public SecretAgent(String name, int age, String secretIdentity) {
        this.setName(name);
        this.setAge(age);
        this.setSecretIdentity(secretIdentity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    @NonNull
    public String toString() {
        return getName() + " " + getAge() + " " + getSecretIdentity();
    }

}