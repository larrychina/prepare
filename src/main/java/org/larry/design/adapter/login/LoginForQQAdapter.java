package org.larry.design.adapter.login;

import org.larry.design.adapter.AbstactAdapter;
import org.larry.design.adapter.ResultMsg;

public class LoginForQQAdapter extends AbstactAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        return null;
    }

    @Override
    public ResultMsg login(String username, String password, Object adapter) {
        if(!support(adapter)){
            return null ;
        }
        return super.login(username,password);
    }
}
