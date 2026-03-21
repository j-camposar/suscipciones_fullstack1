package com.subscripciones.subcripciones.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.subscripciones.subcripciones.Model.Suscrpcion;

@Repository
public class SuscripcionRepository {
    private List<Suscrpcion> listaSuscrpcions= new ArrayList<>();

    public List<Suscrpcion> listarTodos(){
        return listaSuscrpcions;
    }
    public Suscrpcion save(Suscrpcion suscrpcion){
        listaSuscrpcions.add(suscrpcion);
        return suscrpcion;
    }
    public Suscrpcion buscarPorId(int id){
        for(Suscrpcion sub : listaSuscrpcions){
            if(sub.getId() == id){
                return sub;
            }
        }
        return null;
    }
    public List<Suscrpcion> buscarActivos(){
        List<Suscrpcion> listaActivos= new ArrayList<>();
        for(Suscrpcion sub : listaSuscrpcions){
            if(sub.getIsActive()== true){
                listaActivos.add(sub); 
            }
        }
        return listaActivos;
    }

    public List<Suscrpcion>  buscarCategorias(String categoria){
         List<Suscrpcion> listaCategoria= new ArrayList<>();
        for(Suscrpcion sub : listaSuscrpcions){
            if(sub.getCategory().equals(categoria)){
                listaCategoria.add(sub); 
            }
        }
        return listaCategoria;
    }
    public Suscrpcion actualizar(Suscrpcion actualSuscrpcion){
        for(int i =0 ; i<listaSuscrpcions.size(); i ++ ){
            if(listaSuscrpcions.get(i).getId()== actualSuscrpcion.getId())  {
                listaSuscrpcions.set(i,actualSuscrpcion);
            }
        }
        return actualSuscrpcion;
    }
    public int eliminarSuscripcion(int id){
        for(int i= 0; i<listaSuscrpcions.size();i++){
            if(listaSuscrpcions.get(i).getId()== id && listaSuscrpcions.get(i).getIsActive()==false )  {
                listaSuscrpcions.remove(i);
                return 1;
            }
        }
        return 0;
    }
    public void cambiarActivo(int id){
        for(int i =0 ; i<listaSuscrpcions.size(); i ++ ){
            if(listaSuscrpcions.get(i).getId()== id){
                if(listaSuscrpcions.get(i).getIsActive() ==true){
                    listaSuscrpcions.get(i).setIsActive(false);
                }else{
                    listaSuscrpcions.get(i).setIsActive(true);
                }
            }
        }
    }

}
