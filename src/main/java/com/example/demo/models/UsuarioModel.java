package com.example.demo.models;

import javax.persistence.*;//Para poder usar las anotaciones


@Entity //Le indico que tome el modelo como una tabla 
@Table(name="Usuarios") //Con esto asigno el nombre de la tabla para la base de datos
public class UsuarioModel{


    //Atributos de nuestro modelo Usuario

    @Id //Para que este atributo id referencia para id del modelo
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Tipo PK
    @Column(unique=true,nullable=false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;



    //Establedemos los get y set ; Propiedades
     public void setPrioridad(Integer prioridad){
        this.prioridad = prioridad;
    }

    public Integer getPrioridad(){
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    


}