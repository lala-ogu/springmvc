package practice.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

    @Around("execution(* practice.springmvc..*(..))")   // 포인트컷
    public  Object execute(ProceedingJoinPoint joinPoint) throws  Throwable {
        // 시간 트랙커 로직
        long start = System.currentTimeMillis();
        System.out.println("Start : " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("End : " + joinPoint.toString() + timeMs + "ms");
        }
    }
}
