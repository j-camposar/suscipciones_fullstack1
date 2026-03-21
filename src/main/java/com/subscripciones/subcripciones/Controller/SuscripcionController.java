package com.subscripciones.subcripciones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.subscripciones.subcripciones.Model.Suscrpcion;
import com.subscripciones.subcripciones.Service.SuscripcionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1")
public class SuscripcionController {
    @Autowired 
    private SuscripcionService suscripcionService;

    @GetMapping("/buscarTodos")
    public List<Suscrpcion> buscarTodos() {
        return suscripcionService.buscarTodos();
    }
    
    @PostMapping("/crear")
    public Suscrpcion crear(@RequestBody Suscrpcion suscrpcion) {
        suscripcionService.crear(suscrpcion);
        return suscrpcion;
    }
    
    @PutMapping("/actualizar/{id}")
    public Suscrpcion actualizar(@PathVariable int id, @RequestBody Suscrpcion suscrpcion) {
        suscripcionService.actualizar(suscrpcion);
        return suscrpcion;
    }
    @GetMapping("/buscarPorId/{id}")
    public Suscrpcion buscarPorID(@PathVariable int id) {
        return suscripcionService.buscarPorId(id);
    }

    @GetMapping("/buscarPorCategoria/{cat}")
    public List<Suscrpcion> buscarPorCategoria(@PathVariable String cat) {
        return suscripcionService.buscarPorCategoria(cat);
    }
    @GetMapping("/buscarActivos")
    public List<Suscrpcion> buscarActivos() {
        return suscripcionService.buscarActivos();
    }
    @GetMapping("/suscripcion/{id}/activo")
    public String  cambiarEstado(@PathVariable int id) {
        suscripcionService.actualizarEstado(id);
        return "actualizado";
    }
    @DeleteMapping("/suscripcion/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        suscripcionService.eliminar(id);
        return "eliminado";
    }
}
