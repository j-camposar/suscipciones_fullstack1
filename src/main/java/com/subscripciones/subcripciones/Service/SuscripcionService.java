package com.subscripciones.subcripciones.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subscripciones.subcripciones.Model.Suscrpcion;
import com.subscripciones.subcripciones.Repository.SuscripcionRepository;

@Service
public class SuscripcionService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    public List<Suscrpcion> buscarTodos(){
        return suscripcionRepository.listarTodos();
    }
    public Suscrpcion buscarPorId(int id){
        return suscripcionRepository.buscarPorId(id);
    }
    public List<Suscrpcion> buscarPorCategoria(String categoria){
        return suscripcionRepository.buscarCategorias(categoria);
    }
    public int crear(Suscrpcion suscrpcionCreate){
        if(suscrpcionCreate.getPrice()>0){
            suscripcionRepository.save(suscrpcionCreate);  
            return 1;
        }else{
            return 0;
        }
    }
    public Suscrpcion actualizar (Suscrpcion susActualizar){
        return suscripcionRepository.actualizar(susActualizar);
    }
    public int  eliminar(int id ){
        return suscripcionRepository.eliminarSuscripcion(id);
    }
    public List<Suscrpcion> buscarActivos(){
        return suscripcionRepository.buscarActivos();
    }
    public void actualizarEstado(int id){
        suscripcionRepository.cambiarActivo(id);
    }
}
