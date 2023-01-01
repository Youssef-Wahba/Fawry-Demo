package com.example.fawrydemo.utils.ServiceFactory;

import com.example.fawrydemo.utils.Form.IForm;
import com.example.fawrydemo.utils.Handler.IHandler;
import com.example.fawrydemo.utils.Providers.IProvider;

public interface IService {
    public IProvider getProvider();
    public IForm getForm();
    public IHandler getHandler();

}
