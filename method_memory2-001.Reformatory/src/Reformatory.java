public class Reformatory {
private int totalTimesMeasured = 0;

    public int weight(Person person) {
        // return the weight of the person
        totalTimesMeasured++;
        int personWeight = person.getWeight();

        return personWeight;
    }

    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    public int totalWeightsMeasured() {
    return totalTimesMeasured;
    }
}
