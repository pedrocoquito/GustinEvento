package br.evento.controller.actions.impl;

import br.evento.controller.actions.IActionsCommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallSairAction implements IActionsCommand{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        new CallHomeViewAction().executar(request, response);
    }
    
}
