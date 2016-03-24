package com.hrb.controller;

import com.hrb.config.OrientDBFactory;
import com.hrb.model.Count;
import com.hrb.util.FreeTimer;
import com.tinkerpop.blueprints.impls.orient.OrientGraphNoTx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class DefaultRouteController {
    @Autowired
    protected OrientDBFactory factory;

    @Autowired
    private FreeTimer freeTimer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUseragentJsp(Model model) {
        log.info("..\n HOME PAGE GET..\n");
        //return "index";
        return "register-success";
    }

    //TODO : add RequestNullException class
    @ExceptionHandler(Exception.class)
    public ModelAndView handleRequestNullException(Exception e) {
        log.error("Exception : " + e.getMessage());
        return new ModelAndView("ErrorPage");
    }

    /**
     * This is referenced from https://github.com/maggiolo00/orientdb-ha
     * @return
     */
    @RequestMapping(value = "counts", method = RequestMethod.GET)
    public ResponseEntity<Count> getCount() {
        OrientGraphNoTx graphtNoTx = factory.getGraphtNoTx();
        long countVertices = graphtNoTx.countVertices("V");
        log.info("******Vertex Count is {} at {} *******", countVertices, freeTimer.formattedCurrentTime());
        Count count = new Count();
        count.setCount(countVertices);
        return new ResponseEntity(count, HttpStatus.OK);
    }
}