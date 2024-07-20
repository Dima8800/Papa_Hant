package papa_hant.first.server.routes.user.service;

import java.util.Map;
import java.util.concurrent.*;

public class TimedMap {
    private Map<String, Integer> timedMap = new ConcurrentHashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public TimedMap() {
        executor.scheduleAtFixedRate(this::cleanUpMap, 2, 2, TimeUnit.HOURS);
    }

    public void put(String key, int value) {
        timedMap.put(key, value);
    }

    public int get(String key) {
        return timedMap.get(key);
    }

    private void cleanUpMap() {
        long currentTime = System.currentTimeMillis();
        timedMap.entrySet().removeIf(entry -> (currentTime - entry.getValue() > TimeUnit.HOURS.toMillis(2)));
    }
}
