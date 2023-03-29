package javaEssential.fileIo;

import dataStructureAlgorithms.collection.exercise.FamilyMember;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public class InputListHelper {

    private Collection<Member> familyMemberList;

    public InputListHelper() {

        familyMemberList = new LinkedHashSet<>();
    }

    public Collection<Member> getFamilyMemberList() {

        return familyMemberList;
    }

    public void convertStringToMember(String member){
        String[] field = member.split("\",\"");
        //String name = field[0] + field[1];

        /*
        for(String s: field){
            System.out.println(s);
        }
        */
        familyMemberList.add(new Member(field[0], field[1], field[2], field[3], field[4], field[5]));

    }

    public List<Member> getMemberAsList(){
        List <Member> memberList = new ArrayList<>();
        memberList.addAll(familyMemberList);
        return memberList;
    }

}
