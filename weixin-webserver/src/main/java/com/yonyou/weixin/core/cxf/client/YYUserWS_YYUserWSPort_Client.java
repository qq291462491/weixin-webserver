
package com.yonyou.weixin.core.cxf.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2014-12-04T11:00:38.643+08:00
 * Generated source version: 3.0.2
 * 
 */
public final class YYUserWS_YYUserWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.yyuser.cxf.note.dd.org/", "YYUserWSService");

    private YYUserWS_YYUserWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = YYUserWSService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        YYUserWSService ss = new YYUserWSService(wsdlURL, SERVICE_NAME);
        YYUserWS port = ss.getYYUserWSPort();  
        
        {
//        System.out.println("Invoking bindUser...");
//        java.lang.String _bindUser_userid = "";
//        java.lang.String _bindUser_username = "";
//        java.lang.String _bindUser_password = "";
//        java.lang.String _bindUser__return = port.bindUser(_bindUser_userid, _bindUser_username, _bindUser_password);
//        System.out.println("bindUser.result=" + _bindUser__return);


        }
        {
        System.out.println("Invoking updateUser...");
        java.lang.String _updateUser_userid = "0000049835";
        java.lang.String _updateUser_username = "liuy0";
        java.lang.String _updateUser_password = "liuxy@2013";
        java.lang.String _updateUser__return = port.updateUser(_updateUser_userid, _updateUser_username, _updateUser_password);
        System.out.println("updateUser.result=" + _updateUser__return);


        }
        {
        System.out.println("Invoking findUser...");
        java.lang.String _findUser_userid = "0000049835";
        java.lang.String _findUser__return = port.findUser(_findUser_userid);
        System.out.println("findUser.result=" + _findUser__return);


        }

        System.exit(0);
    }

}
