package com.example.fawrydemo.utils.ServiceFactory;

import com.example.fawrydemo.utils.Form.IForm;
import com.example.fawrydemo.utils.Form.VodafoneCashForm;
import com.example.fawrydemo.models.GlobalServices;
import com.example.fawrydemo.utils.Handler.IHandler;
import com.example.fawrydemo.utils.Handler.VodafoneCashHandler;
import com.example.fawrydemo.utils.Providers.IProvider;
import com.example.fawrydemo.utils.Providers.Vodafone;

public class VodafoneCash implements IService{
    private String name="Vodafone cash";

    public VodafoneCash() {
        //add name of service to global service names for search functionalities
        GlobalServices globalServices=GlobalServices.getGlobalUser();
        globalServices.addServiceName(name);
    }

    @Override
    public IProvider getProvider() {
        return new Vodafone();
    }

    @Override
    public IForm getForm() {
        return  new VodafoneCashForm("",0);
    }

    @Override
    public IHandler getHandler() {
        return new VodafoneCashHandler();
    }
}
