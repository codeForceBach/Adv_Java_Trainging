package dataStructureAlgorithms.collection.exercise;

import java.util.*;

/**
 * @author Richard park
 */
public class FamilyCensusService {

    //initialize collection list as Broader collection list so that the list can be transfer to different type of collection for specific logic to perform
    //private Set<FamilyMember> familyMemberList;
    private Collection<FamilyMember> familyMemberList;

    /**
    * Class constructor.
     */
    public FamilyCensusService() {
        familyMemberList = new LinkedHashSet<>();
    }

    /**
     * @ param member each FamilyMember o
     * add each familyMember to the familyMemberList
     */
    public void addFamilyMember(FamilyMember member){
        familyMemberList.add(member);
    }

    public Collection<FamilyMember> getLinkedHashSetList(){
        return this.familyMemberList;
    }
    /**
     * create new familyMember list and only add if the age criteria meet and add to new list since iterator will throw concurrent bound exception.
     * if the original list get modified during iteration
     * after iteration, remove the new list that hold all under age Family member from the original list.
     @param ageLimit criteria to filter out each familyMember by age
     */
    public Collection<FamilyMember> filterByAge(Collection<FamilyMember> list, int ageLimit){
        //create new arraylist to store familyMember with ageLimit
        Collection<FamilyMember> filteredMember = new ArrayList<>();
        for(FamilyMember fm : list){
            if (fm.getAge() > ageLimit){
                filteredMember.add(fm);
                //System.out.println(fm.toString());
            }//end if

        }//end for
        //return filteredMember;
        list.removeAll(filteredMember);
        return filteredMember;
    }

    /**
     * sort each family member based on their last name and first name to group them together as a family
     * use
     */
    public List<FamilyMember> orderByName(){
        List<FamilyMember> orderedList = this.getMemberAsList();
        //Collections.sort(orderedList);
        orderedList.sort(Comparator.naturalOrder());
        return orderedList;
    }

    /**
     * convert the hashSetList to arraylist .
     */
    public List<FamilyMember> getMemberAsList(){
        List <FamilyMember>familyAsList = new ArrayList<>();
        familyAsList.addAll(familyMemberList);
        return familyAsList;
    }

    public Map<String, Integer> getHouseholdMap(){
        Map <String, Integer> familyMap = new HashMap<>();
        for(FamilyMember fm : familyMemberList){
            if (familyMap.containsKey(fm.getLastName())){
                //Integer count = lastNameMap.get(fm.getLastName());
                familyMap.put(fm.getLastName(), familyMap.get(fm.getLastName()) + 1);
                //System.out.println(fm.toString());
            }else{
                //Integer count = 1;
                familyMap.put(fm.getLastName(), 1);
            }
        }//end for
        return familyMap;
    }

    /**
     * iterate over the map and output key and value pair in a line that introduce each household
     * then filter out familyMembers that are same last anme as household member.
     */
    public void printHouseholdMap(){

        Collection<FamilyMember> orderedList = orderByName();
        orderedList = this.filterByAge(orderedList, 18);
        //transfer HashMap to a TreeMap that implement natural order sort
        TreeMap<String, Integer> orderedFamilyMap = new TreeMap<>();
        orderedFamilyMap.putAll(this.getHouseholdMap());

        //iterate over the map to extract key and value pair
        for(Map.Entry<String, Integer> name : orderedFamilyMap.entrySet()){
            String member = name.getValue() == 1 ? "member" : "members";
            System.out.println(name.getKey() +  " family has " + name.getValue() + " " + member);

            //as iterate the map, iterate over familyMemberList to extract same family member by their last name
            for(FamilyMember fm : orderedList){
                if (fm.getLastName().equals(name.getKey())){
                    System.out.println(fm.toString());
                }//end if

            }//end for
        }
    }

    /**
     * iterate over each familyMemberList to extract each familyMember and append to stringBuilder.
     * @return StringBuilder buildlist as string representation.
     */
    public String toString(){
        StringBuilder buildList = new StringBuilder("");
        for(FamilyMember fm : familyMemberList){
            buildList.append(fm.toString() + "\n");
        }
        return buildList.toString();
    }
}
