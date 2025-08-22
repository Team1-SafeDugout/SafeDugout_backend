package com.bullPenTalk.app.trade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TradeService {
    public void execute(String action, HttpServletRequest request, HttpServletResponse response);
}
