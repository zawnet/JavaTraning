package zadanieStaz;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Task {

  /*
  Zwróć listę aktywnych graczy posortowanych po ich wyniku malejąco
   */

    public static List<Person> getActivePlayersByScoreDesc(List<Person> people) {
        List<Person> list = new ArrayList<>();
        list = people.stream().filter(Person::isActive).collect(Collectors.toList());
        Collections.sort(list,new PersonScoreDescComparator());
        return list;
    }

  /*
  Zwróć listę aktywnych graczy z danej grupy posortowanych po ich wyniku malejąco
   */

    public static List<Person> getActivePlayersByScoreDesc(List<Person> people, Group group) {
        List<Person> list = new ArrayList<>();
        list = people.stream().filter(person -> person.getTeam().equals(group))
                .filter(Person::isActive)
                .collect(Collectors.toList());
        Collections.sort(list,new PersonScoreDescComparator());
        return list;
    }

    /*
    Zwróć grupę, która posiada najwyższy wynik. Jeżeli wynik wielu grup jest taki sam, zwróć tę, która ma mniejszą liczbę aktywnych członków.
    Jeżeli ta liczba jest również równa, zwróć którąkolwiek z nich.
     */
    public static Group getGroupWithHighestScore(List<Person> people) {

        Map<Group,List<Person>> byGroupByNumberPersonMap = people.stream()
                .collect(Collectors.groupingBy(Person::getTeam));

        List<TeamResult> scoreSumByGroup = new ArrayList<>();

        for(Map.Entry<Group, List<Person>> entry : byGroupByNumberPersonMap.entrySet()){
            TeamResult teamResult = new TeamResult(entry.getValue(),entry.getValue().stream().mapToInt(Person::getScore).sum(), entry.getKey());
            scoreSumByGroup.add(teamResult);
        }
        TeamResult teamResult = scoreSumByGroup.stream()
                .max(new TeamWithHighestScoreAscComparator()).get();

        return  teamResult.getGroup();
    }

  /*
  Zwróć listę wyników posortowaną malejąco na podstawie ilości punktów per zespół.
  Pojedynczy String powinien mieć format: "NazwaGrupy CałkowityWynik (lista_aktywnych_członków) [ilość nieaktywnych członków]"
   */

    public static List<String> printPoints(List<Person> people) {

        Map<Group,List<Person>> byGroupByNumberPersonMap = people.stream()
                .collect(Collectors.groupingBy(Person::getTeam));

        List<TeamResult> scoreSumByGroup = new ArrayList<>();

        for(Map.Entry<Group, List<Person>> entry : byGroupByNumberPersonMap.entrySet()){
            TeamResult teamResult = new TeamResult(entry.getValue(),entry.getValue().stream().mapToInt(Person::getScore).sum(), entry.getKey());
            scoreSumByGroup.add(teamResult);
        }
        List<TeamResult> teamResult = scoreSumByGroup.stream()
                .sorted(new TeamWithHighestScoreDscComparator())
                .collect(toList());

        List<String> result = new ArrayList<>();

        for (TeamResult team : teamResult){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(team.getGroup());
            stringBuilder.append(" ");
            stringBuilder.append(team.getTeamScore());
            stringBuilder.append(" ");
            stringBuilder.append("("+team.getActivePersons().size()+")");
            stringBuilder.append(" ");
            stringBuilder.append("["+team.getUnactivePersons().size()+"]");
            result.add(stringBuilder.toString());
        }
        return  result;
    }

    public static class PersonScoreDescComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getScore(),o2.getScore())*-1;
        }
    }

    public static class TeamWithHighestScoreAscComparator implements Comparator<TeamResult>{
        @Override
        public int compare(TeamResult o1, TeamResult o2) {
            if(o1.getTeamScore() == o2.getTeamScore()){
                return -1*Integer.compare(o1.getActivePersons().size(), o2.getActivePersons().size());
            }
            else{
                return Integer.compare(o1.teamScore, o2.getTeamScore());
            }
        }
    }

    public static class TeamWithHighestScoreDscComparator implements Comparator<TeamResult>{
        @Override
        public int compare(TeamResult o1, TeamResult o2) {
            if(o1.getTeamScore() == o2.getTeamScore()){
                return Integer.compare(o1.getActivePersons().size(), o2.getActivePersons().size());
            }
            else{
                return -1*Integer.compare(o1.teamScore, o2.getTeamScore());
            }
        }
    }

    public static class TeamResult {
        private List<Person> persons;
        private Integer teamScore;
        private Group group;

        public TeamResult(List<Person> persons, Integer teamScore, Group group) {
            this.persons = persons;
            this.teamScore = teamScore;
            this.group = group;
        }

        public Integer getTeamScore() {
            return teamScore;
        }

        public void setTeamScore(Integer teamScore) {
            this.teamScore = teamScore;
        }

        public Integer getPersonsNumber(){
            return this.persons.size();
        }

        public Group getGroup() {
            return group;
        }

        public List<Person> getActivePersons(){
            return this.persons.stream()
                            .filter(person -> person.isActive())
                            .collect(toList());
        }

        public List<Person> getUnactivePersons(){
            return this.persons.stream()
                    .filter(person -> !person.isActive())
                    .collect(toList());
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Paweł",3,Group.G1,true));
        personList.add(new Person("Paweł2",7,Group.G2,true));
        personList.add(new Person("Paweł3",8,Group.G3,true));
        personList.add(new Person("Paweł4",5,Group.G1,true));
        personList.add(new Person("Paweł5",7,Group.G2,true));

        System.out.println(getActivePlayersByScoreDesc(personList));
        System.out.println(getActivePlayersByScoreDesc(personList,Group.G1));
        System.out.println(getGroupWithHighestScore(personList));
        System.out.println(printPoints(personList));
    }
}