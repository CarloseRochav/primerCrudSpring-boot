package com.example.demo.services;

import java.util.ArrayList; //Para poder usar los ArrayList
import java.util.Optional; //Tipo de dato que maneja "opciones"

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;//Usar la anotacion de autowired
import org.springframework.stereotype.Service;

@Service
public class UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    //Vamos a crear tres metodos que no van ayudar a crear las consultas
    public Optional<UsuarioModel> ObtenerPorId(Long id){//Optional ; Tipo de dato
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);

    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;

        }
    }

}