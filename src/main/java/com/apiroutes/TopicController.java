package com.apiroutes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping(value = "/topics")
    public String addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
//        return topicService.topics;
        return "Successful POST request. Please GET all topics! :)";
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public Topic updateTopic(@PathVariable String id, @RequestParam String newname, @RequestParam String newdesc) {
        Topic newTopic = topicService.updateTopic(id, newname, newdesc);
        return newTopic;
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public String deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
        return "Topic successfully removed";
    }
}
