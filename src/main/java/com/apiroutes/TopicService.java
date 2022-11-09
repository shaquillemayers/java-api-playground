package com.apiroutes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    Topic springTopic = new Topic("spring", "Spring Framework", "Spring Framework Description");
    Topic javaTopic = new Topic("java", "Core Java", "Core Java Description");
    Topic javascriptTopic = new Topic("javascript", "Javascript", "Javascript Description");
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            springTopic,
            javaTopic,
            javascriptTopic
    ));
    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
    public Topic updateTopic(String id, String newName, String newDesc) {
        Topic topicToUpdate = topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        topicToUpdate.setName(newName);
        topicToUpdate.setDescription(newDesc);
        return topicToUpdate;
    }

    public void deleteTopic(String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic topic = topics.get(i);
            System.out.println("Topic: " + topic.getId());
            System.out.println("id: " + id);
            if (topic.getId().equals(id)) {
                topics.remove(topic);
            }
        }
    }
}
