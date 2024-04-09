package com.example.demo.service;

import com.example.demo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.conf.ConstraintJittingThresholdOption;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {


    private final KieContainer kieContainer;


    public StudentService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }




    public  void  student(Student student){
        log.info("执行规则前的学生信息：{}",student);
        KieServices kieServices = KieServices.Factory.get();
        KieBaseConfiguration kieBaseConfiguration = kieServices.newKieBaseConfiguration();
        kieBaseConfiguration.setOption(ConstraintJittingThresholdOption.get(-1));//禁用jittingThreshold(阈值默认20，设为-1)

        String drl=" import com.example.demo.model.Student; \n rule \"my_rule\"\n" +
                "    when\n" +
                "         $s:Student(age < 10)\n" +
                "    then\n" +
                "        System.out.println(\"规则test_rule触发\");\n" +
                "end\n";

//        Resource resource = ResourceFactory.newClassPathResource("rules/test.drl");
//        KieHelper kieHelper = new KieHelper();
//        kieHelper.addResource(resource);
//        KieBase kieBase = kieHelper.build();
//
//        KieSession kieSession = kieBase.newKieSession();

        KieHelper kieHelper = new KieHelper();
      KieSession kieSession = kieHelper.addResource(ResourceFactory.newByteArrayResource(drl.getBytes(StandardCharsets.UTF_8)), ResourceType.DRL).build(kieBaseConfiguration).newKieSession();

//
//        List<String> list=new ArrayList<>();
//        kieSession.setGlobal("count",5);
//        kieSession.setGlobal("gList",list);
//        kieSession.setGlobal("testService",new TestService());
//
//
//        Student  student0=new Student();
//        student0.setAge(10);
//        student0.setName("a");
//        kieSession.insert(student0);
//
//        Student  student1=new Student();
//        student1.setAge(26);
//        student1.setName("b");
//        kieSession.insert(student1);
//
//
//        kieSession.insert(student);
//        QueryResults query1 = kieSession.getQueryResults("query_1");
//
//        System.out.println("------------");
//        System.out.println(query1.size());
//        System.out.println("------------");
//
//        for (QueryResultsRow row : query1) {
//            Student stu= (Student)row.get("$student");
//            System.out.println("-----------");
//            System.out.println(stu);
//            System.out.println("-----------");
//        }

//        QueryResults query2 = kieSession.getQueryResults("query_2","jiangjie");
//
//        System.out.println("------query_2------");
//        System.out.println(query2.size());
//        System.out.println("------query_2------");
//
//        for (QueryResultsRow row : query2) {
//            Student stu= (Student)row.get("$student");
//            System.out.println("-----query_2------");
//            System.out.println(stu);
//            System.out.println("------query_2-----");
//        }

        kieSession.insert(student);
        kieSession.fireAllRules();
        kieSession.dispose();
        log.info("执行规则前的学生信息：{}",student);
    }

    public  void  save(){
        System.out.println("==================");
        System.out.println("111111111111111111");
        System.out.println("==================");
    }


}