package com.practise.springboot.com.practise.springboot.topic;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pratik Ambani on 24/12/16.
 */

@RestController
public class TopicController {


    @Autowired
    private TopicService topicService;


    @ApiOperation(value = "returns single topic name", notes = "02. Single Topics")
    @RequestMapping("/singleTopic")
    public String listOfTopics() {
        return "Topic Name";
    }

    @ApiOperation(value = "returns all topics", notes = "03. All Topics")
    @RequestMapping("/allTopics")
    public List<Topic> listOfTopic() {
        return topicService.getAllTopics();
    }

    @ApiOperation(value = "returns all topics", notes = "04. Single topic with user input, observer pathvariable")
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable int id) {
        return topicService.getTopic(id);
    }

    @ApiOperation(value = "adds new topic", notes = "05. First post request")
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }


    @ApiOperation(value = "edits existing topic", notes = "06. First put request")
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
        topicService.updateTopic(topic, id);
    }

    @ApiOperation(value = "deleted existing topic", notes = "07. First delete request")
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
    }



}
