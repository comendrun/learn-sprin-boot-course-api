package com.rms.learnspringboot.learnsprinbootcourseapi.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{query}")
    public Topic getTopic(@PathVariable("query") String id) {
        return topicService.getTopic(id);
    }

    // with this function we basically tell to our server, if we get a post request
    // to this address, then it should do the things that we specified below.
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    // 1- here with the RequestBody annotation we are taking the body content that
    // have been sent over post request.
    // 2- then we will consider it as an instance of Topic type.
    // 3- then we will send it to the topicService arrayList so that it will be
    // added to our array
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    // * with this method, we will handle put requests
    @RequestMapping(value = "/topics/{query}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable("query") String id) {
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "/topics/{query}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable("query") String id) {
        topicService.deleteTopic(id);
    }

}
