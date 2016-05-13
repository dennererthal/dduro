package com.example.maiquel.dduro.model.data;

/**
 * Created by maiquel on 09/05/16.
 */
public class User
{
    private int id;

    private String name;
    private String cpf;
    private String email;
    private String password;

    private char status;

    public User(int id, String name, String cpf, String email, String password, char status)
    {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User(String name, String cpf, String email, String password, char status)
    {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public char getStatus()
    {
        return status;
    }

    public void setStatus(char status)
    {
        this.status = status;
    }

    @Override public String toString()
    {
        return this.getName();
    }
}
