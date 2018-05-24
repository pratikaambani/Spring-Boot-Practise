package com.practise.springboot.com.practise.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pratik Ambani on 24/12/16.
 */

@Service
public class TopicService {

    List<Topic> topics = new ArrayList(Arrays.asList(
            new Topic(1, "Bird", "ABC"),
            new Topic(2, "2 States", "DEF"),
            new Topic(3, "3 Mistakes of my life", "GHI")
    ));


    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(int id) {
        return topics.get(id - 1);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, int id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);

            if (t.getId() == id) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(int id) {

        topics.remove(id);
    }
}
