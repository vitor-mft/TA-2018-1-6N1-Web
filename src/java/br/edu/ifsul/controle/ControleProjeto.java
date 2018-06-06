package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ColaboradorDAO;
import br.edu.ifsul.dao.SetorDAO;
import br.edu.ifsul.dao.ProjetoDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Colaborador;
import br.edu.ifsul.modelo.Setor;
import br.edu.ifsul.modelo.Projeto;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Named(value = "controleProjeto")
@ViewScoped
public class ControleProjeto implements Serializable {

    @EJB
    private ProjetoDAO<Projeto> dao;
    private Projeto objeto;
    private Boolean editando;

    @EJB
    private SetorDAO<Setor> daoSetor;

    @EJB
   private ColaboradorDAO<Colaborador> daoColaborador;
   private Colaborador colaborador;
   private Boolean editandoColaborador;
   
   @EJB
    private UsuarioDAO<Usuario> daoUsuario;
    private Usuario usuario;
    private Boolean editandoUsuario;

    public ControleProjeto() {
        editando = false;
    }

    public String listar() {
        editando = false;
        return "/privado/Projeto/listar?faces-redirect=true";
    }

    public void novo() {
        editando = true;
        objeto = new Projeto();
        editandoColaborador = false;
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
            editando = true;
            editandoColaborador = false;
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
            editando = false;
            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: "
                    + Util.getMensagemErro(e));
        }
    }

    public void novoColaborador() {
          colaborador = new Colaborador();
        editandoColaborador = true;

    }

    public void salvarColaborador() {
        if (objeto.getColaboradores().contains(colaborador)) {
            Util.mensagemErro("Colaborador Já faz parte deste Projeto");
        } else {
          // objeto.getColaboradores().add(colaborador);
            objeto.adicionarColaborador(colaborador);
            Util.mensagemInformacao("Colaborador Incluido com Sucesso");
        }
        editandoColaborador = false;
    }
    public void removerColaborador (Colaborador obj){
        objeto.getColaboradores().remove(obj);
        Util.mensagemInformacao("Colaborador removido com Sucesso!!!!");
    }

    public ProjetoDAO<Projeto> getDao() {
        return dao;
    }

    public void setDao(ProjetoDAO<Projeto> dao) {
        this.dao = dao;
    }

    public Projeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Projeto objeto) {
        this.objeto = objeto;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public SetorDAO<Setor> getDaoSetor() {
        return daoSetor;
    }

    public void setDaoSetor(SetorDAO<Setor> daoSetor) {
        this.daoSetor = daoSetor;
    }

    public ColaboradorDAO<Colaborador> getDaoColaborador() {
        return daoColaborador;
    }

    public void setDaoColaborador(ColaboradorDAO<Colaborador> daoColaborador) {
        this.daoColaborador = daoColaborador;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Boolean getEditandoColaborador() {
        return editandoColaborador;
    }

    public void setEditandoColaborador(Boolean editandoColaborador) {
        this.editandoColaborador = editandoColaborador;
    }

   
    public UsuarioDAO<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDAO<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getEditandoUsuario() {
        return editandoUsuario;
    }

    public void setEditandoUsuario(Boolean editandoUsuario) {
        this.editandoUsuario = editandoUsuario;
    }

}
