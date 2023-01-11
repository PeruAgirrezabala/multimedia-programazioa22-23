package model;

import java.io.Serializable;

public class User implements Serializable {
    public String usuario,contraseña,sexo;
    public boolean experiencia;

    public User(){

    }
    public User(String usuario,String contraseña, String sexo,boolean experiencia){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.sexo=sexo;
        this.experiencia=experiencia;
    }
}
