package br.evento.controller.actions.impl;

import br.evento.controller.actions.IActionsCommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallAjaxValidaPasswordAction implements IActionsCommand{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
       String senha = request.getParameter("senha");
       
       if(senha == null || senha.isEmpty()){
           response.getWriter().print("Senha vazia!");
       }else if(!senha.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$") ){
           response.getWriter().print("Senha deve conter pelo menos 5 caracteres. Sendo: 1 número, 1 letra e 1 caractere especial!");
       }
    }
    
}
