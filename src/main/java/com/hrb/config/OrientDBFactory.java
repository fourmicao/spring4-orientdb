package com.hrb.config;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 24/03/2016.
 */
@Slf4j
@Component
public class OrientDBFactory {

    @Value("${connection.url}")
    private String url;

    @Value("${connection.usr}")
    private String usr;

    @Value("${connection.pwd}")
    private String pwd;

    private OrientGraphFactory factory;

    ThreadLocal<OrientGraph> graphThreadLocal = new ThreadLocal<OrientGraph>();

    public OrientDBFactory() {
    }

    @PostConstruct
    public void initFactory() {
        factory = new OrientGraphFactory(url, usr, pwd);
    }

    public OrientGraph getGraph() {
        OrientGraph graph = graphThreadLocal.get();
        if (graph == null) {
            graph = factory.getTx();
            graphThreadLocal.set(graph);
        }
        return graph;
    }

    public OrientGraphNoTx getGraphtNoTx() {
        return factory.getNoTx();
    }

    public void unsetDb() {
        graphThreadLocal.set(null);
    }
}
