package kgkursanov.service;

import kgkursanov.models.Group;

import java.util.List;

public interface GroupService {

    Group addGroup(Group group);

    Group getGroupByName(String nameGroup);

    Group updateGroupName(String searchName,String newName);

    List<Group> getAllGroups();

    String deleteGroup(String groupName);


}
