package br.evento.controller.actions.impl;

import br.evento.controller.actions.IActionsCommand;
import br.evento.dao.impl.UsuarioDao;
import br.evento.model.Usuario;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallSalvarUsuarioAction implements IActionsCommand{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  sdf.parse(request.getParameter("campodata"));
        
        Usuario usuario = new Usuario(0, request.getParameter("cpNome"), request.getParameter("cpEmail"), request.getParameter("cpSenha"));
        
        ArrayList<String> listaErros = new ArrayList<>();
        
        if(usuario.getNome().isEmpty()){
            listaErros.add("Nome não pode ser vazio!");
        }
        if(usuario.getEmail().isEmpty()){
            listaErros.add("E-mail não pode ser vazio!");
        }
        if(usuario.getSenha().isEmpty()){
            listaErros.add("Senha não pode ser vazio!");
        }
        if(listaErros.size() > 0){
            request.setAttribute("erros", listaErros);
            request.setAttribute("usuario", usuario);
            new CallCadastroViewAction().executar(request, response);
        }else{
            new UsuarioDao().save(usuario);
            request.setAttribute("msg", "Usuário "+usuario.getNome()+" salvo com sucesso!");
            new CallAvisoViewAction().executar(request, response);
        }
    }
    
}
