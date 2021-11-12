package com.training.javaee.cdi.interceptor;

import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@CheckIntercept
public class MyInterceptor {

    @AroundInvoke
    public Object intercept(final InvocationContext ic) throws Throwable {
        try {
            Method methodLoc = ic.getMethod();
            Class<?> declaringClassLoc = methodLoc.getDeclaringClass();
            System.out.println("I am calling " + declaringClassLoc.getName() + "." + methodLoc.getName());
            Object[] parametersLoc = ic.getParameters();
            Object[] newParametersLoc = new Object[parametersLoc.length];
            newParametersLoc[0] = parametersLoc[0] + " girdi";
            ic.setParameters(newParametersLoc);
            long delta = System.nanoTime();
            Object proceedLoc = ic.proceed();
            System.out.println(declaringClassLoc.getName()
                               + "."
                               + methodLoc.getName()
                               + " Delta : "
                               + (System.nanoTime() - delta));
            if (proceedLoc instanceof String) {
                String stringLoc = (String) proceedLoc;
                return stringLoc + " intercepted";
            }
            return proceedLoc;
        } catch (Throwable eLoc) {
        }
        return null;
    }

}
