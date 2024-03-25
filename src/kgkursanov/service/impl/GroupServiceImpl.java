package kgkursanov.service.impl;

import kgkursanov.db.DataBase;
import kgkursanov.models.Group;
import kgkursanov.service.GroupService;

import java.util.Iterator;
import java.util.List;

public class GroupServiceImpl implements GroupService {
    @Override
    public Group addGroup(Group group) {
        DataBase.groups.add(group);
        return group;
    }

    @Override
    public Group getGroupByName(String nameGroup) {
        try {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(nameGroup)){
                System.out.println(group);
            }

        }

    }catch (Exception e){
            System.out.println(e.getMessage() + nameGroup + " Myndai gruppa jok");
        }
        return null;
    }


    @Override
    public Group updateGroupName(String searchName, String newName) {
        Iterator<Group> iterator = DataBase.groups.iterator();
        boolean updated = false;
        while (iterator.hasNext()) {
            Group group = iterator.next();
            if (group.getGroupName().equalsIgnoreCase(searchName)) {
                group.setGroupName(newName);
                updated = true;
                System.out.println("Success!");

            }
        }
        if (!updated) {
            System.out.println("Group '" + searchName + "' not found.");
        }
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        if (!DataBase.groups.isEmpty()) {
            System.out.println(DataBase.groups);
        }else System.out.println("Data Base isEmpty!");
        return DataBase.groups;
    }



    @Override
    public String deleteGroup(String groupName) {
        for (Group group : DataBase.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)){
                DataBase.groups.remove(group);{
                    System.out.println(groupName + " Success deleted");
                }
            }
        }
        return "Error";
    }
}
