package com.yonyou.weixin.core.cxf.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2014-12-04T11:00:38.680+08:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "YYUserWSService", 
                  wsdlLocation = "http://121.42.24.106/note-web/ws/YYUserWS?wsdl",
                  targetNamespace = "http://service.yyuser.cxf.note.dd.org/") 
public class YYUserWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.yyuser.cxf.note.dd.org/", "YYUserWSService");
    public final static QName YYUserWSPort = new QName("http://service.yyuser.cxf.note.dd.org/", "YYUserWSPort");
    static {
        URL url = null;
        try {
            url = new URL("http://121.42.24.106/note-web/ws/YYUserWS?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(YYUserWSService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://121.42.24.106/note-web/ws/YYUserWS?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public YYUserWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public YYUserWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public YYUserWSService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public YYUserWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public YYUserWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public YYUserWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns YYUserWS
     */
    @WebEndpoint(name = "YYUserWSPort")
    public YYUserWS getYYUserWSPort() {
        return super.getPort(YYUserWSPort, YYUserWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns YYUserWS
     */
    @WebEndpoint(name = "YYUserWSPort")
    public YYUserWS getYYUserWSPort(WebServiceFeature... features) {
        return super.getPort(YYUserWSPort, YYUserWS.class, features);
    }

}
