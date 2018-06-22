public class Test {

    public static void main(String[] args) {

        Concept concetto = new Concept("1");
        Concept concetto2 = new Concept("2");
        Concept concettoA = new ConceptA(concetto.getId(), concetto);
        Concept concettoC = new ConceptA(concetto2.getId(), concetto);
        Concept concettoB = new ConceptB("2", concettoA);

        ((ConceptB) concettoB).addChild(concettoC);

        System.out.println(((ConceptB) concettoB).getFamilySize());



    }
}
