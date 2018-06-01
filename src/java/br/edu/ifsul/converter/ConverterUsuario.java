/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converter;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author V_M_FT
 */
@FacesConverter (value = "converterUsuario")
public class ConverterUsuario implements Serializable, Converter{
    
    @PersistenceContext(unitName =  "TA-2018-1-6N1-WebPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       if ( string == null || string.equals("Selecione um Registro")){
           return null;
       }
        return em.find(Usuario.class,Integer.parseInt(string));
        
    }

    //aqui so vai precisar retornar o ID
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
    if(o == null){
        return null;
    } 
    Usuario obj = (Usuario) o;
   return obj.getId().toString();
    }
    
}
