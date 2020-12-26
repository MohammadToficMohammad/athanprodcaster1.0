package com.athanprodcaster.ProjectService.Service;

import org.springframework.stereotype.Service;

import com.athanprodcaster.ProjectServiceRpcClient.IProjectServiceClient;
import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;


@Service
@JsonRpcService("/rpc/ProjectRpcService")
@AutoJsonRpcServiceImpl
public class ProjectRpcService implements IProjectServiceClient{

}
