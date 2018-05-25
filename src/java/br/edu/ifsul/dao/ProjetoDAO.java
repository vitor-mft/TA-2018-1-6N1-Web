/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Projeto;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author V_M_FT
 */
@Stateful
public class ProjetoDAO<TIPO> extends DAOGenerico<Projeto> implements Serializable {

    public ProjetoDAO() {
        super();
        classePersistente = Projeto.class;
        ordem = "id";
        maximoObjetos = 10;
    }

    public Projeto getObjectById(Object id) throws Exception {
        Projeto obj = em.find(Projeto.class, id);
        obj.getColaboradores().size();
        return obj;
    }

}
