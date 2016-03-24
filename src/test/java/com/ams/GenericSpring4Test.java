package com.ams;

import com.config.TestSpringConfigMin;
import com.hrb.config.OrientDBFactory;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by x148128 on 25/02/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfigMin.class)
public class GenericSpring4Test {

    @Autowired
    private OrientDBFactory factory;

    @Test
    public void testProperties() {
        assertThat(factory).isNotNull();
        Vertex vanimal1 = factory.getGraph().addVertex("class:Animal");
        vanimal1.setProperty("Name", "Tiger");

        Vertex vanimal2 = factory.getGraph().addVertex("class:Animal");
        vanimal2.setProperty("Name", "Deer");

        // Create an vertex in V class(superclass of all Vertex)
        Vertex vEmpty = factory.getGraph().addVertex(null);

        //TODO Edge ehunts = factory.getGraph().addEdge(null, vanimal1, vanimal2, "hunts");
        //Above statement creates an Edge of class E (Superclass of all Edges)

        OrientGraphNoTx graphtNoTx = factory.getGraphtNoTx();
        long countVertices = graphtNoTx.countVertices("V");
        assertThat(countVertices).isGreaterThan(0);
    }
}