package br.evento.controller.actions.impl;

import br.evento.controller.actions.IActionsCommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallCadastroViewAction implements IActionsCommand{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=cadastro");
        rd.forward(request, response);
    }
    
}
