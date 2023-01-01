package com.example.fawrydemo.utils.ServiceFactory;

import com.example.fawrydemo.models.GlobalServices;
import com.example.fawrydemo.utils.Form.IForm;
import com.example.fawrydemo.utils.Form.LandlineForm;
import com.example.fawrydemo.utils.Handler.IHandler;
import com.example.fawrydemo.utils.Handler.LandlineHandler;
import com.example.fawrydemo.utils.Providers.IProvider;
import com.example.fawrydemo.utils.Providers.We;


public class Landline implements IService {
    private String name="Landline pay";

    public Landline() {
        //add name of service to global service names for search functionalities
        GlobalServices globalServices=GlobalServices.getGlobalUser();
        globalServices.addServiceName(name);
    }

    @Override
    public IProvider getProvider() {
        return new We();
    }

    @Override
    public IForm getForm() {
        return  new LandlineForm("");
    }

    @Override
    public IHandler getHandler() {
        return new LandlineHandler();
    }
}
