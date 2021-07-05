package com.example.demo.repositories;
import java.util.ArrayList;

import com.example.demo.models.UsuarioModel;//Hacer uso del modelo 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//Vamos a usar esta interfaz
@Repository 
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>{
    
    //Este metodo nos va ayudar a buscar usuario de acuerdo a al prioridad
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);

}