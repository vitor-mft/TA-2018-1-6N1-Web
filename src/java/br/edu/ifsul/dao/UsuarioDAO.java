/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author V_M_FT
 */
@Stateful
public class UsuarioDAO<TIPO> extends DAOGenerico<Usuario> implements Serializable {

    public UsuarioDAO() {
        super();
        classePersistente = Usuario.class;
        ordem = "nome";
        maximoObjetos = 3;
    }

    public Usuario getObjectById(Object id) throws Exception {
        Usuario obj = em.find(Usuario.class, id);
        obj.getPermissoes().size();
        return obj;
    }

}
