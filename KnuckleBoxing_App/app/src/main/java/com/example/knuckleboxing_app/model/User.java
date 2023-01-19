package com.example.knuckleboxing_app.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "user")
public class User implements  Serializable{
    @PrimaryKey
    @NonNull
    public String usuario;

    @ColumnInfo(name="password")
    public String contraseña;

    @ColumnInfo(name="genre")
    public String sexo;

    @ColumnInfo(name="experience")
    public boolean experiencia;


    public User(){

    }
    public User(String usuario, String contraseña, String sexo,boolean experiencia){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.sexo=sexo;
        this.experiencia=experiencia;
    }
    public String getUser(){
        return usuario;
    }
    public void setUser(String usuario){
        this.usuario=usuario;
    }
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    public boolean getExperiencia(){
        return experiencia;
    }
    public void setExperiencia(boolean experiencia){
        this.experiencia=experiencia;
    }
}
