package com.example.demo.controllers; //Necesario 

import com.example.demo.services.UsuarioService; //hacer uso de la clase de UsuarioService

import java.util.ArrayList;//Poder usar los datos de tipo ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel; //hacer uso de la clase de UsuarioService

import org.springframework.beans.factory.annotation.Autowired;

//Usar las anotaciones de tipo Get,Post,Req asi como mapeo de rutas
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;//Tambien podemos usar todos sus metodos de esa libreria

@RestController//Indica que sera usado como controller
@RequestMapping("/usuario")//Mapear la direccion donde se hara la peticion
public class UsuarioController{
    @Autowired //Para instancia de manera automatica
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path="/{id}")//Obtener un usuario en especifico
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.ObtenerPorId(id);
    }

    @GetMapping("/query")//Obtener usuarios por prioridad
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok=this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino Correctamente";
        }else{
            return "No pudo eliminarse el usuario";
        }
    }

}