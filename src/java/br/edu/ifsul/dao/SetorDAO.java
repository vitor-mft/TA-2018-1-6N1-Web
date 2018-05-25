package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Setor;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class SetorDAO<TIPO> extends DAOGenerico<Setor> implements Serializable {

    public SetorDAO(){
        super();
        classePersistente = Setor.class;
        ordem = "nome";
    }
}
