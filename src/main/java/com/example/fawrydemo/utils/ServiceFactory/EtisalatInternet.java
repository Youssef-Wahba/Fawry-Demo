package com.example.fawrydemo.utils.ServiceFactory;

import com.example.fawrydemo.models.GlobalServices;
import com.example.fawrydemo.utils.Form.EtisalatInternetForm;
import com.example.fawrydemo.utils.Form.IForm;
import com.example.fawrydemo.utils.Handler.EtisalatInternetHandler;
import com.example.fawrydemo.utils.Handler.IHandler;
import com.example.fawrydemo.utils.Providers.Etisalat;
import com.example.fawrydemo.utils.Providers.IProvider;

public class EtisalatInternet implements IService{
    private String name="Etisalat Internet Pay";

    public EtisalatInternet() {
        //add name of service to global service names for search functionalities
        GlobalServices globalServices=GlobalServices.getGlobalUser();
        globalServices.addServiceName(name);
    }

    @Override
    public IProvider getProvider() {
        return new Etisalat();
    }

    @Override
    public IForm getForm() {
        return  new EtisalatInternetForm("",0);
    }

    @Override
    public IHandler getHandler() {
        return new EtisalatInternetHandler();
    }
}
