package kh.study.khspring;

import com.google.common.collect.EvictingQueue;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvictingQueueJsonTest {
    @Test
    void toJson() {
        EvictingQueue<String> queue = EvictingQueue.create(10);

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        queue.add("f");
        String json = new Gson().toJson(queue);
        System.out.println("json = " + json);
    }
}
