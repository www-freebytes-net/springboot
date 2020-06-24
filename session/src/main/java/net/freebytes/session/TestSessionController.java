package net.freebytes.session;

import org.apache.catalina.Manager;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.session.ManagerBase;
import org.apache.catalina.session.StandardSession;
import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: 千里明月
 * @date: 2019/6/19 17:05
 */
@RestController
@RequestMapping("/test")
public class TestSessionController {

    /**
     * session失效时长
     */
    @Value("${server.servlet.session.timeout:1800}")
    private long timeout;

    /**
     * 打印session
     *
     * @param manager
     * @param map
     */
    private void printSession(Manager manager, Map<String, Object> map) {
        ManagerBase managerBase = (ManagerBase) manager;
        long sessionSum = managerBase.getActiveSessions();
        System.out.println("活跃的session数：" + sessionSum);
        map.put("用户在线数", sessionSum);
        Session[] sessions = managerBase.findSessions();
        for (int i = 0; i < sessions.length; i++) {
            Session session = sessions[i];
            //session创建时间
            long createTime = session.getCreationTime();
            //session的最后一次访问时间
            long lastAccessedTime = session.getLastAccessedTime();
            Date lastAccessedDate = new Date(lastAccessedTime);
            Date nowTime = new Date();
            //距离最后一次访问，已经过去的时长
            long length = Long.valueOf(timeout) * 1000 - (nowTime.getTime() - lastAccessedTime);
            String detail = "sessionID：" + session.getId() + " 创建时间--" + new Date(createTime) + "--上次登录时间--" + lastAccessedDate + " -距离掉线时长：" + length / 1000 + "秒";
            System.out.println(detail);
            map.put("第" + (i + 1) + "位用户", detail);
        }
    }

    /**
     * 使用spring-security的情况
     * 通过StandardSession获取Manager（管理session的容器）
     *（不使用spring-security的情况下也可以用这种方式）
     * @param sessionFacade
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private Map<String, Object> dissectRequest(StandardSessionFacade sessionFacade) throws NoSuchFieldException, IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap(8);
        Field sessionFacadeField = sessionFacade.getClass().getDeclaredField("session");
        sessionFacadeField.setAccessible(true);
        HttpSession httpSession = (HttpSession) sessionFacadeField.get(sessionFacade);
        if (httpSession instanceof StandardSession) {
            StandardSession standardSession = (StandardSession) httpSession;
            Field managerFiled = standardSession.getClass().getDeclaredField("manager");
            managerFiled.setAccessible(true);
            Manager manager = (Manager) managerFiled.get(standardSession);
            printSession(manager, map);
        }
        return map;
    }

    /**
     * 不使用spring-security的情况
     * 通过Request获取ManagerBase（管理session的容器）
     * @param requestFacade
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private Map<String, Object> dissectRequest(RequestFacade requestFacade) throws NoSuchFieldException, IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap(8);
        Field declaredField = requestFacade.getClass().getDeclaredField("request");
        declaredField.setAccessible(true);
        Request trueRequest = (Request) declaredField.get(requestFacade);
        ManagerBase managerBase = (ManagerBase) trueRequest.getContext().getManager();
        printSession(managerBase, map);
        return map;
    }

    @GetMapping("/getSessions")
    public Map getActiveSessions(HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {
        HttpSession session = request.getSession();

        //不使用spring-security的情况
        if (request instanceof RequestFacade) {
            return dissectRequest((RequestFacade) request);
        }
        //使用或不使用spring-security的情况
        if (session instanceof StandardSessionFacade) {
            return dissectRequest((StandardSessionFacade) session);
        }

        return null;
    }


}
