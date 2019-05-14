package beans.proxy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author yanmingkun
 * @date 2019-03-12 10:54
 */
public class TimeHandler {
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("beforeAdvice.");
    }

    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("afterAdvice");
    }

    public void afterReturningAdvice(JoinPoint joinPoint, Object retVal) {
        System.out.println("afterReturningAdvice:" + retVal.toString());
    }

    public void afterThrowingAdvice(JoinPoint joinPoint, IllegalArgumentException ex) {
        System.out.println("afterThrowingAdvice: " + ex.toString());
    }

    /**
     * 环绕通知
     *
     * @param pjp
     */
    public void printTime(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            System.out.println(method.getName() + "()方法开始时间：" + System.currentTimeMillis());

            try {
                pjp.proceed();
                System.out.println(method.getName() + "()方法结束时间：" + System.currentTimeMillis());
            } catch (Throwable e) {

            }
        }
    }
}
