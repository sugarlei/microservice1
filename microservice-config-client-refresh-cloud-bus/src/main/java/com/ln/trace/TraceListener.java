package com.ln.trace;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.cloud.bus.event.SentApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TraceListener {
    private static Log log = LogFactory.getLog(TraceListener.class);
    private CustomeTraceRepository repository;

    public TraceListener(CustomeTraceRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void onAck(AckRemoteApplicationEvent event) {
        this.getReceivedTrace(event);
    }

    @EventListener
    public void onSend(SentApplicationEvent event) {
        this.getSentTrace(event);
    }

    protected Map<String, Object> getSentTrace(SentApplicationEvent event) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("signal", "spring.cloud.bus.sent");
        map.put("type", event.getType().getSimpleName());
        map.put("id", event.getId());
        map.put("origin", event.getOriginService());
        map.put("destination", event.getDestinationService());
        if (log.isDebugEnabled()) {
            log.debug(map);
        }
        this.repository.add(map);
        return map;
    }

    protected Map<String, Object> getReceivedTrace(AckRemoteApplicationEvent event) {
        LinkedHashMap map = new LinkedHashMap();
        map.put("signal", "spring.cloud.bus.ack");
        map.put("event", event.getEvent().getSimpleName());
        map.put("id", event.getAckId());
        map.put("origin", event.getOriginService());
        map.put("destination", event.getAckDestinationService());
        if (log.isDebugEnabled()) {
            log.debug(map);
        }
        this.repository.add(map);
        return map;
    }
}