package br.evento.controller.actions.impl;

import br.evento.controller.actions.IActionsCommand;
import br.evento.dao.impl.UsuarioDao;
import br.evento.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallValidaLoginAction implements IActionsCommand{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String login = request.getParameter("cpLogin");
        String senha = request.getParameter("cpSenhaLogin");
        
        Usuario usuario = new UsuarioDao().findByLoginPassword(login, senha);

        if(usuario == null){
            request.setAttribute("msg", "Login e/ou senha incorreto(s)!");
            new CallLoginViewAction().executar(request, response);
        }else{
            request.getSession().setAttribute("user", usuario);
            new CallUsuarioLogadoAction().executar(request, response);
        }
        
    }
    
}
