package com.abn.dsalgos.challenges.string;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Parse log file — extract latencies, group by status, calculate averages

Input: log lines like
  "taskId=1 duration=450ms status=SUCCESS"
  "taskId=2 duration=120ms status=FAILED"
  "taskId=3 duration=800ms status=SUCCESS"

Output:
  Group by status
  Count per status
  Average duration per status
 */
class StatusStats {
    int count = 0;
    long totalDuration = 0;

    double avgDuration() {
        return count == 0 ? 0 : (double) totalDuration / count;
    }
}
public class LogParser {

    public Map<String, StatusStats> parseLog(List<String> logLines) {

        Map<String, StatusStats> result = new HashMap<>();

        for(String line: logLines) {
            String[] parts = line.split(" ");
            String status = null;
            int duration = 0;

            for (String part : parts) {
                String[] keyValue = part.split("=");
                if (keyValue[0].equals("status")) {
                    status = keyValue[1];
                } else if (keyValue[0].equals("duration")) {
                    duration = Integer.parseInt(keyValue[1].replace("ms", ""));
                }
            }

            if(status != null) {
                result.putIfAbsent(status, new StatusStats());
                StatusStats statusStats = result.get(status);
                statusStats.count++;
                statusStats.totalDuration += duration;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "taskId=1 duration=450ms status=SUCCESS",
                "taskId=2 duration=120ms status=FAILED",
                "taskId=3 duration=800ms status=SUCCESS",
                "taskId=4 duration=200ms status=FAILED"
        );

        Map<String, StatusStats> stats = new LogParser().parseLog(logs);

        for (Map.Entry<String, StatusStats> entry : stats.entrySet()) {
            System.out.println(entry.getKey()
                    + " → count: " + entry.getValue().count
                    + ", avgDuration: " + entry.getValue().avgDuration() + "ms");
        }
    }
}
