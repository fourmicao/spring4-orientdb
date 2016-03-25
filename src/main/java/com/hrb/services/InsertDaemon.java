package com.hrb.services;

/**
 * Created on 24/03/2016.
 */

import com.hrb.config.OrientDBFactory;
import com.hrb.util.FreeTimer;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@EnableScheduling
@Component
public class InsertDaemon {

    @Autowired
    private FreeTimer freeTimer;

    @Autowired
    private OrientDBFactory factory;

    @Scheduled(fixedDelay = 3000)
    public void insert() {

        OrientGraphNoTx graphtNoTx = factory.getGraphtNoTx();
        log.info("****** Adding a UUID at {} *******", freeTimer.formattedCurrentTime());
        graphtNoTx.command(new OCommandSQL("insert into v set uuid = ?, port = ?")).execute(UUID.randomUUID().toString(), 8899);
    }
}
