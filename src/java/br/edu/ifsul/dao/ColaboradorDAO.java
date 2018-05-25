package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Colaborador;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class ColaboradorDAO<TIPO> extends DAOGenerico<Colaborador> implements Serializable {

    public ColaboradorDAO(){
        super();
        classePersistente = Colaborador.class;
        ordem = "nome";
        maximoObjetos = 2;
    }
}
