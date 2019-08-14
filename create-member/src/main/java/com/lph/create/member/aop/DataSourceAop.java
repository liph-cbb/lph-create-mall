package com.lph.create.member.aop;

import com.lph.create.member.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName DataSourceAop
 * @Description
 * @Author penghui.li
 * @Version V1.0.0
 * @Date 2019-08-07 11:10:19
 */
@Aspect
@Component
public class DataSourceAop {
    @Pointcut("!@annotation(com.lph.create.member.annotation.Master) " +
            "&& (execution(* com.lph.create.member.service.*.select*(..)) " +
            "|| execution(* com.lph.create.member.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.lph.create.member.annotation.Master) " +
            "|| execution(* com.lph.create.member.service..*.insert*(..)) " +
            "|| execution(* com.lph.create.member.service..*.add*(..)) " +
            "|| execution(* com.lph.create.member.service..*.update*(..)) " +
            "|| execution(* com.lph.create.member.service..*.edit*(..)) " +
            "|| execution(* com.lph.create.member.service..*.delete*(..)) " +
            "|| execution(* com.lph.create.member.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
