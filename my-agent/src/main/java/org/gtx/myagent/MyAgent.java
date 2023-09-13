package org.gtx.myagent;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.Resource;
import io.github.classgraph.ResourceList;
import io.github.classgraph.ScanResult;

import java.lang.instrument.Instrumentation;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C) 2020-2022 杭州优诗科技有限公司
 * This file is part of UnitSpirit.
 * TODO
 *
 * @author gtx
 * @version 1.0.0
 * @Date 2023/9/13 10:03
 **/
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) throws Exception {
        System.err.println("========= enter my-agent ===============");
        ScanResult scanResult = new ClassGraph()
                .verbose()
                .scan();
        ResourceList resources = scanResult.getAllResources().classFilesOnly();
        List<Resource> myapp = resources.stream()
                // find my app class
                // expected 3 class found
                .filter(resource -> resource.getPath().contains("myapp"))
                .collect(Collectors.toList());

        System.err.println("========= print scanned myapp‘s class  ===============");
        for (Resource resource : myapp) {
            System.err.println(resource.getPath());
        }

        System.err.println("========= end of  my-agent  ===============");
    }
}
