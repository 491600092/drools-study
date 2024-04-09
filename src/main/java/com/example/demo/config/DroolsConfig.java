package com.example.demo.config;


import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Drools Config.
 * @author Praveen.Nair
 */
@Configuration
public class DroolsConfig {

    private static final String RULES_CUSTOMER_RULES_DRL = "rules/customer-category.drl";


    private static final String ORDER_RULES_DRL = "rules/order.drl";


    private static final String STUDENT_RULES_DRL = "rules/student.drl";



    private static final String SALIENCE_RULES_DRL = "rules/salience.drl";
    @Bean
    public KieContainer kieContainer() {
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm");
        final KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();


        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));
        //订单规则
        kieFileSystem.write(ResourceFactory.newClassPathResource(ORDER_RULES_DRL));

        //学生规则
        kieFileSystem.write(ResourceFactory.newClassPathResource(STUDENT_RULES_DRL));

        //测试顺序
        kieFileSystem.write(ResourceFactory.newClassPathResource(SALIENCE_RULES_DRL));


        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();

        return  kieServices.newKieContainer(kieModule.getReleaseId());
    }

//    @Bean("orderContainer")
//    public KieContainer orderContainer() {
//        final KieServices kieServices = KieServices.Factory.get();
//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//        kieFileSystem.write(ResourceFactory.newClassPathResource(ORDER_RULES_DRL));
//        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
//        kb.buildAll();
//        KieModule kieModule = kb.getKieModule();
//        return kieServices.newKieContainer(kieModule.getReleaseId());
//    }



}