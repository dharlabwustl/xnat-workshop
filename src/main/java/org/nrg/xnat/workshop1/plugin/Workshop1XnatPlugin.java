/*
 * xnat-workshop1: org.nrg.xnat.workshop1.plugin.Workshop1XnatPlugin
 * XNAT http://www.xnat.org
 * Copyright (c) 2017, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.workshop1.plugin;

import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xdat.bean.Workshop1Biosample1collectionBean;
//import org.nrg.xdat.bean.RadRadiologyreaddataBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@XnatPlugin(value = "workshop1Plugin", name = "XNAT 1.7 Workshop1 2016 Plugin", entityPackages = "org.nrg.xnat.workshop1.entities",
            dataModels = {@XnatDataModel(value = Workshop1Biosample1collectionBean.SCHEMA_ELEMENT_NAME,
                                         singular = "Stroke Edema Collection", // Biosample1 Collection
                                         plural = "Stroke Edema Collections")})
//,
//                          @XnatDataModel(value = RadRadiologyreaddataBean.SCHEMA_ELEMENT_NAME,
//                                         singular = "Radiology Read",
//                                         plural = "Radiology Reads")})
@ComponentScan({"org.nrg.xnat.workshop1.subjectmapping.preferences",
        "org.nrg.xnat.workshop1.subjectmapping.repositories",
        "org.nrg.xnat.workshop1.subjectmapping.rest",
        "org.nrg.xnat.workshop1.subjectmapping.services.impl"})
public class Workshop1XnatPlugin {
    @Bean
    public String workshop1PluginMessage() {
        return "Hello there from the workshop1 plugin!";
    }
}
