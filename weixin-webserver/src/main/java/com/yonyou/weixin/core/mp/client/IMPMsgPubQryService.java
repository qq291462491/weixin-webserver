package com.yonyou.weixin.core.mp.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2014-12-04T17:57:43.952+08:00
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://itf.mp.uap.yonyou.com/", name = "IMPMsgPubQryService")
@XmlSeeAlso({ObjectFactory.class})
public interface IMPMsgPubQryService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getMessageVOsByUserAndSystemAndType", targetNamespace = "http://itf.mp.uap.yonyou.com/", className = "com.yonyou.weixin.core.mp.client.GetMessageVOsByUserAndSystemAndType")
    @WebMethod
    @ResponseWrapper(localName = "getMessageVOsByUserAndSystemAndTypeResponse", targetNamespace = "http://itf.mp.uap.yonyou.com/", className = "com.yonyou.weixin.core.mp.client.GetMessageVOsByUserAndSystemAndTypeResponse")
    public java.util.List<com.yonyou.weixin.core.mp.client.MpMessageUrlVO> getMessageVOsByUserAndSystemAndType(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    ) throws Exception_Exception;
}
