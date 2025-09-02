package com.bullPenTalk.app.trade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TradeService {
    public void execute(String action, String category, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
