package com.rms.learnspringboot.learnsprinbootcourseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    // * at first, we created an arrayList with Arrays.asList. but this method, just
    // creates a method that is not mutable (uneditable).
    // * then we had to change some of our code, and we used this syntax : "new
    // ArrayList" to make a new array from those instances of tTopic that we
    // provided.
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "Ingolstadt", "an expensive city, But with restricted community"),
            new Topic("2", "Munchen", "an expensive city, But beautiful"),
            new Topic("3", "Nurnberg", "also an expensive city")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    // here we define a function, that will recieve two parameters from the request.
    // it will process those parameters and will look through our array with the
    // specific id.
    // then it will change the properties of that list that is in that index.
    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }

    }
}
